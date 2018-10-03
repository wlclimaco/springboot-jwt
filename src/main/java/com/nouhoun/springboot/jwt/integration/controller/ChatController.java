package com.nouhoun.springboot.jwt.integration.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nouhoun.springboot.jwt.integration.domain.Chat;
import com.nouhoun.springboot.jwt.integration.domain.ChatItens;
import com.nouhoun.springboot.jwt.integration.domain.security.User;
import com.nouhoun.springboot.jwt.integration.service.ChatService;

/**
 * Created by rajeevkumarsingh on 24/07/17.
 */
@Controller
public class ChatController {

	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	
	@Autowired
	public ChatService chatService;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/chat/findChatByUser", method = RequestMethod.POST)
	public ResponseEntity<List<Chat>> findAllQuadraById(@RequestBody String users)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(users, User.class);

		return new ResponseEntity<List<Chat>>(chatService.findChatByUser(user.getId().intValue()), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/chat/findChatById", method = RequestMethod.POST)
	public ResponseEntity<Chat> findChatById(@RequestBody Integer chatId)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		return new ResponseEntity<Chat>(chatService.findChatById(chatId), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/chat/insert", method = RequestMethod.POST)
	public ResponseEntity<List<Chat>> insert(@RequestBody ChatItens user,
            HttpServletRequest request)
			throws JsonParseException, JsonMappingException, IOException {
		
		user.setLastLoginIp(request.getRemoteHost());
	//	request.getRemoteHost()
		return new ResponseEntity<List<Chat>>(chatService.insert(user), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/chat/Update", method = RequestMethod.POST)
	public ResponseEntity<List<ChatItens>> update(@RequestBody String users)
			throws JsonParseException, JsonMappingException, IOException {
			ObjectMapper mapper = new ObjectMapper();
			ChatItens user = mapper.readValue(users, ChatItens.class);

			return new ResponseEntity<List<ChatItens>>(chatService.update(user), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/chat/delete", method = RequestMethod.POST)
	public ResponseEntity<List<ChatItens>> delete(@RequestBody String users)
			throws JsonParseException, JsonMappingException, IOException {
			ObjectMapper mapper = new ObjectMapper();
			ChatItens user = mapper.readValue(users, ChatItens.class);

			return new ResponseEntity<List<ChatItens>>(chatService.delete(user), HttpStatus.OK);
	}

}
