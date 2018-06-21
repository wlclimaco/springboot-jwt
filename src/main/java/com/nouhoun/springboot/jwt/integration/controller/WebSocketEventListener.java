package com.nouhoun.springboot.jwt.integration.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.nouhoun.springboot.jwt.integration.domain.ChatMessage;
import com.nouhoun.springboot.jwt.integration.domain.Jogo;
import com.nouhoun.springboot.jwt.integration.domain.Jogo.Processo;
import com.nouhoun.springboot.jwt.integration.domain.Jogo.Status;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorData;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorData.StatusJogoPorData;
import com.nouhoun.springboot.jwt.integration.domain.UserJogo2;
import com.nouhoun.springboot.jwt.integration.domain.UserJogoData;
import com.nouhoun.springboot.jwt.integration.domain.UserJogoData.StatusUserJogoPorData;
import com.nouhoun.springboot.jwt.integration.service.JogoService;

/**
 * Created by rajeevkumarsingh on 25/07/17.
 */
@Component
public class WebSocketEventListener {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	@Autowired
	public JogoService jogoService;

	private FunctionsUtius data = new FunctionsUtius();

	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent event) {
		logger.info("Received a new web socket connection");
	}

	@Scheduled(initialDelay = 10000, fixedRate = 100000)
	public void run() {

		List<Jogo> jogos = jogoService.findJogoByStatus(Status.INDISPONIVEL, Processo.FINALIZAO);
		List<Jogo> jogosClone = new ArrayList<Jogo>();
		if (!jogos.isEmpty()) {
			for (Jogo jogo : jogos) {
				GregorianCalendar gc = new GregorianCalendar();
				JogoPorData jogoPorData = jogoService.saveJogoPorData(
						new JogoPorData(data.shouldDownloadFile2(jogo.getDia(), gc, jogo.getHoraInicial()).getTime(),
								data.shouldDownloadFile2(jogo.getDia(), gc, jogo.getHoraFinal()).getTime(),
								jogo.getId(), jogo.getUsersJogo(), StatusJogoPorData.AJOGAR, jogo.getQuadraId()));
				jogo.setProcesso(Processo.GERADO);
				for (UserJogo2 usesr : jogo.getUsersJogo()) {
					logger.info("Save Jogo por DATA :: " + usesr.getJogo_id());
					jogoService.saveUserJogoData(new UserJogoData(usesr.getUser_id(), jogoPorData.getId(),
							StatusUserJogoPorData.ACONFIRMAR,jogo.getId(),usesr.getAprovadoPor()));
				}
				jogosClone.add(jogo);
			}

			jogoService.saveJogo(jogosClone);
		}	
			jogos = jogoService.findJogoByStatus(Status.INDISPONIVEL, Processo.GERADO);
			if (!jogos.isEmpty()) {
				for (Jogo jogo : jogos) {
					List<JogoPorData> jogoPorDatas = jogoService.findJogoPorDataByStatus(StatusJogoPorData.AJOGAR,jogo.getId());
					for (JogoPorData jogoPorData : jogoPorDatas) {
					if(jogoPorData.getDataFinal().getTime() < (new Date()).getTime()) {
							jogoPorData.setStatus(StatusJogoPorData.JAJOGADO);
							jogoService.saveJogoPorData(jogoPorData);
						}else if(jogoPorData.getData().getDay() == (new Date()).getDay() && (jogoPorData.getData().getMonth() == (new Date()).getMonth()) && (jogoPorData.getData().getYear() == (new Date()).getYear())) {
							jogoPorData.setStatus(StatusJogoPorData.TIRARTIME);
							jogoService.saveJogoPorData(jogoPorData);
						} else if(((new Date()).getTime() >= jogoPorData.getData().getTime()) && ((new Date()).getTime() <= jogoPorData.getDataFinal().getTime())) {
						jogoPorData.setStatus(StatusJogoPorData.JOGANDO);
						jogoService.saveJogoPorData(jogoPorData);
					}
					}
				}
			}

		logger.info("Current time is :: " + Calendar.getInstance().getTime());

}

	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

		String username = (String) headerAccessor.getSessionAttributes().get("username");
		if (username != null) {
			logger.info("User Disconnected : " + username);

			ChatMessage chatMessage = new ChatMessage();
			chatMessage.setType(ChatMessage.MessageType.LEAVE);
			chatMessage.setSender(username);

			messagingTemplate.convertAndSend("/topic/public", chatMessage);
		}
	}
}
