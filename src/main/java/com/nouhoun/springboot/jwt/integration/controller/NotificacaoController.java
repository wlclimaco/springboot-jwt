package com.nouhoun.springboot.jwt.integration.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nouhoun.springboot.jwt.api.APIResponse;
import com.nouhoun.springboot.jwt.integration.domain.NotificacaoRequest;
import com.nouhoun.springboot.jwt.integration.domain.Notificacoes;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.service.NotificacoesService;


@Controller
public class NotificacaoController {

	@Autowired
	private NotificacoesService userService;




	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/notificacao/update", method = RequestMethod.POST)
	public @ResponseBody APIResponse updateMensagem(@RequestBody String users)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		Notificacoes notificacao = mapper.readValue(users, Notificacoes.class);
		List<String> erros = new ArrayList<String>();
		userService.updateNotificacoes(notificacao);
		HashMap<String, Object> authResp = new HashMap<String, Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
		Object token = auth.getCredentials();
		authResp.put("token", token);
		authResp.put("Notificacao", notificacao);
		authResp.put("Error", erros);
		
		  return APIResponse.toOkResponse(authResp);
	}

	//@CrossOrigin(origins = "*")
	@RequestMapping(value = "/notificacao/delete", method = RequestMethod.POST)
	public @ResponseBody APIResponse deleteMensagem(@RequestBody String users)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		Notificacoes notificacao = mapper.readValue(users, Notificacoes.class);
		List<String> erros = new ArrayList<String>();
		userService.deleteNotificacoes(notificacao);
		HashMap<String, Object> authResp = new HashMap<String, Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
		Object token = auth.getCredentials();
		authResp.put("token", token);
		authResp.put("Notificacao", notificacao);
		authResp.put("Error", erros);
		
		  return APIResponse.toOkResponse(authResp);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/notificacao/fetchByUserCount", method = RequestMethod.POST)
	public @ResponseBody APIResponse fetchByUserCount(@RequestBody String users)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		NotificacaoRequest notificacaoRequest = mapper.readValue(users, NotificacaoRequest.class);
		List<String> erros = new ArrayList<String>();
		HashMap<String, Object> authResp = new HashMap<String, Object>();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		Object token = auth.getCredentials();
		
		authResp.put("token", token);
		authResp.put("notificacaoCount", userService.findNotificacoesByCount(notificacaoRequest.getEmpresaId()));
		authResp.put("Error", erros);


	    return APIResponse.toOkResponse(authResp);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/notificacao/fetchByUser", method = RequestMethod.POST)
	public @ResponseBody APIResponse fetchByUser(@RequestBody String users)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		NotificacaoRequest notificacaoRequest = mapper.readValue(users, NotificacaoRequest.class);
		List<String> erros = new ArrayList<String>();
		List<Notificacoes> notificacaoList = new ArrayList<Notificacoes>();
		if(notificacaoRequest.getRole().getId() == 3)
		{
			notificacaoList = userService.findNotificacoesByEmpr(notificacaoRequest.getEmpresaId());
		}else {
			notificacaoList = userService.findNotificacoesByUser(notificacaoRequest.getUserId());
		}
	HashMap<String, Object> authResp = new HashMap<String, Object>();
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	Object token = auth.getCredentials();
	authResp.put("token", token);
	authResp.put("notificacaoList", notificacaoList);
	authResp.put("Error", erros);


    return APIResponse.toOkResponse(authResp);
	}

	private void createAuthResponse(User user, HashMap<String, Object> authResp,ArrayList<String> erros) {
        String token = "";
        		//Jwts.builder().setSubject(user.getEmail())
               // .claim("role", user.getRole().name()).setIssuedAt(new Date())
              // .signWith(SignatureAlgorithm.HS256, JWTTokenAuthFilter.JWT_KEY).compact();
        authResp.put("token", token);
        authResp.put("user", user);
        authResp.put("Error", erros);
    }


}
