package com.nouhoun.springboot.jwt.integration.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.nouhoun.springboot.jwt.integration.domain.JogoPorData.StatusJogoPorData;


public class JogoPorDataDTO{


	private Integer id;
	
	private Date data;
	
	private Date dataFinal;
	
	@Column(name = "jogo_id")
	private Integer jogoId;
	
	private StatusJogoPorData status;
	
	private List<UserJogoData> userJogoData;
	
	private Integer user_id;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<UserJogoData> getUserJogoData() {
		return userJogoData;
	}

	public void setUserJogoData(List<UserJogoData> userJogoData) {
		this.userJogoData = userJogoData;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Integer getJogoId() {
		return jogoId;
	}

	public void setJogoId(Integer jogoId) {
		this.jogoId = jogoId;
	}

	public StatusJogoPorData getStatus() {
		return status;
	}

	public void setStatus(StatusJogoPorData status) {
		this.status = status;
	}

	public JogoPorDataDTO() {

	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	
		
}
