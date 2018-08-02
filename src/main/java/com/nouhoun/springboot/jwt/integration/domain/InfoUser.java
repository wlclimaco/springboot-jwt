package com.nouhoun.springboot.jwt.integration.domain;

public class InfoUser {
	
	public Integer userId;
	public Integer qntJogos;
	public Integer qntGols;
	public Double  mediaNota;
	public Double  mediaGols;
	public Integer getQntJogos() {
		return qntJogos;
	}
	public void setQntJogos(Integer qntJogos) {
		this.qntJogos = qntJogos;
	}
	public Integer getQntGols() {
		return qntGols;
	}
	public void setQntGols(Integer qntGols) {
		this.qntGols = qntGols;
	}
	public Double getMediaNota() {
		return mediaNota;
	}
	public void setMediaNota(Double mediaNota) {
		this.mediaNota = mediaNota;
	}
	public Double getMediaGols() {
		return mediaGols;
	}
	public void setMediaGols(Double mediaGols) {
		this.mediaGols = mediaGols;
	}
	
	

	public InfoUser(Integer qntJogos, Integer qntGols, Double mediaNota, Double mediaGols) {
		super();
		this.qntJogos = qntJogos;
		this.qntGols = qntGols;
		this.mediaNota = mediaNota;
		this.mediaGols = mediaGols;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public InfoUser(Integer userId, Integer qntGols, Double mediaNota) {
		super();
		this.userId = userId;
		this.qntGols = qntGols;
		this.mediaNota = mediaNota;
	}
	
	
}
