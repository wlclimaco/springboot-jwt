package com.nouhoun.springboot.jwt.integration.service;

import java.util.Date;
import java.util.List;

import com.nouhoun.springboot.jwt.integration.domain.Jogo;
import com.nouhoun.springboot.jwt.integration.domain.Jogo.Processo;
import com.nouhoun.springboot.jwt.integration.domain.Jogo.Status;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorData;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorData.StatusJogoPorData;
import com.nouhoun.springboot.jwt.integration.domain.NotasGols;
import com.nouhoun.springboot.jwt.integration.domain.UserJogoData;



public interface JogoService {
	public void updateJogo(Jogo empresa);
	public void deleteJogo(Jogo empresa);
	public List<Jogo> findJogoByUser(Integer empresa);
	public List<Jogo> findJogoByStatus(Status status,Processo processo);
	
	public Jogo findJogoById(Integer empresa);
	public List<Jogo> findAllJogo();
	public JogoPorData findJogoPorDataUserConfirmDTO(Integer JogoId, Date dataJogoInicio, Date dataJogoFinal);
	void saveJogo(List<Jogo> jogos);
	void saveUpdateJogo(Jogo jogos);
	void saveJogoPorData(List<JogoPorData> jogos);
	void saveUserJogoData(List<UserJogoData> jogos);
	void saveUserNotasGols(List<NotasGols> jogos);
	JogoPorData saveJogoPorData(JogoPorData jogoPorData);
	public void updateStatus(Status indisponivel, Integer id);
	
	public List<JogoPorData> findJogoPorDataByStatus(StatusJogoPorData status,Integer jogoId);
	public List<JogoPorData> updateJogoPorDataStatus(StatusJogoPorData status,Integer jogoId);
	
	UserJogoData saveUserJogoData(UserJogoData jogoPorData);
}
