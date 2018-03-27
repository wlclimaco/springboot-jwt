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

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name = "endereco")
public class Endereco{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "endereco_id")
	private int id;
	
	@Column(name = "cep")
	@NotEmpty(message = "*Please provide an cep")
	private String cep;
	
	@Column(name = "logradouro")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	private String logradouro;
	
	@Column(name = "numero")
	private String numero;
	
	@Column(name = "bairro")
	private String bairro;
	
	@Column(name = "referencia")
	private String referencia;
	
	@Column(name = "cidade")
	private String cidade;
	
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "estado_id",insertable = false, unique = false, nullable = false, updatable = false)	
	private Estado estado;
	
	//@OneToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="estado_id",insertable = false, unique = false, nullable = false, updatable = false)
	//private Estado estado;
	
//	@OneToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="estado_id",insertable = false, unique = false, nullable = false, updatable = false)
//	private Estado estado;
	
//	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
  //  @JoinColumn(name = "estado_id",insertable = false, unique = false, nullable = false, updatable = false)
//	private Estado estado;

    @Column(name = "estado_id")
    private Integer estadoId;
	
	@Column(name = "longi")
	private String longi;
	
	@Column(name = "lat")
	private String lat;
	
    @Column(name = "updatedAt")
    private @JsonIgnore Date updatedAt;
    
   // @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "endereco")
   // private Empresa empresa;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getLongi() {
		return longi;
	}
	public void setLongi(String longi) {
		this.longi = longi;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
//	public Empresa getEmpresa() {
//		return empresa;
//	}
//	public void setEmpresa(Empresa empresa) {
//		this.empresa = empresa;
//	}
//	@PrePersist
//    public void prePersist() {
//        if (empresa != null) {
//            empresa.setEndereco(this);
//        }
//    }
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Integer getEstadoId() {
		return estadoId;
	}
	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}
	
}
