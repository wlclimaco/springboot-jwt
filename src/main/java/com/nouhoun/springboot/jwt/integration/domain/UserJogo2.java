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

import com.nouhoun.springboot.jwt.integration.domain.security.User;

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
@Table(name = "user_jogos")
public class UserJogo2 {

	public enum StatusUser {
	       SOLICITADO, CONFIRMADO, RECUSADO
	    }
	
	public enum Admin {
	       SIM, NAO
	    }
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_id")
    private Integer user_id;
	
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", referencedColumnName="user_id", nullable = false, insertable = false, updatable = false)
	private User usuario;
	
	@Column(name = "aprovadoPor")
    private Integer aprovadoPor;
	
	@Column(name = "aprovadoDate")
    private Date aprovadoDate;
	
	@Column(name = "jogo_id")
    private Integer jogo_id;
	
	@Column(name = "status_user")
    private StatusUser status_user;
	
	@Column(name = "admin")
    private Admin admin;
    
    
    

	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getJogo_id() {
		return jogo_id;
	}
	public void setJogo_id(Integer jogo_id) {
		this.jogo_id = jogo_id;
	}
	
	
	
	
	
	public UserJogo2(Integer user_id, Integer jogo_id, StatusUser status_user, Admin admin) {
		super();
		this.user_id = user_id;
		this.jogo_id = jogo_id;
		this.status_user = status_user;
		this.admin = admin;
	}

	public StatusUser getStatus_user() {
		return status_user;
	}
	public void setStatus_user(StatusUser status_user) {
		this.status_user = status_user;
	}

	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserJogo2() {
		
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
	public User getUsuario() {
		return usuario;
	}
	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

    
   


}
