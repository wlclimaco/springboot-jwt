package com.nouhoun.springboot.jwt.integration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nouhoun.springboot.jwt.integration.domain.Notificacoes;
import com.nouhoun.springboot.jwt.integration.repository.NotificacoesRepository;
import com.nouhoun.springboot.jwt.integration.service.NotificacoesService;

@Service("notificacoesService")
public class NotificacoesServiceImpl implements NotificacoesService{

	@Autowired
	private NotificacoesRepository notificacoesRepository;

	@Override
	public void insertNotificacoes(Notificacoes notificacoes) {
		notificacoesRepository.save(notificacoes);
		
	}

	@Override
	public void updateNotificacoes(Notificacoes notificacoes) {
		notificacoesRepository.save(notificacoes);
		
	}

	@Override
	public void deleteNotificacoes(Notificacoes notificacoes) {
		notificacoesRepository.delete(notificacoes);
		
	}

	@Override
	public List<Notificacoes> findAllNotificacoes() {
		return notificacoesRepository.findAll();
	}

	@Override
	public List<Notificacoes> findNotificacoesByUser(Integer email) {
		return notificacoesRepository.findNotificacoesByUser(email);
	}
	
	@Override
	public Integer findNotificacoesByCount(Integer email) {
		return notificacoesRepository.findNotificacoesByCount(email);
	}

	@Override
	public List<Notificacoes> findNotificacoesByEmpr(Integer email) {
		return notificacoesRepository.findNotificacoesByEmpr(email);
	}
	

	@Override
	public List<Notificacoes> findNotificacoesByJogo(Integer email) {
		return notificacoesRepository.findNotificacoesByJogo(email);
	}

	@Override
	public Integer findNotificacoesEmpresaByCount(Integer empresaId) {
		return notificacoesRepository.findNotificacoesEmpresaByCount(empresaId);
	}

	

}
