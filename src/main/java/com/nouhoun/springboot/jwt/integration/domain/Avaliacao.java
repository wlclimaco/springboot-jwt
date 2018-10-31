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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name = "avaliacao")
public class Avaliacao{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "avaliacao_id")
	private Integer id;
	
    @Column(name = "empresa_Id")
    private Integer empresaId;
  
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="avaliacao_id", referencedColumnName="avaliacao_id", nullable = false, insertable = true, updatable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<AvaliacaoItens> avaliacaoItens;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "mensagen")
    private String mensagen;

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

	public Integer getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}

	public List<AvaliacaoItens> getAvaliacaoItens() {
		return avaliacaoItens;
	}

	public void setAvaliacaoItens(List<AvaliacaoItens> avaliacaoItens) {
		this.avaliacaoItens = avaliacaoItens;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMensagen() {
		return mensagen;
	}

	public void setMensagen(String mensagen) {
		this.mensagen = mensagen;
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

	
    
}
