package com.nouhoun.springboot.jwt.integration.domain;

public class ModelDTO{


	private User userLogado;
	private String token;
	
	public User getUserLogado() {
		return userLogado;
	}
	public void setUserLogado(User userLogado) {
		this.userLogado = userLogado;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "ModelDTO [getUserLogado()=" + getUserLogado() + ", getToken()=" + getToken() + ", toString()="
				+ super.toString() + "]";
	}

}
