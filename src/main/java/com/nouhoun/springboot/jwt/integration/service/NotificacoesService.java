package com.nouhoun.springboot.jwt.integration.service;

import java.util.List;

import com.nouhoun.springboot.jwt.integration.domain.Notificacoes;



public interface NotificacoesService {
	public void insertNotificacoes(Notificacoes notificacoes);
	public void updateNotificacoes(Notificacoes notificacoes);
	public void deleteNotificacoes(Notificacoes notificacoes);
	public List<Notificacoes> findNotificacoesByUser(Integer email);
	public List<Notificacoes> findNotificacoesByEmpr(Integer email);
	public List<Notificacoes> findNotificacoesByJogo(Integer email);
	public List<Notificacoes> findAllNotificacoes();
	public Integer findNotificacoesByCount(Integer email);

}
