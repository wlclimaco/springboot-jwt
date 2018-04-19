package com.nouhoun.springboot.jwt.integration.service;

import java.util.Date;
import java.util.List;

import com.nouhoun.springboot.jwt.integration.domain.Jogo;
import com.nouhoun.springboot.jwt.integration.domain.Jogo.Status;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorData;



public interface JogoService {
	public void updateJogo(Jogo empresa);
	public void deleteJogo(Jogo empresa);
	public List<Jogo> findJogoByUser(Integer empresa);
	public Jogo findJogoById(Integer empresa);
	public List<Jogo> findAllJogo();
	public List<JogoPorData> findJogoPorDataUserConfirmDTO(Integer JogoId, Date dataJogo);
	void saveJogo(List<Jogo> jogos);
	void saveUpdateJogo(Jogo jogos);
	void saveJogoPorData(List<JogoPorData> jogos);
	void saveJogoPorData(JogoPorData jogoPorData);
	public void updateStatus(Status indisponivel, Integer id);
}
