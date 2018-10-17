package com.nouhoun.springboot.jwt.integration.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.nouhoun.springboot.jwt.integration.domain.InfoUser;
import com.nouhoun.springboot.jwt.integration.domain.Jogo;
import com.nouhoun.springboot.jwt.integration.domain.Jogo.Processo;
import com.nouhoun.springboot.jwt.integration.domain.Jogo.Status;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorData;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorData.StatusJogoPorData;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorDataDTO;
import com.nouhoun.springboot.jwt.integration.domain.NotasGols;
import com.nouhoun.springboot.jwt.integration.domain.NotasGolsDTO;
import com.nouhoun.springboot.jwt.integration.domain.Notificacoes;
import com.nouhoun.springboot.jwt.integration.domain.Notificacoes.NotificacoesStatus;
import com.nouhoun.springboot.jwt.integration.domain.Quadra;
import com.nouhoun.springboot.jwt.integration.domain.TirarTime;
import com.nouhoun.springboot.jwt.integration.domain.UserJogo2;
import com.nouhoun.springboot.jwt.integration.domain.UserJogo2.Admin;
import com.nouhoun.springboot.jwt.integration.domain.UserJogo2.StatusUser;
import com.nouhoun.springboot.jwt.integration.domain.UserJogoData;
import com.nouhoun.springboot.jwt.integration.domain.UserJogoData.StatusUserJogoPorData;
import com.nouhoun.springboot.jwt.integration.domain.security.User;
import com.nouhoun.springboot.jwt.integration.service.JogoService;
import com.nouhoun.springboot.jwt.integration.service.JogoUserService;
import com.nouhoun.springboot.jwt.integration.service.NotificacoesService;
import com.nouhoun.springboot.jwt.integration.service.QuadraService;
import com.nouhoun.springboot.jwt.integration.service.UserService;

@Controller
public class JogoController {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

	@Autowired
	public JogoService jogoService;
	@Autowired
	public QuadraService quadraService;
	@Autowired
	public UserService userService;
	@Autowired
	public NotificacoesService notificacoesService;
	@Autowired
	public JogoUserService jogoUserService;

	private FunctionsUtius data = new FunctionsUtius();

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/userJogoData/update", method = RequestMethod.POST)
	public @ResponseBody APIResponse userJogoData(@RequestBody String notasGolsDTO)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		NotasGolsDTO notasGols = mapper.readValue(notasGolsDTO, NotasGolsDTO.class);

		jogoService.saveUserNotasGols(notasGols.getNotasGols());

		List<String> erros = new ArrayList<String>();

		// Notificacoes notificacoes = new Notificacoes("DISPONIVEL", new Date(),
		// "Titulo DISPONIVEL", NotificacoesStatus.NAOLIDO, user.getId(), 8);

		// jogoService.saveUserJogoData(user.getUserJogoData());
		// notificacoesService.insertNotificacoes(notificacoes);
		HashMap<String, Object> authResp = new HashMap<String, Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object token = auth.getCredentials();
		authResp.put("token", token);
		// authResp.put("user", user);
		authResp.put("Error", erros);

		return APIResponse.toOkResponse(authResp);
	}

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
		User userss = new User();
		Jogo jogo = new Jogo();

		String noticicacaoText = "";// + quadra.getNome() + " " + jogo.getHoraInicial() + " - " +
									// jogo.getHoraFinal() + " " + "" + userss.getEmail() + " " + userss.getUsername();
		switch (user.getStatus()) {
		case DISPONIVEL:
			jogoService.saveUpdateJogo(user);
			notificacoes = new Notificacoes("DISPONIVEL", new Date(), "Titulo DISPONIVEL", NotificacoesStatus.NAOLIDO,
					10, 8);
			break;
		case ACONFIRMAR:
			quadra = quadraService.findAllQuadraById(user.getQuadraId());
			userss = userService.findUserById(user.getUser_id());
			jogo = jogoService.findJogoById(user.getId());
			jogoService.saveUpdateJogo(user);
			List<UserJogo2> userJogos = new ArrayList<UserJogo2>();
			userJogos.add(new UserJogo2(user.getUser_id(), user.getId(), StatusUser.CONFIRMADO, Admin.SIM));
			jogoUserService.saveUserJogo(userJogos);
			noticicacaoText = "Acabo de ser solicitado na quadra : " + quadra.getNome() + " dia: "
					+ jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - "
					+ jogo.getHoraFinal() + "). " + "Solicitado por : " + userss.getEmail() + " " + userss.getUsername();
			notificacoes = new Notificacoes("ACONFIRMAR", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO,
					userss.getId(), 82);
			notificacoes.setParaJogoId(user.getId());
			notificacoes.setParaEmprId(82);
			break;
		case OCUPADO:
			jogoService.saveUpdateJogo(user);
			notificacoes = new Notificacoes("OCUPADO", new Date(), "Titulo OCUPADO", NotificacoesStatus.NAOLIDO, new Long(10), 8);
			break;
		case INDISPONIVEL:
			Jogo jogoa = jogoService.findJogoById(user.getId());
			// jogoService.updateStatus(Status.INDISPONIVEL,user.getId());
			jogoa.setStatus(Status.INDISPONIVEL);
			jogoService.saveUpdateJogo(jogoa);
			quadra = quadraService.findAllQuadraById(user.getQuadraId());
			userss = userService.findUserById(user.getUser_id());
			user.setUsersJogo(jogoUserService.findJogoUserByJogoId(user.getId()));

			for (UserJogo2 userJogo2 : user.getUsersJogo()) {
				if (Admin.SIM.equals(userJogo2.getAdmin())) {
					noticicacaoText = "Foi Aprovado na quadra : " + quadra.getNome() + " dia: "
							+ jogoa.getDia().name().toLowerCase() + " horario (" + jogoa.getHoraInicial() + " - "
							+ jogoa.getHoraFinal() + "). " + "Aprovado por : " + userss.getEmail() + " "
							+ userss.getUsername();
					notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText,
							NotificacoesStatus.NAOLIDO, userss.getId(), 82);
					notificacoes.setParaJogoId(jogoa.getId());
					notificacoes.setParaUserId(userss.getId().intValue());
					notificacoesService.insertNotificacoes(notificacoes);
				}
			}
			// notificacoes = new Notificacoes("INDISPONIVEL", new Date(), "Titulo
			// INDISPONIVEL", NotificacoesStatus.NAOLIDO, 10,8);
			// notificacoes.setParaJogoId(user.getId());

			break;
		case CONFIRMAR:
			jogoService.saveUpdateJogo(user);
			notificacoes = new Notificacoes("CONFIRMAR", new Date(), "Titulo CONFIRMAR", NotificacoesStatus.NAOLIDO, 10,
					8);
			break;
		case DESMARCAR:
			notificacoes = new Notificacoes("DESMARCAR", new Date(), "Titulo DESMARCAR", NotificacoesStatus.NAOLIDO, 10,
					8);
			break;

		case SOLICITAR:
			List<UserJogo2> userJogos1 = new ArrayList<UserJogo2>();
			userJogos1.add(new UserJogo2(user.getUser_id(), user.getId(), StatusUser.SOLICITADO, Admin.NAO));
			jogoUserService.saveUserJogo(userJogos1);
			notificacoes = new Notificacoes("SOLICITAR", new Date(), "Titulo SOLICITAR", NotificacoesStatus.NAOLIDO, 10,
					8);
			break;

		default:
			break;
		}
		notificacoesService.insertNotificacoes(notificacoes);
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

		Jogo jogo = jogoService.findJogoById(user.getJogoId());
		Quadra quadra = quadraService.findAllQuadraById(jogo.getQuadraId());
		User userss = userService.findUserById(user.getUser_id());
		String noticicacaoText = "";
		Notificacoes notificacoes = new Notificacoes();
		// switch (user.getStatus()) {
		// case CONFIRMADO:
		// jogoService.saveJogoPorData(new JogoPorData(user));
		// for (UserJogo2 userJogo2 : jogo.getUsersJogo()) {
		// noticicacaoText = userss.getEmail() + " " + userss.getUsername() +" foi aprovado
		// e participara do racha na quadra : " + quadra.getNome() + " dia: "
		// +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() +
		// " - " + jogo.getHoraFinal() + ")." + "Solicitado por : " + userss.getEmail()
		// + " " + userss.getUsername();
		// notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText,
		// NotificacoesStatus.NAOLIDO, 10,8);
		// notificacoes.setParaJogoId(jogo.getId());
		// notificacoes.setParaUserId(userJogo2.getUser_id());
		// notificacoesService.insertNotificacoes(notificacoes);
		// }
		// noticicacaoText = "Parabens foi APROVADA sua solicitação para o racha na
		// quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase()
		// + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). "
		// + "Solicitado por : " + userss.getEmail() + " " + userss.getUsername();
		// notificacoes = new Notificacoes("TALVEZ", new Date(), noticicacaoText,
		// NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogoId());
		// //notificacoes = new Notificacoes("CONFIRMADO", new Date(), noticicacaoText,
		// NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogo_id());
		// break;
		// case NAOVO:
		// jogoService.saveJogoPorData(new JogoPorData(user));
		// for (UserJogo2 userJogo2 : jogo.getUsersJogo()) {
		// if(Admin.SIM.equals(userJogo2.getAdmin())) {
		// noticicacaoText = "Foi Recusado solicitação de "+ userss.getEmail() + " " +
		// userss.getUsername() +" na quadra : " + quadra.getNome() + " dia: "
		// +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() +
		// " - " + jogo.getHoraFinal() + "). " + "Solicitado por : " + userss.getEmail()
		// + " " + userss.getUsername();
		// notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText,
		// NotificacoesStatus.NAOLIDO, 10,8);
		// notificacoes.setParaJogoId(jogo.getId());
		// notificacoes.setParaUserId(userJogo2.getUser_id());
		// notificacoesService.insertNotificacoes(notificacoes);
		// }
		// }
		// noticicacaoText = "Infelizmente solicitação para o racha na quadra : " +
		// quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario
		// (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Não foi
		// aprovado por : " + userss.getEmail() + " " + userss.getUsername();
		// notificacoes = new Notificacoes("TALVEZ", new Date(), noticicacaoText,
		// NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogoId());
		// break;
		//
		// case TALVEZ:
		// jogoService.saveJogoPorData(new JogoPorData(user));
		// for (UserJogo2 userJogo2 : jogo.getUsersJogo()) {
		// if(Admin.SIM.equals(userJogo2.getAdmin())) {
		// noticicacaoText = "Foi Recusado solicitação de "+ userss.getEmail() + " " +
		// userss.getUsername() +" na quadra : " + quadra.getNome() + " dia: "
		// +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() +
		// " - " + jogo.getHoraFinal() + "). " + "Solicitado por : " + userss.getEmail()
		// + " " + userss.getUsername();
		// notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText,
		// NotificacoesStatus.NAOLIDO, 10,8);
		// notificacoes.setParaJogoId(jogo.getId());
		// notificacoes.setParaUserId(userJogo2.getUser_id());
		// notificacoesService.insertNotificacoes(notificacoes);
		// }
		// }
		// noticicacaoText = "Infelizmente solicitação para o racha na quadra : " +
		// quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario
		// (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Não foi
		// aprovado por : " + userss.getEmail() + " " + userss.getUsername();
		// notificacoes = new Notificacoes("TALVEZ", new Date(), noticicacaoText,
		// NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogoId());
		// break;
		// default:
		// break;
		// }
		//
		//
		// notificacoesService.insertNotificacoes(notificacoes);
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

		Jogo jogo = jogoService.findJogoById(user.getJogo_id());
		Quadra quadra = quadraService.findAllQuadraById(jogo.getQuadraId());
		User userss = userService.findUserById(user.getUser_id());
		User userAprov = userService.findUserById(user.getAprovadoPor());
		String noticicacaoText = "";
		Notificacoes notificacoes = new Notificacoes();
		switch (user.getStatus_user()) {
		case CONFIRMADO:
			jogoUserService.saveUserJogo(Arrays.asList(user));
			for (UserJogo2 userJogo2 : jogo.getUsersJogo()) {
				noticicacaoText = userss.getEmail() + " " + userss.getUsername()
						+ " foi aprovado e participara do racha na quadra : " + quadra.getNome() + " dia: "
						+ jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - "
						+ jogo.getHoraFinal() + ")." + "Aprovado por : " + userAprov.getEmail() + " "
						+ userAprov.getUsername();
				notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO,
						10, 8);
				notificacoes.setParaJogoId(jogo.getId());
				notificacoes.setParaUserId(userJogo2.getUser_id());
				notificacoesService.insertNotificacoes(notificacoes);
			}
			noticicacaoText = "Parabens foi APROVADA sua solicitação para o racha na quadra : " + quadra.getNome()
					+ " dia: " + jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - "
					+ jogo.getHoraFinal() + "). " + "Aprovado por : " + userAprov.getEmail() + " "
					+ userAprov.getUsername();
			notificacoes = new Notificacoes("TALVEZ", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO,
					user.getUser_id(), user.getJogo_id());
			// notificacoes = new Notificacoes("CONFIRMADO", new Date(), noticicacaoText,
			// NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogo_id());
			break;
		case RECUSADO:
			jogoUserService.saveUserJogo(Arrays.asList(user));
			for (UserJogo2 userJogo2 : jogo.getUsersJogo()) {
				if (Admin.SIM.equals(userJogo2.getAdmin())) {
					noticicacaoText = "Foi Recusado solicitação de " + userss.getEmail() + " " + userss.getUsername()
							+ " na quadra : " + quadra.getNome() + " dia: " + jogo.getDia().name().toLowerCase()
							+ " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). "
							+ "Recusado por : " + userAprov.getEmail() + " " + userAprov.getUsername();
					notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText,
							NotificacoesStatus.NAOLIDO, 10, 8);
					notificacoes.setParaJogoId(jogo.getId());
					notificacoes.setParaUserId(userJogo2.getUser_id());
					notificacoesService.insertNotificacoes(notificacoes);
				}
			}
			noticicacaoText = "Infelizmente solicitação para o racha na quadra : " + quadra.getNome() + " dia: "
					+ jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - "
					+ jogo.getHoraFinal() + "). " + "Não foi aprovado por : " + userss.getEmail() + " "
					+ userss.getUsername();
			notificacoes = new Notificacoes("TALVEZ", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO,
					user.getUser_id(), user.getJogo_id());
			break;
		default:
			break;
		}
		if (jogo.getProcesso().equals(Processo.GERADO)) {
			insertProximoJogoPorData(jogo, user);
		}
		user.setAprovadoDate(new Date());
		notificacoes.setParaJogoId(jogo.getId());
		notificacoes.setParaUserId(user.getUser_id());
		notificacoesService.insertNotificacoes(notificacoes);
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

		Jogo jogo = jogoService.findJogoById(user.getJogo_id());
		Quadra quadra = quadraService.findAllQuadraById(jogo.getQuadraId());
		User userss = userService.findUserById(user.getUser_id());

		Notificacoes notificacoes = new Notificacoes();
		String noticicacaoText = "";
		switch (user.getStatus_user()) {
		case CONFIRMADO:

			for (UserJogo2 userJogo2 : jogo.getUsersJogo()) {
				noticicacaoText = userss.getEmail() + " " + userss.getUsername()
						+ " foi aprovado e participara do racha na quadra : " + quadra.getNome() + " dia: "
						+ jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - "
						+ jogo.getHoraFinal() + "). ";
				notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO,
						10, 8);
				notificacoes.setParaJogoId(jogo.getId());
				notificacoes.setParaUserId(userJogo2.getUser_id());
				notificacoesService.insertNotificacoes(notificacoes);
			}
			noticicacaoText = "Parabens foi APROVADA sua solicitação para o racha na quadra : " + quadra.getNome()
					+ " dia: " + jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - "
					+ jogo.getHoraFinal() + "). " + "Aprovado por : " + userss.getEmail() + " " + userss.getUsername();
			notificacoes = new Notificacoes("TALVEZ", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO,
					user.getUser_id(), user.getJogo_id());
			// notificacoes = new Notificacoes("CONFIRMADO", new Date(), noticicacaoText,
			// NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogo_id());
			break;
		case SOLICITADO:

			for (UserJogo2 userJogo2 : jogo.getUsersJogo()) {
				if (Admin.SIM.equals(userJogo2.getAdmin())) {
					noticicacaoText = "Tem uma nova solicitação(" + userss.getEmail() + " " + userss.getUsername()
							+ ") para o racha na quadra : " + quadra.getNome() + " dia: "
							+ jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - "
							+ jogo.getHoraFinal() + "). ";
					notificacoes = new Notificacoes("SOLICITADO", new Date(), noticicacaoText,
							NotificacoesStatus.NAOLIDO, 10, 8);
					notificacoes.setParaJogoId(jogo.getId());
					notificacoes.setParaUserId(userJogo2.getUser_id());
					notificacoesService.insertNotificacoes(notificacoes);
				}

			}
			noticicacaoText = "Sua solicitação para o racha na quadra : " + quadra.getNome() + " dia: "
					+ jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - "
					+ jogo.getHoraFinal() + "). " + "foi enviado para o administrador do racha ";
			notificacoes = new Notificacoes("SOLICITADO", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO,
					user.getUser_id(), user.getJogo_id());
			break;
		case RECUSADO:
			for (UserJogo2 userJogo2 : jogo.getUsersJogo()) {
				if (Admin.SIM.equals(userJogo2.getAdmin())) {
					noticicacaoText = "Foi Aprovado na quadra : " + quadra.getNome() + " dia: "
							+ jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - "
							+ jogo.getHoraFinal() + "). " + "Aprovado por : " + userss.getEmail() + " "
							+ userss.getUsername();
					notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText,
							NotificacoesStatus.NAOLIDO, 10, 8);
					notificacoes.setParaJogoId(jogo.getId());
					notificacoes.setParaUserId(userJogo2.getUser_id());
					notificacoesService.insertNotificacoes(notificacoes);
				}
			}
			noticicacaoText = "Infelizmente solicitação para o racha na quadra : " + quadra.getNome() + " dia: "
					+ jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - "
					+ jogo.getHoraFinal() + "). " + "Não foi aprovado por : " + userss.getEmail() + " "
					+ userss.getUsername();
			notificacoes = new Notificacoes("TALVEZ", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO,
					user.getUser_id(), user.getJogo_id());
			break;

		default:
			break;
		}
		user.setAprovadoDate(new Date());
		notificacoes.setParaJogoId(jogo.getId());
		notificacoes.setParaUserId(user.getUser_id());
		notificacoesService.insertNotificacoes(notificacoes);
		jogoUserService.saveUserJogo(Arrays.asList(user));
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
		// Jogo user = mapper.readValue(jog, Jogo.class);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // você pode usar outras máscaras
		Jogo jogo = jogoService.findJogoById(Integer.parseInt(jog));
		List<JogoPorData> jogosData = new ArrayList<JogoPorData>();
		for (UserJogo2 user : jogo.getUsersJogo()) {
			if (user.getStatus_user().equals(StatusUser.CONFIRMADO)) {
				// GregorianCalendar gc = new GregorianCalendar();
				// jogosadd(new
				// JogoPorData(shouldDownloadFile2(jogo.getDia(),gc,jogo.getHoraInicial()).getTime(),shouldDownloadFile2(jogo.getDia(),gc,jogo.getHoraFinal()).getTime(),
				// jogo.getId(), user.getUser_id(), StatusJogoPorACONFIRMAR, 0, 0,
				// jogo.getQuadraId()));
			}
		}
		// List<Jogo> jogos = jogoService.findAllJogo();
		// List<JogoPorData> jogosData = new ArrayList<JogoPorData>();
		// for (Jogo jogo : jogos) {
		// System.out.println(jogo.getStatus());
		// if(jogo.getStatus().equals(Status.INDISPONIVEL))
		// {
		// for (UserJogo2 user : jogo.getUsersJogo()) {
		// if(user.getStatus_user().equals(StatusUser.CONFIRMADO))
		// {
		// GregorianCalendar gc = new GregorianCalendar();
		// jogosadd(new
		// JogoPorData(shouldDownloadFile2(jogo.getDia(),gc,jogo.getHoraInicial()).getTime(),shouldDownloadFile2(jogo.getDia(),gc,jogo.getHoraFinal()).getTime(),
		// jogo.getId(), user.getUser_id(), StatusJogoPorACONFIRMAR, 0, 0,
		// jogo.getQuadraId()));
		// }
		// }
		// }
		// }
		jogoService.saveJogoPorData(jogosData);
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
	@RequestMapping(value = "/jogo/findJogoByUserAndStatus", method = RequestMethod.POST)
	public ResponseEntity<List<TirarTime>> findJogoByUserAndStatus(@RequestBody String users)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(users, User.class);

		List<TirarTime> tirarTimeList = new ArrayList<TirarTime>();
		List<Jogo> quadra = jogoService.findJogoByUser(user.getId().intValue());
		List<InfoUser> infoUserList = new ArrayList<InfoUser>();


		for (Jogo jogo : quadra) {
			if (jogo != null && !jogo.getJogoPorData().isEmpty()) {
				for (JogoPorData jogoPorData : jogo.getJogoPorData()) {
					if (jogoPorData != null && !jogoPorData.getNotasGols().isEmpty()
							&& StatusJogoPorData.JAJOGADO.equals(jogoPorData.getStatus())) {
						for (NotasGols notasGols : jogoPorData.getNotasGols()) {
							infoUserList.add(new InfoUser(notasGols.getUserId(), notasGols.getQntGols(), notasGols.getNota()));
						}
					}
				}
			}

		}
		for (Jogo jogo : quadra) {
			if (jogo != null && !jogo.getJogoPorData().isEmpty()) {
				for (JogoPorData jogoPorData : jogo.getJogoPorData()) {
					if (StatusJogoPorData.TIRARTIME.equals(jogoPorData.getStatus())) {
						for (UserJogoData userJogoData : jogoPorData.getUserJogoData()) {
							if (StatusUserJogoPorData.CONFIRMADO.equals(userJogoData.getStatus())) {
								tirarTimeList.add(tiratime(userJogoData, infoUserList));
							}
						}
					}
				}
			}
		}
		return new ResponseEntity<List<TirarTime>>(tirarTimeList, HttpStatus.OK);
	}

	public TirarTime tiratime(UserJogoData userJogoData, List<InfoUser> infoUserList) {

		Integer countJogos = 0;
		Integer countGols = 0;
		Double media = new Double(0);
		if (!infoUserList.isEmpty()) {
			for (InfoUser infoUser : infoUserList) {
				if (userJogoData.getUser_id() == infoUser.getUserId()) {
					countJogos++;
					countGols = countGols + infoUser.getQntGols();
					media = media + infoUser.getMediaNota();
				}
			}
			return new TirarTime(userJogoData.getUsuario().getUsername(), userJogoData.getUsuario().getIsGoleiro(),
					countJogos, countGols, countJogos > 0 ? new Double(media / countJogos) : 0, countJogos > 0 ?  new Double(countGols / countJogos) : 0);
		}
		return new TirarTime();
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/jogo/findJogoByUser", method = RequestMethod.POST)
	public ResponseEntity<List<Jogo>> findAllQuadraById(@RequestBody String users)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(users, User.class);

		List<Jogo> quadra = jogoService.findJogoByUser(user.getId().intValue());

		return new ResponseEntity<List<Jogo>>(quadra, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/jogo/findJogoById", method = RequestMethod.POST)
	public ResponseEntity<Jogo> findJogoById(@RequestBody String users)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(users, User.class);

		Jogo quadra = jogoService.findJogoById(user.getId().intValue());

		return new ResponseEntity<Jogo>(quadra, HttpStatus.OK);
	}

	private void insertProximoJogoPorData(Jogo jogo, UserJogo2 user) {
		// BUSCAR JOGO POR DATA ID
		logger.info("BUSCAR JOGO POR DATA ID");
		GregorianCalendar gc = new GregorianCalendar();
		JogoPorData jogoPorData = new JogoPorData(
				data.shouldDownloadFile2(jogo.getDia(), gc, jogo.getHoraInicial()).getTime(),
				data.shouldDownloadFile2(jogo.getDia(), gc, jogo.getHoraFinal()).getTime(), jogo.getId(),
				jogo.getUsersJogo(), StatusJogoPorData.AJOGAR, jogo.getQuadraId());

		JogoPorData jogoPor = jogoService.findJogoPorDataUserConfirmDTO(jogo.getId(), jogoPorData.getData(),
				jogoPorData.getDataFinal());
		if (jogoPor != null) {
			// SALVANDO JOGADOR POR JOGO DATA
			logger.info("INICIANDO SALVAR JODADOR POR JOGO USER_ID :: " + jogo.getId());
			jogoService.saveUserJogoData(new UserJogoData(user.getUser_id(), jogoPor.getId(),
					StatusUserJogoPorData.ACONFIRMAR, jogo.getId(), user.getAprovadoPor()));

			logger.info("FINALIZANDO SALVAR JODADOR POR JOGO USER_ID :: " + jogo.getId());
		}
	}

}
