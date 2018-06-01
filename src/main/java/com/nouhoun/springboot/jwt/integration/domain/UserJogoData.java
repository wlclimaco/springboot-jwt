package com.nouhoun.springboot.jwt.integration.domain;

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
	
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", referencedColumnName="user_id", nullable = false, insertable = false, updatable = false)
	private User usuario;
	
	@Column(name = "jogoPorData_id") 
    private Integer jogoPorData_id;
	
	@Column(name = "nota") 
	private Integer nota;
	
	@Column(name = "qntGols") 
	private Integer qntGols;
	
	@Column(name = "status")
	private StatusUserJogoPorData status;
    
   
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

	public Integer getJogo_por_data() {
		return jogoPorData_id;
	}
	public void setJogo_por_data(Integer jogo_por_data) {
		this.jogoPorData_id = jogo_por_data;
	}

	public Integer getNota() {
		return nota;
	}
	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public Integer getQntGols() {
		return qntGols;
	}
	public void setQntGols(Integer qntGols) {
		this.qntGols = qntGols;
	}
	
	public StatusUserJogoPorData getStatus() {
		return status;
	}
	public void setStatus(StatusUserJogoPorData status) {
		this.status = status;
	}
	public UserJogoData(Integer user_id, Integer jogo_por_data,StatusUserJogoPorData status) {
		super();
		this.user_id = user_id;
		this.jogoPorData_id = jogo_por_data;
		this.status = status;
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
	public Integer getJogoPorData_id() {
		return jogoPorData_id;
	}
	public void setJogoPorData_id(Integer jogoPorData_id) {
		this.jogoPorData_id = jogoPorData_id;
	}
	
}
