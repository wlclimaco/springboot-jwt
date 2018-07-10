package com.nouhoun.springboot.jwt.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nouhoun.springboot.jwt.integration.domain.Chat;
import com.nouhoun.springboot.jwt.integration.domain.ChatItens;

@Repository("ChatRepository")
public interface ChatRepository extends JpaRepository<Chat, Long> {

	//select c.* from user_jogos u, chat c where u.jogo_id = c.jogo_id and user_id = 8
	@Query("select c from UserJogo2 u, Chat c where u.jogo_id = c.jogoId and u.user_id = ?1")
	public List<Chat> findChatByUser(Integer userId);
	
	@Query("select c from ChatItens c where c.jogoId = ?1")
	public List<ChatItens> findChatByid(Integer userId);
    
}
