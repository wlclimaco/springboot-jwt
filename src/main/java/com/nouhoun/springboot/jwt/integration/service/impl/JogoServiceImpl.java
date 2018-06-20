package com.nouhoun.springboot.jwt.integration.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nouhoun.springboot.jwt.integration.domain.Jogo;
import com.nouhoun.springboot.jwt.integration.domain.Jogo.Processo;
import com.nouhoun.springboot.jwt.integration.domain.Jogo.Status;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorData;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorData.StatusJogoPorData;
import com.nouhoun.springboot.jwt.integration.domain.UserJogoData;
import com.nouhoun.springboot.jwt.integration.repository.JogoPorDataRepository;
import com.nouhoun.springboot.jwt.integration.repository.JogoRepository;
import com.nouhoun.springboot.jwt.integration.repository.UserJogoDataRepository;
import com.nouhoun.springboot.jwt.integration.service.JogoService;

@Service("jogoService")
public class JogoServiceImpl implements JogoService{

	@Autowired
	private JogoRepository jogoRepository;
	
	@Autowired
	private JogoPorDataRepository jogoPorDataRepository; //UserJogoDataRepository

	@Autowired
	private UserJogoDataRepository userJogoDataRepository;

	@Override
	public void updateJogo(Jogo user) {
		jogoRepository.save(user);
		
	}
	@Override
	public void deleteJogo(Jogo user) {
		jogoRepository.delete(user);
	}
	@Override
	public List<Jogo> findJogoByUser(Integer user) {
		return jogoRepository.findJogoByUser(user);
		
	}

	@Override
	public List<Jogo> findAllJogo() {
		return jogoRepository.findAll();
	}


	@Override
	public void saveJogo(List<Jogo> jogos) {
		jogoRepository.save(jogos);
	}
	
	
	@Override
	public void saveUpdateJogo(Jogo jogos) {
		jogoRepository.save(jogos);
	}
	@Override
	public void saveJogoPorData(List<JogoPorData> jogos) {
		jogoPorDataRepository.save(jogos);
		
	}

	@Override
	public JogoPorData saveJogoPorData(JogoPorData jogoPorData) {
		 return jogoPorDataRepository.save(jogoPorData);
		
	}
	
	@Override
	public UserJogoData saveUserJogoData(UserJogoData jogoPorData) {
		return userJogoDataRepository.save(jogoPorData);
		
	}
	@Override
	public JogoPorData findJogoPorDataUserConfirmDTO(Integer JogoId, Date dataJogoInicio, Date dataJogoFinal) {
	//public List<JogoPorData> findJogoPorDataUserConfirmDTO(Integer JogoId, Date dataJogo) {
		return jogoPorDataRepository.findJogoPorDataUserConfirmDTO(JogoId, dataJogoInicio, dataJogoFinal );
	}
	@Override
	public Jogo findJogoById(Integer empresa) {
		return jogoRepository.findJogoById(empresa);
	}
	@Override
	public void updateStatus(Status indisponivel, Integer id) {
			jogoRepository.updateStatus(indisponivel,id);
			
		
	}
	@Override
	public List<Jogo> findJogoByStatus(Status status, Processo processo) {
		return jogoRepository.findJogoByStatus(status,processo);
	}
	@Override
	public List<JogoPorData> findJogoPorDataByStatus(StatusJogoPorData status, Integer jogoId) {
		return jogoPorDataRepository.findJogoPorDataByStatus(status, jogoId);
	}
	@Override
	public List<JogoPorData> updateJogoPorDataStatus(StatusJogoPorData status, Integer jogoId) {
		return jogoPorDataRepository.updateJogoPorDataStatus(status, jogoId);
	}

	
	

}
