package com.nouhoun.springboot.jwt.integration.domain;

import java.util.ArrayList;
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

@Entity
@Table(name = "jogo_por_data")
public class JogoPorData {
	public enum StatusJogoPorData {
		JAJOGADO, AJOGAR, JOGANDO, CANCELADO, TIRARTIME
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "jogoPorData_id")
	private Integer id;

	@Column(name = "Data")
	private Date data;

	@Column(name = "DataFinal")
	private Date dataFinal;

	@Column(name = "jogo_id")
	private Integer jogoId;

	@Column(name = "status")
	private StatusJogoPorData status;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "jogoPorData_id", referencedColumnName = "jogoPorData_id", nullable = false, insertable = false, updatable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<UserJogoData> userJogoData = new ArrayList<UserJogoData>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "jogoPorData_id", referencedColumnName = "jogoPorData_id", nullable = false, insertable = false, updatable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<NotasGols> notasGols = new ArrayList<NotasGols>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Integer getJogoId() {
		return jogoId;
	}

	public void setJogoId(Integer jogoId) {
		this.jogoId = jogoId;
	}

	public StatusJogoPorData getStatus() {
		return status;
	}

	public void setStatus(StatusJogoPorData status) {
		this.status = status;
	}

	public JogoPorData(Date dataInicial, Date dataFInal, Integer jogoId, List<UserJogo2> user, StatusJogoPorData status,
			int quadraId) {
		super();
		this.data = dataInicial;
		this.dataFinal = dataFInal;
		this.jogoId = jogoId;
		this.status = status;
		
		List<UserJogoData> userData = new ArrayList<UserJogoData>();
		
		if(!user.isEmpty())
		{
			for (UserJogo2 users : user) {
				userData.add(new UserJogoData(users.getUser_id()));
			}
		}
		this.userJogoData = userData;

	}

	public JogoPorData() {

	}

	public List<UserJogoData> getUserJogoData() {
		return userJogoData;
	}

	public void setUserJogoData(List<UserJogoData> userJogoData) {
		this.userJogoData = userJogoData;
	}

//	private List<UserJogoData> convertUserToUserJogoData(List<UserJogo2> users) {
//
//		List<UserJogoData> userData = new ArrayList<UserJogoData>();
//		if(!users.isEmpty())
//		{
//			for (UserJogo2 user : users) {
//				userData.add(new UserJogoData(user.getUser_id()));
//			}
//		}
//		return userData;
//	}

	public List<NotasGols> getNotasGols() {
		return notasGols;
	}

	public void setNotasGols(List<NotasGols> notasGols) {
		this.notasGols = notasGols;
	}

	public JogoPorData(JogoPorDataDTO jogoPorData) {
		super();
		this.id = jogoPorData.getId();
		this.data = jogoPorData.getData();
		this.dataFinal = jogoPorData.getDataFinal();
		this.jogoId = jogoPorData.getJogoId();
		this.status = jogoPorData.getStatus();
		this.userJogoData = jogoPorData.getUserJogoData();
	}

}
