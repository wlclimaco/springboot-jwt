package com.nouhoun.springboot.jwt.integration.service;

import com.nouhoun.springboot.jwt.integration.domain.Avaliacao;



public interface AvaliacaoService {

	public void saveAvaliacao(Avaliacao empresa);
	public void updateAvaliacao(Avaliacao empresa);
	public void deleteAvaliacao(Avaliacao empresa);
	
}
