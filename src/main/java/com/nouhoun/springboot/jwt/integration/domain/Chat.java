package com.nouhoun.springboot.jwt.integration.domain;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name = "chat")
public class Chat{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "chat_id")
	private Integer id;
	
    @Column(name = "jogo_id")
    private Integer jogoId;
    
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "jogo_id",insertable = false, unique = false, nullable = false, updatable = false)	
	private Jogo jogo;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="chat_id", referencedColumnName="chat_id", nullable = false, insertable = false, updatable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<ChatItens> chatItens;

    @Column(name = "currentLoginIp")
    private @JsonIgnore String currentLoginIp;
    
    @Column(name = "updatedAt")
    private @JsonIgnore Date updatedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getJogoId() {
		return jogoId;
	}

	public void setJogoId(Integer jogoId) {
		this.jogoId = jogoId;
	}

	public List<ChatItens> getChatItens() {
		return chatItens;
	}

	public void setChatItens(List<ChatItens> chatItens) {
		this.chatItens = chatItens;
	}

	public String getCurrentLoginIp() {
		return currentLoginIp;
	}

	public void setCurrentLoginIp(String currentLoginIp) {
		this.currentLoginIp = currentLoginIp;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	} 
    
    
}
