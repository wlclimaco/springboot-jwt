package com.nouhoun.springboot.jwt.integration.domain;

public class TirarTime {
	
	public String  jogador;
	public Boolean  goleiro;
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
	public String getJogador() {
		return jogador;
	}
	public void setJogador(String jogador) {
		this.jogador = jogador;
	}
	public Boolean getGoleiro() {
		return goleiro;
	}
	public void setGoleiro(Boolean goleiro) {
		this.goleiro = goleiro;
	}
	
	
	
	public TirarTime() {

	}
	public TirarTime(String jogador, Boolean goleiro, Integer qntJogos, Integer qntGols, Double mediaNota,
			Double mediaGols) {
		super();
		this.jogador = jogador;
		this.goleiro = goleiro;
		this.qntJogos = qntJogos;
		this.qntGols = qntGols;
		this.mediaNota = mediaNota;
		this.mediaGols = mediaGols;
	}
	
	
	
}
