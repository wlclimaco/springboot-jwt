package com.nouhoun.springboot.jwt.integration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nouhoun.springboot.jwt.integration.domain.Chat;
import com.nouhoun.springboot.jwt.integration.domain.ChatItens;
import com.nouhoun.springboot.jwt.integration.repository.ChatItensRepository;
import com.nouhoun.springboot.jwt.integration.repository.ChatRepository;
import com.nouhoun.springboot.jwt.integration.service.ChatService;

@Service("chatService")
public class ChatServiceImpl implements ChatService{

	@Autowired
	private ChatRepository chatRepository;
	
	@Autowired
	private ChatItensRepository chatItensRepository;

	@Override
	public List<ChatItens> update(ChatItens chat) {
		
		chatItensRepository.save(chat);
		
		return chatRepository.findChatByid(chat.getJogoId());
	}

	@Override
	public List<ChatItens> delete(ChatItens chat) {
		
		chatItensRepository.delete(chat);
		return chatRepository.findChatByid(chat.getJogoId());
	}

	@Override
	public List<Chat> insert(ChatItens chat) {
		
		chatItensRepository.save(chat);
		
		return chatRepository.findChatByUser(chat.getUser_id());
	}

	@Override
	public List<Chat> findChatByUser(Integer empresa) {
		return chatRepository.findChatByUser(empresa);
	}
	//
	@Override
	public Chat findChatById(Integer empresa) {
		return chatRepository.findChatById(empresa);
	}
}
