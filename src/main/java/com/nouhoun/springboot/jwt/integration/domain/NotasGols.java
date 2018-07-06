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
@Table(name = "nota_gols")
public class NotasGols {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nota_gols_id") 
	private int id;
	
	@Column(name = "user_jogo_data_id") 
	private int useJogoDataId;
	
	@Column(name = "user_id") 
    private Integer userId;
	
	@Column(name = "jogo_id") 
    private Integer jogoId;
	
	@Column(name = "jogoPorData_id") 
    private Integer jogoPorDataId;
	
	@Column(name = "nota") 
	private Integer nota;
	
	@Column(name = "qntGols") 
	private Integer qntGols;
	
	@Column(name = "date")
    private Date date;
	
	@Column(name = "user_nota")
    private Integer userNota;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUseJogoDataId() {
		return useJogoDataId;
	}

	public void setUseJogoDataId(int useJogoDataId) {
		this.useJogoDataId = useJogoDataId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getJogoId() {
		return jogoId;
	}

	public void setJogoId(Integer jogoId) {
		this.jogoId = jogoId;
	}

	public Integer getJogoPorDataId() {
		return jogoPorDataId;
	}

	public void setJogoPorDataId(Integer jogoPorDataId) {
		this.jogoPorDataId = jogoPorDataId;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getUserNota() {
		return userNota;
	}

	public void setUserNota(Integer userNota) {
		this.userNota = userNota;
	}
    
}
