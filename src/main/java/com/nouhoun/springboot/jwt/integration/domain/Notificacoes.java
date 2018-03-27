package com.nouhoun.springboot.jwt.integration.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name = "notificacoes")
public class Notificacoes {
	
	public enum NotificacoesStatus {
	       LIDO, NAOLIDO, EXCLUIDO
	    }
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="notificacoes_id")
	private int id;
	@Column(name="descricao")
	private String descricao;
	
	@Column(name = "updatedAt")
	private @JsonIgnore Date updatedAt;
	 
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="status")
	private NotificacoesStatus status;
	
	@Column(name="user_id")
	private int deUserId;
	
	@Column(name="de_empresa_id")
	private int deEmprId;
	
	@Column(name="para_user_id")
	private int paraUserId;
	
	@Column(name="para_empresa_id")
	private int paraEmprId;
	
	@Column(name="de_jogo_id")
	private int deJogoId;
	
	@Column(name="para_jogo_id")
	private int paraJogoId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public NotificacoesStatus getStatus() {
		return status;
	}
	public void setStatus(NotificacoesStatus status) {
		this.status = status;
	}
	public int getDeUserId() {
		return deUserId;
	}
	public void setDeUserId(int deUserId) {
		this.deUserId = deUserId;
	}
	public int getDeEmprId() {
		return deEmprId;
	}
	public void setDeEmprId(int deEmprId) {
		this.deEmprId = deEmprId;
	}
	public int getParaUserId() {
		return paraUserId;
	}
	public void setParaUserId(int paraUserId) {
		this.paraUserId = paraUserId;
	}
	public int getParaEmprId() {
		return paraEmprId;
	}
	public void setParaEmprId(int paraEmprId) {
		this.paraEmprId = paraEmprId;
	}
	public int getDeJogoId() {
		return deJogoId;
	}
	public void setDeJogoId(int deJogoId) {
		this.deJogoId = deJogoId;
	}
	public int getParaJogoId() {
		return paraJogoId;
	}
	public void setParaJogoId(int paraJogoId) {
		this.paraJogoId = paraJogoId;
	}
	public Notificacoes(String descricao, Date updatedAt, String titulo, NotificacoesStatus status, int deUserId,
			int paraEmprId) {
		super();
		this.descricao = descricao;
		this.updatedAt = updatedAt;
		this.titulo = titulo;
		this.status = status;
		this.deUserId = deUserId;
		this.paraEmprId = paraEmprId;

	}
	public Notificacoes() {
		
	}
	
	
	
}
