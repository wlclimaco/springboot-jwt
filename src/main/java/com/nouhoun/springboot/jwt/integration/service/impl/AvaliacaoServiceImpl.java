package com.nouhoun.springboot.jwt.integration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nouhoun.springboot.jwt.integration.domain.Avaliacao;
import com.nouhoun.springboot.jwt.integration.repository.AvaliacaoRepository;
import com.nouhoun.springboot.jwt.integration.service.AvaliacaoService;

@Service("avaliacaoService")
public class AvaliacaoServiceImpl implements AvaliacaoService{

	@Autowired
	private AvaliacaoRepository empresaRepository;


	public void saveAvaliacao(Avaliacao user) {
		
		empresaRepository.save(user);
		
	}
	@Override
	public void updateAvaliacao(Avaliacao user) {
		empresaRepository.save(user);
		
	}
	@Override
	public void deleteAvaliacao(Avaliacao user) {
		empresaRepository.delete(user);
	}
	
}
