package com.nouhoun.springboot.jwt.integration.domain;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name = "chat_itens")
public class ChatItens{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "chat_itens_id")
	private Integer id;
	
	@Column(name = "texto")
	private String texto;
	
	@Column(name = "user_id") 
    private Integer user_id;
	
	@Column(name = "chat_id") 
    private Integer chatId;
	
	@Column(name = "jogo_id") 
    private Integer jogoId;
	
	@Column(name = "edit_message") 
    private Integer editMessage;
	
	@Column(name = "data_msg") 
    private Date dataMessagem;
	
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", referencedColumnName="user_id", nullable = false, insertable = false, updatable = false)
	private User usuario;
	
    @Column(name = "lastLoginIp")
    private @JsonIgnore String lastLoginIp;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getChatId() {
		return chatId;
	}

	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}

	public Integer getJogoId() {
		return jogoId;
	}

	public void setJogoId(Integer jogoId) {
		this.jogoId = jogoId;
	}
	
	

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Integer getEditMessage() {
		return editMessage;
	}

	public void setEditMessage(Integer editMessage) {
		this.editMessage = editMessage;
	}

	public Date getDataMessagem() {
		return dataMessagem;
	}

	public void setDataMessagem(Date dataMessagem) {
		this.dataMessagem = dataMessagem;
	}

	
	
}
