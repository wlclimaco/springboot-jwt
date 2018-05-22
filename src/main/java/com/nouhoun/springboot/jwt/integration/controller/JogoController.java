package com.nouhoun.springboot.jwt.integration.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nouhoun.springboot.jwt.api.APIResponse;
import com.nouhoun.springboot.jwt.integration.domain.Jogo;
import com.nouhoun.springboot.jwt.integration.domain.Jogo.Status;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorData;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorData.StatusJogoPorData;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorDataDTO;
import com.nouhoun.springboot.jwt.integration.domain.Notificacoes;
import com.nouhoun.springboot.jwt.integration.domain.Notificacoes.NotificacoesStatus;
import com.nouhoun.springboot.jwt.integration.domain.Quadra;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.domain.UserJogo2;
import com.nouhoun.springboot.jwt.integration.domain.UserJogo2.Admin;
import com.nouhoun.springboot.jwt.integration.domain.UserJogo2.StatusUser;

@Controller
public class JogoController {

	private FunctionsUtius data = new FunctionsUtius();

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/jogo/update", method = RequestMethod.POST)
	public @ResponseBody APIResponse createNewMensagem(@RequestBody String users)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Jogo user = mapper.readValue(users, Jogo.class);
		ModelAndView modelAndView = new ModelAndView();
		List<String> erros = new ArrayList<String>();

		
		Notificacoes notificacoes = new Notificacoes();
		Quadra quadra = new Quadra();
		User userss =  new User();
		Jogo jogo = new Jogo();
		
		String noticicacaoText = "";//+ quadra.getNome() + " " + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + " " + "" + userss.getEmail() + " " + userss.getLastName(); 
		switch (user.getStatus()) {
		case DISPONIVEL:
			data.jogoService.saveUpdateJogo(user);
			notificacoes = new Notificacoes("DISPONIVEL", new Date(), "Titulo DISPONIVEL", NotificacoesStatus.NAOLIDO, 10, 8);
			break;
		case ACONFIRMAR:
			quadra = data.quadraService.findAllQuadraById(user.getQuadraId());
			userss =  data.userService.findUserById(user.getUser_id());
			jogo = data.jogoService.findJogoById(user.getId());
			data.jogoService.saveUpdateJogo(user);
			List<UserJogo2> userJogos = new ArrayList<UserJogo2>();
			userJogos.add(new UserJogo2(user.getUser_id(),user.getId(),StatusUser.CONFIRMADO,Admin.SIM));
			data.jogoUserService.saveUserJogo(userJogos);
			noticicacaoText = "Acabo de ser solicitado na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Solicitado por : " + userss.getEmail() + " " + userss.getLastName(); 
			notificacoes = new Notificacoes("ACONFIRMAR", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, userss.getId(), 82);
			notificacoes.setParaJogoId(user.getId());
			notificacoes.setParaEmprId(82);
			break;
		case OCUPADO:
			data.jogoService.saveUpdateJogo(user);
			notificacoes = new Notificacoes("OCUPADO", new Date(), "Titulo OCUPADO", NotificacoesStatus.NAOLIDO, 10,8);
			break;
		case INDISPONIVEL:
			Jogo jogoa = data.jogoService.findJogoById(user.getId());
		//	jogoService.updateStatus(Status.INDISPONIVEL,user.getId());
			jogoa.setStatus(Status.INDISPONIVEL);
			data.jogoService.saveUpdateJogo(jogoa);
			quadra = data.quadraService.findAllQuadraById(user.getQuadraId());
			userss =  data.userService.findUserById(user.getUser_id());
			user.setUsersJogo2(data.jogoUserService.findJogoUserByJogoId(user.getId()));
			
			for (UserJogo2 userJogo2 : user.getUsersJogo2()) {
				if(Admin.SIM.equals(userJogo2.getAdmin())) {
					noticicacaoText = "Foi Aprovado na quadra : " + quadra.getNome() + " dia: " +jogoa.getDia().name().toLowerCase() + " horario (" + jogoa.getHoraInicial() + " - " + jogoa.getHoraFinal() + "). " + "Aprovado por : " + userss.getEmail() + " " + userss.getLastName(); 
					notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO,userss.getId(),82);
					notificacoes.setParaJogoId(jogoa.getId());
					notificacoes.setParaUserId(userss.getId());
					data.notificacoesService.insertNotificacoes(notificacoes);
				}
			}
		//	notificacoes = new Notificacoes("INDISPONIVEL", new Date(), "Titulo INDISPONIVEL", NotificacoesStatus.NAOLIDO, 10,8);
		//	notificacoes.setParaJogoId(user.getId());
			
			break;
		case CONFIRMAR:
			data.jogoService.saveUpdateJogo(user);
			notificacoes = new Notificacoes("CONFIRMAR", new Date(), "Titulo CONFIRMAR", NotificacoesStatus.NAOLIDO, 10,8);
			break;
		case DESMARCAR:
			notificacoes = new Notificacoes("DESMARCAR", new Date(), "Titulo DESMARCAR", NotificacoesStatus.NAOLIDO, 10,8);
			break;
			
		case SOLICITAR:
			List<UserJogo2> userJogos1 = new ArrayList<UserJogo2>();
			userJogos1.add(new UserJogo2(user.getUser_id(),user.getId(),StatusUser.SOLICITADO,Admin.NAO));
			data.jogoUserService.saveUserJogo(userJogos1);
			notificacoes = new Notificacoes("SOLICITAR", new Date(), "Titulo SOLICITAR", NotificacoesStatus.NAOLIDO, 10,8);
			break;

		default:
			break;
		}
		data.notificacoesService.insertNotificacoes(notificacoes);
		HashMap<String, Object> authResp = new HashMap<String, Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object token = auth.getCredentials();
		authResp.put("token", token);
		authResp.put("user", user);
		authResp.put("Error", erros);

		return APIResponse.toOkResponse(authResp);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/jogo/updateJogoPorData", method = RequestMethod.POST)
	public @ResponseBody APIResponse updateJogoPorData(@RequestBody String users)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JogoPorDataDTO user = mapper.readValue(users, JogoPorDataDTO.class);
		ModelAndView modelAndView = new ModelAndView();
		List<String> erros = new ArrayList<String>();
		
		Jogo jogo = data.jogoService.findJogoById(user.getJogoId());
		Quadra quadra = data.quadraService.findAllQuadraById(jogo.getQuadraId());
		User userss =  data.userService.findUserById(user.getUser_id());
		String noticicacaoText = "";
		Notificacoes notificacoes = new Notificacoes();
//		switch (user.getStatus()) {
//		case CONFIRMADO:
//			data.jogoService.saveJogoPorData(new JogoPorData(user));
//			for (UserJogo2 userJogo2 : jogo.getUsersJogo2()) {
//				noticicacaoText = userss.getEmail() + " " + userss.getLastName() +" foi aprovado e participara do racha na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + ")." + "Solicitado por : " + userss.getEmail() + " " + userss.getLastName(); 
//				notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, 10,8);
//				notificacoes.setParaJogoId(jogo.getId());
//				notificacoes.setParaUserId(userJogo2.getUser_id());
//				data.notificacoesService.insertNotificacoes(notificacoes);
//			}
//			noticicacaoText = "Parabens foi APROVADA sua solicitação para o racha na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Solicitado por : " + userss.getEmail() + " " + userss.getLastName(); 
//			notificacoes = new Notificacoes("TALVEZ", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogoId()); 
//			//notificacoes = new Notificacoes("CONFIRMADO", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogo_id());
//			break;
//		case NAOVO:
//			data.jogoService.saveJogoPorData(new JogoPorData(user));
//			for (UserJogo2 userJogo2 : jogo.getUsersJogo2()) {
//				if(Admin.SIM.equals(userJogo2.getAdmin())) {
//					noticicacaoText = "Foi Recusado solicitação de "+ userss.getEmail() + " " + userss.getLastName() +" na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Solicitado por : " + userss.getEmail() + " " + userss.getLastName(); 
//					notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, 10,8);
//					notificacoes.setParaJogoId(jogo.getId());
//					notificacoes.setParaUserId(userJogo2.getUser_id());
//					data.notificacoesService.insertNotificacoes(notificacoes);
//				}
//			}
//			noticicacaoText = "Infelizmente solicitação para o racha na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Não foi aprovado por : " + userss.getEmail() + " " + userss.getLastName();
//			notificacoes = new Notificacoes("TALVEZ", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogoId());
//			break;
//			
//		case TALVEZ:
//			data.jogoService.saveJogoPorData(new JogoPorData(user));
//			for (UserJogo2 userJogo2 : jogo.getUsersJogo2()) {
//				if(Admin.SIM.equals(userJogo2.getAdmin())) {
//					noticicacaoText = "Foi Recusado solicitação de "+ userss.getEmail() + " " + userss.getLastName() +" na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Solicitado por : " + userss.getEmail() + " " + userss.getLastName();  
//					notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, 10,8);
//					notificacoes.setParaJogoId(jogo.getId());
//					notificacoes.setParaUserId(userJogo2.getUser_id());
//					data.notificacoesService.insertNotificacoes(notificacoes);
//				}
//			}
//			noticicacaoText = "Infelizmente solicitação para o racha na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Não foi aprovado por : " + userss.getEmail() + " " + userss.getLastName();
//			notificacoes = new Notificacoes("TALVEZ", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogoId());
//			break;
//		default:
//			break;
//		}
//
//	
//		data.notificacoesService.insertNotificacoes(notificacoes);
		HashMap<String, Object> authResp = new HashMap<String, Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object token = auth.getCredentials();
		authResp.put("token", token);
		authResp.put("user", user);
		authResp.put("Error", erros);

		return APIResponse.toOkResponse(authResp);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/jogo/aprovarJogador", method = RequestMethod.POST)
	public @ResponseBody APIResponse aprovarJogador(@RequestBody String users)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		UserJogo2 user = mapper.readValue(users, UserJogo2.class);
		ModelAndView modelAndView = new ModelAndView();
		List<String> erros = new ArrayList<String>();

		Jogo jogo = data.jogoService.findJogoById(user.getJogo_id());
		Quadra quadra = data.quadraService.findAllQuadraById(jogo.getQuadraId());
		User userss =  data.userService.findUserById(user.getUser_id());
		User userAprov =  data.userService.findUserById(user.getAprovadoPor());
		String noticicacaoText = "";
		Notificacoes notificacoes = new Notificacoes();
		switch (user.getStatus_user()) {
		case CONFIRMADO:
			data.jogoUserService.saveUserJogo(Arrays.asList(user));
			for (UserJogo2 userJogo2 : jogo.getUsersJogo2()) {
				noticicacaoText = userss.getEmail() + " " + userss.getLastName() +" foi aprovado e participara do racha na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + ")." + "Aprovado por : " + userAprov.getEmail() + " " + userAprov.getLastName(); 
				notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, 10,8);
				notificacoes.setParaJogoId(jogo.getId());
				notificacoes.setParaUserId(userJogo2.getUser_id());
				data.notificacoesService.insertNotificacoes(notificacoes);
			}
			noticicacaoText = "Parabens foi APROVADA sua solicitação para o racha na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Aprovado por : " + userAprov.getEmail() + " " + userAprov.getLastName(); 
			notificacoes = new Notificacoes("TALVEZ", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogo_id()); 
			//notificacoes = new Notificacoes("CONFIRMADO", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogo_id());
			break;
		case RECUSADO:
			data.jogoUserService.saveUserJogo(Arrays.asList(user));
			for (UserJogo2 userJogo2 : jogo.getUsersJogo2()) {
				if(Admin.SIM.equals(userJogo2.getAdmin())) {
					noticicacaoText = "Foi Recusado solicitação de "+ userss.getEmail() + " " + userss.getLastName() +" na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Recusado por : " + userAprov.getEmail() + " " + userAprov.getLastName(); 
					notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, 10,8);
					notificacoes.setParaJogoId(jogo.getId());
					notificacoes.setParaUserId(userJogo2.getUser_id());
					data.notificacoesService.insertNotificacoes(notificacoes);
				}
			}
			noticicacaoText = "Infelizmente solicitação para o racha na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Não foi aprovado por : " + userss.getEmail() + " " + userss.getLastName();
			notificacoes = new Notificacoes("TALVEZ", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogo_id());
			break;
		default:
			break;
		}
		user.setAprovadoDate(new Date());
		notificacoes.setParaJogoId(jogo.getId());
		notificacoes.setParaUserId(user.getUser_id());
		data.notificacoesService.insertNotificacoes(notificacoes);
		HashMap<String, Object> authResp = new HashMap<String, Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object token = auth.getCredentials();
		authResp.put("token", token);
		authResp.put("user", user);
		authResp.put("Error", erros);

		return APIResponse.toOkResponse(authResp);
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/jogo/insertUserJogo", method = RequestMethod.POST)
	public @ResponseBody APIResponse insertJogoPorData(@RequestBody String users)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		UserJogo2 user = mapper.readValue(users, UserJogo2.class);
		ModelAndView modelAndView = new ModelAndView();
		List<String> erros = new ArrayList<String>();
		
		Jogo jogo = data.jogoService.findJogoById(user.getJogo_id());
		Quadra quadra = data.quadraService.findAllQuadraById(jogo.getQuadraId());
		User userss =  data.userService.findUserById(user.getUser_id());

		Notificacoes notificacoes = new Notificacoes();
		String noticicacaoText = "";
		switch (user.getStatus_user()) {
		case CONFIRMADO:
			
			for (UserJogo2 userJogo2 : jogo.getUsersJogo2()) {
				noticicacaoText = userss.getEmail() + " " + userss.getLastName() +" foi aprovado e participara do racha na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). "; 
				notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, 10,8);
				notificacoes.setParaJogoId(jogo.getId());
				notificacoes.setParaUserId(userJogo2.getUser_id());
				data.notificacoesService.insertNotificacoes(notificacoes);
			}
			noticicacaoText = "Parabens foi APROVADA sua solicitação para o racha na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Aprovado por : " + userss.getEmail() + " " + userss.getLastName(); 
			notificacoes = new Notificacoes("TALVEZ", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogo_id()); 
			//notificacoes = new Notificacoes("CONFIRMADO", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogo_id());
			break;
		case SOLICITADO:
			
			for (UserJogo2 userJogo2 : jogo.getUsersJogo2()) {
				if(Admin.SIM.equals(userJogo2.getAdmin())) {
					noticicacaoText = "Tem uma nova solicitação("+ userss.getEmail() + " " + userss.getLastName() +") para o racha na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). "; 
					notificacoes = new Notificacoes("SOLICITADO", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, 10,8);
					notificacoes.setParaJogoId(jogo.getId());
					notificacoes.setParaUserId(userJogo2.getUser_id());
					data.notificacoesService.insertNotificacoes(notificacoes);
				}
				
				
			}
			noticicacaoText = "Sua solicitação para o racha na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "foi enviado para o administrador do racha ";
			notificacoes = new Notificacoes("SOLICITADO", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogo_id()); 
			break;
		case RECUSADO:
			for (UserJogo2 userJogo2 : jogo.getUsersJogo2()) {
				if(Admin.SIM.equals(userJogo2.getAdmin())) {
					noticicacaoText = "Foi Aprovado na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Aprovado por : " + userss.getEmail() + " " + userss.getLastName(); 
					notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, 10,8);
					notificacoes.setParaJogoId(jogo.getId());
					notificacoes.setParaUserId(userJogo2.getUser_id());
					data.notificacoesService.insertNotificacoes(notificacoes);
				}
			}
			noticicacaoText = "Infelizmente solicitação para o racha na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Não foi aprovado por : " + userss.getEmail() + " " + userss.getLastName();
			notificacoes = new Notificacoes("TALVEZ", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogo_id());
			break;

		default:
			break;
		}
		user.setAprovadoDate(new Date());
		notificacoes.setParaJogoId(jogo.getId());
		notificacoes.setParaUserId(user.getUser_id());
		data.notificacoesService.insertNotificacoes(notificacoes);
		data.jogoUserService.saveUserJogo(Arrays.asList(user));
		HashMap<String, Object> authResp = new HashMap<String, Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object token = auth.getCredentials();
		authResp.put("token", token);
		authResp.put("userJogo", user);
		authResp.put("Error", erros);

		return APIResponse.toOkResponse(authResp);
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/jogo/createNovo", method = RequestMethod.POST)
	public @ResponseBody APIResponse createNovo(@RequestBody String jog)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
	//	Jogo user = mapper.readValue(jog, Jogo.class);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // você pode usar outras máscaras
		Jogo jogo = data.jogoService.findJogoById(Integer.parseInt(jog));
		List<JogoPorData> jogosData = new ArrayList<JogoPorData>();
		for (UserJogo2 user : jogo.getUsersJogo2()) {
			if(user.getStatus_user().equals(StatusUser.CONFIRMADO))
			{
//				GregorianCalendar gc = new GregorianCalendar();
//				jogosData.add(new JogoPorData(data.shouldDownloadFile2(jogo.getDia(),gc,jogo.getHoraInicial()).getTime(),data.shouldDownloadFile2(jogo.getDia(),gc,jogo.getHoraFinal()).getTime(), jogo.getId(), user.getUser_id(), StatusJogoPorData.ACONFIRMAR, 0, 0,
//				jogo.getQuadraId()));
			}
		}
//		List<Jogo> jogos = jogoService.findAllJogo();
//		List<JogoPorData> jogosData = new ArrayList<JogoPorData>();
//		for (Jogo jogo : jogos) {
//			System.out.println(jogo.getStatus());
//			if(jogo.getStatus().equals(Status.INDISPONIVEL))
//			{
//				for (UserJogo2 user : jogo.getUsersJogo2()) {
//					if(user.getStatus_user().equals(StatusUser.CONFIRMADO))
//					{
//						GregorianCalendar gc = new GregorianCalendar();
//				jogosData.add(new JogoPorData(shouldDownloadFile2(jogo.getDia(),gc,jogo.getHoraInicial()).getTime(),shouldDownloadFile2(jogo.getDia(),gc,jogo.getHoraFinal()).getTime(), jogo.getId(), user.getUser_id(), StatusJogoPorData.ACONFIRMAR, 0, 0,
//						jogo.getQuadraId()));
//					}
//				}
//			}
//		}
		data.jogoService.saveJogoPorData(jogosData);
		HashMap<String, Object> authResp = new HashMap<String, Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object token = auth.getCredentials();
		authResp.put("token", token);
		authResp.put("jogo", jogo);
		authResp.put("Error", "");

		return APIResponse.toOkResponse(authResp);
	}
	//
	// //@CrossOrigin(origins = "*")
	// @RequestMapping(value = "/raxa/delete", method = RequestMethod.POST)
	// public @ResponseBody APIResponse deleteMensagem(@Valid User user,
	// BindingResult bindingResult) {
	// ModelAndView modelAndView = new ModelAndView();
	// List<String> erros = new ArrayList<String>();
	// User userExists = userService.findUserByEmail(user.getEmail());
	// if (userExists != null) {
	// erros.add("There is already a user registered with the email provided");
	// }
	//
	// userService.saveUser(user);
	// modelAndView.addObject("successMessage", "User has been registered
	// successfully");
	// modelAndView.addObject("user", new User());
	// modelAndView.setViewName("registration");
	//
	//
	// HashMap<String, Object> authResp = new HashMap<String, Object>();
	// Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	//
	// Object token = auth.getCredentials();
	// authResp.put("token", token);
	// authResp.put("user", user);
	// authResp.put("Error", erros);
	//
	//
	// return APIResponse.toOkResponse(authResp);
	// }
	//
	// //@CrossOrigin(origins = "*")
	// @RequestMapping(value = "/raxa/fetchByUser", method = RequestMethod.POST)
	// public @ResponseBody APIResponse fetchByUser(@Valid User user, BindingResult
	// bindingResult) {
	// ModelAndView modelAndView = new ModelAndView();
	// List<String> erros = new ArrayList<String>();
	// User userExists = userService.findUserByEmail(user.getEmail());
	// if (userExists != null) {
	// erros.add("There is already a user registered with the email provided");
	// }
	//
	// userService.saveUser(user);
	// modelAndView.addObject("successMessage", "User has been registered
	// successfully");
	// modelAndView.addObject("user", new User());
	// modelAndView.setViewName("registration");
	//
	//
	// HashMap<String, Object> authResp = new HashMap<String, Object>();
	// Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	//
	// Object token = auth.getCredentials();
	// authResp.put("token", token);
	// authResp.put("user", user);
	// authResp.put("Error", erros);
	//
	//
	// return APIResponse.toOkResponse(authResp);
	// }
	//
	// private void createAuthResponse(User user, HashMap<String, Object>
	// authResp,ArrayList<String> erros) {
	// String token = "";
	// //Jwts.builder().setSubject(user.getEmail())
	// // .claim("role", user.getRole().name()).setIssuedAt(new Date())
	// // .signWith(SignatureAlgorithm.HS256, JWTTokenAuthFilter.JWT_KEY).compact();
	// authResp.put("token", token);
	// authResp.put("user", user);
	// authResp.put("Error", erros);
	// }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/jogo/findJogoByUser", method = RequestMethod.POST)
	public ResponseEntity<List<Jogo>> findAllQuadraById(@RequestBody String users)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(users, User.class);

		List<Jogo> quadra = data.jogoService.findJogoByUser(user.getId());

		return new ResponseEntity<List<Jogo>>(quadra, HttpStatus.OK);
	}

}
