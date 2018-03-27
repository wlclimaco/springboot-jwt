package com.nouhoun.springboot.jwt.integration.domain;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jogo_por_data")
public class JogoPorData{
	 public enum StatusJogoPorData {
	       CONFIRMADO, ACONFIRMAR, NAOVO, TALVEZ
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
	
	@Column(name = "nota")
	private Integer nota;
	
	@Column(name = "qnt_gols")
	private Integer qntGols;
	

	@Column(name = "user_id")
	private Integer user_id;
	

	HashMap<Integer, StatusJogoPorData> userConfirm = new HashMap<Integer, StatusJogoPorData>();
//	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
//	@JoinColumn(name="jogo_id", referencedColumnName="user_id", nullable = false, insertable = false, updatable = false)
//	private Jogo jogo;
	

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

	

	public JogoPorData(Date dataInicial,Date dataFInal, Integer jogoId, Integer userId, StatusJogoPorData status, Integer nota, Integer qntGols,
			int quadraId) {
		super();
		this.data = dataInicial;
		this.dataFinal = dataFInal;
		this.user_id = userId;
		this.jogoId = jogoId;
		this.status = status;
		this.nota = nota;
		this.qntGols = qntGols;

	}

	public JogoPorData() {

	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public HashMap<Integer, StatusJogoPorData> getUserConfirm() {
		return userConfirm;
	}

	public void setUserConfirm(HashMap<Integer, StatusJogoPorData> userConfirm) {
		this.userConfirm = userConfirm;
	}

//	public Jogo getJogo() {
//		return jogo;
//	}
//
//	public void setJogo(Jogo jogo) {
//		this.jogo = jogo;
//	}
	

		
}
