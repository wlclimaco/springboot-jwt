package com.nouhoun.springboot.jwt.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nouhoun.springboot.jwt.integration.domain.Notificacoes;

@Repository("notificacoesRepository")
public interface NotificacoesRepository extends JpaRepository<Notificacoes, Long> {
	
	//List<Notificacoes> findNotificacoesByEmail(String email);
	@Query("SELECT n  FROM Notificacoes n WHERE n.paraUserId = :email")
	List<Notificacoes> findNotificacoesByUser(@Param("email") Integer user);
	@Query("SELECT n  FROM Notificacoes n WHERE n.paraEmprId = :email")
	List<Notificacoes> findNotificacoesByEmpr(@Param("email") Integer user);
	@Query("SELECT n  FROM Notificacoes n WHERE n.paraJogoId = :email")	
	List<Notificacoes> findNotificacoesByJogo(@Param("email") Integer user);
}
