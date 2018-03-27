package com.nouhoun.springboot.jwt.integration.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	
	private int id;
	
    /**dsad
     * 
     */
    private Integer user_id;
    private Integer aprovadoPor;
    private Date aprovadoDate;
    private Integer jogo_id;
    private StatusUser status_user;
    private Admin admin;
    
    
    
    @NotNull
    @Column
    
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	@NotNull
    @Column
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
	@NotNull
    @Column
	public StatusUser getStatus_user() {
		return status_user;
	}
	public void setStatus_user(StatusUser status_user) {
		this.status_user = status_user;
	}
	@NotNull
    @Column
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserJogo2() {
		
	}
	@Column
	public Integer getAprovadoPor() {
		return aprovadoPor;
	}
	public void setAprovadoPor(Integer aprovadoPor) {
		this.aprovadoPor = aprovadoPor;
	}
	@Column
	public Date getAprovadoDate() {
		return aprovadoDate;
	}
	public void setAprovadoDate(Date aprovadoDate) {
		this.aprovadoDate = aprovadoDate;
	}

    
   


}
