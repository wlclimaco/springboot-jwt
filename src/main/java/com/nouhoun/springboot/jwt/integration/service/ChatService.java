package com.nouhoun.springboot.jwt.integration.service;

import java.util.List;

import com.nouhoun.springboot.jwt.integration.domain.Chat;
import com.nouhoun.springboot.jwt.integration.domain.ChatItens;

public interface ChatService {
	public List<ChatItens> update(ChatItens chat);
	public List<ChatItens> delete(ChatItens chat);
	public List<Chat> insert(ChatItens chat);
	public List<Chat> findChatByUser(Integer empresa);

}
