package com.nouhoun.springboot.jwt.integration.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

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
import com.nouhoun.springboot.jwt.integration.domain.Jogo;
import com.nouhoun.springboot.jwt.integration.domain.Jogo.Dias;
import com.nouhoun.springboot.jwt.integration.domain.Jogo.Status;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorData;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorData.StatusJogoPorData;
import com.nouhoun.springboot.jwt.integration.domain.Notificacoes;
import com.nouhoun.springboot.jwt.integration.domain.Notificacoes.NotificacoesStatus;
import com.nouhoun.springboot.jwt.integration.domain.Quadra;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.domain.UserJogo2;
import com.nouhoun.springboot.jwt.integration.domain.UserJogo2.Admin;
import com.nouhoun.springboot.jwt.integration.domain.UserJogo2.StatusUser;
import com.nouhoun.springboot.jwt.integration.service.JogoService;
import com.nouhoun.springboot.jwt.integration.service.JogoUserService;
import com.nouhoun.springboot.jwt.integration.service.NotificacoesService;
import com.nouhoun.springboot.jwt.integration.service.QuadraService;
import com.nouhoun.springboot.jwt.integration.service.UserService;

@Controller
public class JogoController {

	@Autowired
	private JogoService jogoService;
	
	@Autowired
	private QuadraService quadraService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NotificacoesService notificacoesService;
	
	@Autowired
	private JogoUserService jogoUserService;

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
			jogoService.saveUpdateJogo(user);
			notificacoes = new Notificacoes("DISPONIVEL", new Date(), "Titulo DISPONIVEL", NotificacoesStatus.NAOLIDO, 10, 8);
			break;
		case ACONFIRMAR:
			quadra = quadraService.findAllQuadraById(user.getQuadraId());
			userss =  userService.findUserById(user.getUser_id());
			jogo = jogoService.findJogoById(user.getId());
			jogoService.saveUpdateJogo(user);
			List<UserJogo2> userJogos = new ArrayList<UserJogo2>();
			userJogos.add(new UserJogo2(user.getUser_id(),user.getId(),StatusUser.CONFIRMADO,Admin.SIM));
			jogoUserService.saveUserJogo(userJogos);
			noticicacaoText = "Acabo de ser solicitado na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Solicitado por : " + userss.getEmail() + " " + userss.getLastName(); 
			notificacoes = new Notificacoes("ACONFIRMAR", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, user.getId(), 82);
			notificacoes.setParaJogoId(user.getId());
			notificacoes.setParaEmprId(82);
			break;
		case OCUPADO:
			jogoService.saveUpdateJogo(user);
			notificacoes = new Notificacoes("OCUPADO", new Date(), "Titulo OCUPADO", NotificacoesStatus.NAOLIDO, 10,8);
			break;
		case INDISPONIVEL:
			Jogo jogoa = jogoService.findJogoById(user.getId());
		//	jogoService.updateStatus(Status.INDISPONIVEL,user.getId());
			jogoa.setStatus(Status.INDISPONIVEL);
			jogoService.saveUpdateJogo(jogoa);
			quadra = quadraService.findAllQuadraById(user.getQuadraId());
			userss =  userService.findUserById(user.getUser_id());
			user.setUsersJogo2(jogoUserService.findJogoUserByJogoId(user.getId()));
			
			for (UserJogo2 userJogo2 : user.getUsersJogo2()) {
				if(Admin.SIM.equals(userJogo2.getAdmin())) {
					noticicacaoText = "Foi Aprovado na quadra : " + quadra.getNome() + " dia: " +jogoa.getDia().name().toLowerCase() + " horario (" + jogoa.getHoraInicial() + " - " + jogoa.getHoraFinal() + "). " + "Aprovado por : " + userss.getEmail() + " " + userss.getLastName(); 
					notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, 0,0);
					notificacoes.setParaJogoId(jogoa.getId());
					notificacoes.setParaUserId(userJogo2.getUser_id());
					notificacoesService.insertNotificacoes(notificacoes);
				}
			}
		//	notificacoes = new Notificacoes("INDISPONIVEL", new Date(), "Titulo INDISPONIVEL", NotificacoesStatus.NAOLIDO, 10,8);
		//	notificacoes.setParaJogoId(user.getId());
			
			break;
		case CONFIRMAR:
			jogoService.saveUpdateJogo(user);
			notificacoes = new Notificacoes("CONFIRMAR", new Date(), "Titulo CONFIRMAR", NotificacoesStatus.NAOLIDO, 10,8);
			break;
		case DESMARCAR:
			notificacoes = new Notificacoes("DESMARCAR", new Date(), "Titulo DESMARCAR", NotificacoesStatus.NAOLIDO, 10,8);
			break;
			
		case SOLICITAR:
			List<UserJogo2> userJogos1 = new ArrayList<UserJogo2>();
			userJogos1.add(new UserJogo2(user.getUser_id(),user.getId(),StatusUser.SOLICITADO,Admin.NAO));
			jogoUserService.saveUserJogo(userJogos1);
			notificacoes = new Notificacoes("SOLICITAR", new Date(), "Titulo SOLICITAR", NotificacoesStatus.NAOLIDO, 10,8);
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
		JogoPorData user = mapper.readValue(users, JogoPorData.class);
		ModelAndView modelAndView = new ModelAndView();
		List<String> erros = new ArrayList<String>();
		
		Jogo jogo = jogoService.findJogoById(user.getJogoId());
		Quadra quadra = quadraService.findAllQuadraById(jogo.getQuadraId());
		User userss =  userService.findUserById(user.getUser_id());
		String noticicacaoText = "";
		Notificacoes notificacoes = new Notificacoes();
		switch (user.getStatus()) {
		case CONFIRMADO:
			jogoService.saveJogoPorData(user);
			for (UserJogo2 userJogo2 : jogo.getUsersJogo2()) {
				noticicacaoText = userss.getEmail() + " " + userss.getLastName() +" foi aprovado e participara do racha na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + ")." + "Solicitado por : " + userss.getEmail() + " " + userss.getLastName(); 
				notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, 10,8);
				notificacoes.setParaJogoId(jogo.getId());
				notificacoes.setParaUserId(userJogo2.getUser_id());
				notificacoesService.insertNotificacoes(notificacoes);
			}
			noticicacaoText = "Parabens foi APROVADA sua solicitação para o racha na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Solicitado por : " + userss.getEmail() + " " + userss.getLastName(); 
			notificacoes = new Notificacoes("TALVEZ", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogoId()); 
			//notificacoes = new Notificacoes("CONFIRMADO", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogo_id());
			break;
		case NAOVO:
			jogoService.saveJogoPorData(user);
			for (UserJogo2 userJogo2 : jogo.getUsersJogo2()) {
				if(Admin.SIM.equals(userJogo2.getAdmin())) {
					noticicacaoText = "Foi Recusado solicitação de "+ userss.getEmail() + " " + userss.getLastName() +" na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Solicitado por : " + userss.getEmail() + " " + userss.getLastName(); 
					notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, 10,8);
					notificacoes.setParaJogoId(jogo.getId());
					notificacoes.setParaUserId(userJogo2.getUser_id());
					notificacoesService.insertNotificacoes(notificacoes);
				}
			}
			noticicacaoText = "Infelizmente solicitação para o racha na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Não foi aprovado por : " + userss.getEmail() + " " + userss.getLastName();
			notificacoes = new Notificacoes("TALVEZ", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogoId());
			break;
			
		case TALVEZ:
			jogoService.saveJogoPorData(user);
			for (UserJogo2 userJogo2 : jogo.getUsersJogo2()) {
				if(Admin.SIM.equals(userJogo2.getAdmin())) {
					noticicacaoText = "Foi Recusado solicitação de "+ userss.getEmail() + " " + userss.getLastName() +" na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Solicitado por : " + userss.getEmail() + " " + userss.getLastName();  
					notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, 10,8);
					notificacoes.setParaJogoId(jogo.getId());
					notificacoes.setParaUserId(userJogo2.getUser_id());
					notificacoesService.insertNotificacoes(notificacoes);
				}
			}
			noticicacaoText = "Infelizmente solicitação para o racha na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Não foi aprovado por : " + userss.getEmail() + " " + userss.getLastName();
			notificacoes = new Notificacoes("TALVEZ", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogoId());
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
	@RequestMapping(value = "/jogo/aprovarJogador", method = RequestMethod.POST)
	public @ResponseBody APIResponse aprovarJogador(@RequestBody String users)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		UserJogo2 user = mapper.readValue(users, UserJogo2.class);
		ModelAndView modelAndView = new ModelAndView();
		List<String> erros = new ArrayList<String>();

		Jogo jogo = jogoService.findJogoById(user.getJogo_id());
		Quadra quadra = quadraService.findAllQuadraById(jogo.getQuadraId());
		User userss =  userService.findUserById(user.getUser_id());
		User userAprov =  userService.findUserById(user.getAprovadoPor());
		String noticicacaoText = "";
		Notificacoes notificacoes = new Notificacoes();
		switch (user.getStatus_user()) {
		case CONFIRMADO:
			jogoUserService.saveUserJogo(Arrays.asList(user));
			for (UserJogo2 userJogo2 : jogo.getUsersJogo2()) {
				noticicacaoText = userss.getEmail() + " " + userss.getLastName() +" foi aprovado e participara do racha na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + ")." + "Aprovado por : " + userAprov.getEmail() + " " + userAprov.getLastName(); 
				notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, 10,8);
				notificacoes.setParaJogoId(jogo.getId());
				notificacoes.setParaUserId(userJogo2.getUser_id());
				notificacoesService.insertNotificacoes(notificacoes);
			}
			noticicacaoText = "Parabens foi APROVADA sua solicitação para o racha na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Aprovado por : " + userAprov.getEmail() + " " + userAprov.getLastName(); 
			notificacoes = new Notificacoes("TALVEZ", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogo_id()); 
			//notificacoes = new Notificacoes("CONFIRMADO", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, user.getUser_id(),user.getJogo_id());
			break;
		case RECUSADO:
			jogoUserService.saveUserJogo(Arrays.asList(user));
			for (UserJogo2 userJogo2 : jogo.getUsersJogo2()) {
				if(Admin.SIM.equals(userJogo2.getAdmin())) {
					noticicacaoText = "Foi Recusado solicitação de "+ userss.getEmail() + " " + userss.getLastName() +" na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). " + "Recusado por : " + userAprov.getEmail() + " " + userAprov.getLastName(); 
					notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, 10,8);
					notificacoes.setParaJogoId(jogo.getId());
					notificacoes.setParaUserId(userJogo2.getUser_id());
					notificacoesService.insertNotificacoes(notificacoes);
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
		User userss =  userService.findUserById(user.getUser_id());

		Notificacoes notificacoes = new Notificacoes();
		String noticicacaoText = "";
		switch (user.getStatus_user()) {
		case CONFIRMADO:
			
			for (UserJogo2 userJogo2 : jogo.getUsersJogo2()) {
				noticicacaoText = userss.getEmail() + " " + userss.getLastName() +" foi aprovado e participara do racha na quadra : " + quadra.getNome() + " dia: " +jogo.getDia().name().toLowerCase() + " horario (" + jogo.getHoraInicial() + " - " + jogo.getHoraFinal() + "). "; 
				notificacoes = new Notificacoes("INDISPONIVEL", new Date(), noticicacaoText, NotificacoesStatus.NAOLIDO, 10,8);
				notificacoes.setParaJogoId(jogo.getId());
				notificacoes.setParaUserId(userJogo2.getUser_id());
				notificacoesService.insertNotificacoes(notificacoes);
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
					notificacoesService.insertNotificacoes(notificacoes);
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
					notificacoesService.insertNotificacoes(notificacoes);
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
	//	Jogo user = mapper.readValue(jog, Jogo.class);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // você pode usar outras máscaras
		Jogo jogo = jogoService.findJogoById(Integer.parseInt(jog));
		List<JogoPorData> jogosData = new ArrayList<JogoPorData>();
		for (UserJogo2 user : jogo.getUsersJogo2()) {
			if(user.getStatus_user().equals(StatusUser.CONFIRMADO))
			{
				GregorianCalendar gc = new GregorianCalendar();
				jogosData.add(new JogoPorData(shouldDownloadFile2(jogo.getDia(),gc,jogo.getHoraInicial()).getTime(),shouldDownloadFile2(jogo.getDia(),gc,jogo.getHoraFinal()).getTime(), jogo.getId(), user.getUser_id(), StatusJogoPorData.ACONFIRMAR, 0, 0,
				jogo.getQuadraId()));
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
	@RequestMapping(value = "/jogo/findJogoByUser", method = RequestMethod.POST)
	public ResponseEntity<List<Jogo>> findAllQuadraById(@RequestBody String users)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(users, User.class);

		List<Jogo> quadra = jogoService.findJogoByUser(user);

		return new ResponseEntity<List<Jogo>>(quadra, HttpStatus.OK);
	}
	public GregorianCalendar shouldDownloadFile2(Dias dia,GregorianCalendar gc,String hInc)
	{
		Integer a= 0;
		if (gc.get(GregorianCalendar.DAY_OF_WEEK) == gc.SUNDAY) {
			switch (dia) { 
			case DOMINGO:
					a = 0;
				break;
			case SEGUNDA:
				a = 1;
				break;
			case TERCA:
				a = 2;
				break;
			case QUARTA:
				a = 3;
				break;
			case QUINTA:
				a = 4;
				break;
			case SEXTA:
				a = 5;
				break;
			case SABADO:
				a = 6;
				break;
			}
		}else
		if (gc.get(GregorianCalendar.DAY_OF_WEEK) == gc.MONDAY) {
			switch (dia) { 
			case DOMINGO:
					a = 6;
				break;
			case SEGUNDA:
				a = 0;
				break;
			case TERCA:
				a = 1;
				break;
			case QUARTA:
				a = 2;
				break;
			case QUINTA:
				a = 3;
				break;
			case SEXTA:
				a = 4;
				break;
			case SABADO:
				a = 5;
				break;
			}
		}else
		if (gc.get(GregorianCalendar.DAY_OF_WEEK) == gc.TUESDAY) {
			switch (dia) { 
			case DOMINGO:
					a = 5;
				break;
			case SEGUNDA:
				a = 6;
				break;
			case TERCA:
				a = 0;
				break;
			case QUARTA:
				a = 1;
				break;
			case QUINTA:
				a = 2;
				break;
			case SEXTA:
				a = 3;
				break;
			case SABADO:
				a = 4;
				break;
			}
		}else

		if (gc.get(GregorianCalendar.DAY_OF_WEEK) == gc.WEDNESDAY) {
			switch (dia) { 
			case DOMINGO:
					a = 4;
				break;
			case SEGUNDA:
				a = 5;
				break;
			case TERCA:
				a = 6;
				break;
			case QUARTA:
				a = 0;
				break;
			case QUINTA:
				a = 1;
				break;
			case SEXTA:
				a = 2;
				break;
			case SABADO:
				a = 3;
				break;
			}
		}else
		if (gc.get(GregorianCalendar.DAY_OF_WEEK) == gc.THURSDAY) {
			switch (dia) { 
			case DOMINGO:
					a = 3;
				break;
			case SEGUNDA:
				a = 4;
				break;
			case TERCA:
				a = 5;
				break;
			case QUARTA:
				a = 6;
				break;
			case QUINTA:
				a = 0;
				break;
			case SEXTA:
				a = 1;
				break;
			case SABADO:
				a = 2;
				break;
			}
		}else
		if (gc.get(GregorianCalendar.DAY_OF_WEEK) == gc.FRIDAY) {
			switch (dia) { 
			case DOMINGO:
					a = 2;
				break;
			case SEGUNDA:
				a = 3;
				break;
			case TERCA:
				a = 4;
				break;
			case QUARTA:
				a = 5;
				break;
			case QUINTA:
				a = 6;
				break;
			case SEXTA:
				a = 1;
				break;
			case SABADO:
				a = 2;
				break;
			}
		}else
		if (gc.get(GregorianCalendar.DAY_OF_WEEK) == gc.SATURDAY) {
			switch (dia) { 
			case DOMINGO:
					a = 1;
				break;
			case SEGUNDA:
				a = 2;
				break;
			case TERCA:
				a = 3;
				break;
			case QUARTA:
				a = 4;
				break;
			case QUINTA:
				a = 5;
				break;
			case SEXTA:
				a = 6;
				break;
			case SABADO:
				a = 7;
				break;
			}
		}
		
		gc.add(gc.DATE, a);
		String[] rabbitmqUserInfo = hInc.split(":");
		gc.set(GregorianCalendar.HOUR_OF_DAY,Integer.parseInt(rabbitmqUserInfo[0]));
		gc.set(GregorianCalendar.MINUTE,Integer.parseInt(rabbitmqUserInfo[1]));
		
		//gc.add(gc.HOUR, Integer.parseInt(rabbitmqUserInfo[0]));
	//	gc.add(gc.MINUTE, Integer.parseInt(rabbitmqUserInfo[0]));
		return gc;
	}
}
