package com.nouhoun.springboot.jwt.integration.domain;

import java.util.List;

public class EmpresaDTO extends ModelDTO {

	private int id;
	private String nome;
	private String nomeResponsavel;
	private String email;
	private String telefone;
	private Endereco endereco;
	private Integer enderecoId;
	private List<Quadra> quadras;
	private List<Notificacoes> notificacoes;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Integer getEnderecoId() {
		return enderecoId;
	}
	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
	}
	public List<Quadra> getQuadras() {
		return quadras;
	}
	public void setQuadras(List<Quadra> quadras) {
		this.quadras = quadras;
	}
	public List<Notificacoes> getNotificacoes() {
		return notificacoes;
	}
	public void setNotificacoes(List<Notificacoes> notificacoes) {
		this.notificacoes = notificacoes;
	}
	
	@Override
	public String toString() {
		return "EmpresaDTO [getId()=" + getId() + ", getNome()=" + getNome() + ", getNomeResponsavel()="
				+ getNomeResponsavel() + ", getEmail()=" + getEmail() + ", getTelefone()=" + getTelefone()
				+ ", getEndereco()=" + getEndereco() + ", getEnderecoId()=" + getEnderecoId() + ", getQuadras()="
				+ getQuadras() + ", getNotificacoes()=" + getNotificacoes() + ", toString()=" + super.toString() + "]";
	}

}
