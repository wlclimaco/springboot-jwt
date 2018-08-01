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

/**
 * The core Job Entity
 *
 * Created by Y.Kamesh on 8/2/2015.
 */
/**
 * @author Washington
 *
 */
@Entity
@Table(name = "user_jogo_data")
public class UserJogoData {

	 public enum StatusUserJogoPorData {
	       CONFIRMADO, ACONFIRMAR, NAOVO, TALVEZ
	    }
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_jogo_data_id") 
	private int id;
	
	@Column(name = "user_id") 
    private Integer user_id;
	
	@Column(name = "jogo_id") 
    private Integer jogo_id;
	
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", referencedColumnName="user_id", nullable = false, insertable = false, updatable = false)
	private User usuario;
	
	@Column(name = "jogoPorData_id") 
    private Integer jogoPorDataId;
	
	@Column(name = "status")
	private StatusUserJogoPorData status;
	
	@Column(name = "aprovadoPor")
    private Integer aprovadoPor;
	
	@Column(name = "aprovadoDate")
    private Date aprovadoDate;
    
   
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public StatusUserJogoPorData getStatus() {
		return status;
	}
	public void setStatus(StatusUserJogoPorData status) {
		this.status = status;
	}
	public UserJogoData(Integer user_id, Integer jogo_por_data,StatusUserJogoPorData status,Integer jogoId,Integer aprovadoPor) {
		super();
		this.user_id = user_id;
		this.jogoPorDataId = jogo_por_data;
		this.status = status;
		this.aprovadoDate = new Date();
		this.jogo_id = jogoId;
		this.aprovadoPor = aprovadoPor;
	}
	public UserJogoData(Integer user_id) {
		super();
		this.user_id = user_id;
	}
	public UserJogoData() {

	}
	public User getUsuario() {
		return usuario;
	}
	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Integer getJogoPorDataId() {
		return jogoPorDataId;
	}
	public void setJogoPorDataId(Integer jogoPorDataId) {
		this.jogoPorDataId = jogoPorDataId;
	}
	public Integer getJogo_id() {
		return jogo_id;
	}
	public void setJogo_id(Integer jogo_id) {
		this.jogo_id = jogo_id;
	}
	public Integer getAprovadoPor() {
		return aprovadoPor;
	}
	public void setAprovadoPor(Integer aprovadoPor) {
		this.aprovadoPor = aprovadoPor;
	}
	public Date getAprovadoDate() {
		return aprovadoDate;
	}
	public void setAprovadoDate(Date aprovadoDate) {
		this.aprovadoDate = aprovadoDate;
	}
	
}
