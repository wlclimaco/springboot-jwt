package com.nouhoun.springboot.jwt.integration.domain;

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
@Table(name = "jogo")
public class Jogo {
	 public enum Confirmacao {
	        FIXO,SOHOJE, MENSAL, ANUAL
	    }

	 public enum Dias {
	       DOMINGO, SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO
	    }

	 public enum Status {
	       DISPONIVEL, ACONFIRMAR, OCUPADO, INDISPONIVEL, CONFIRMAR, DESMARCAR, EXCLUIR, SOLICITAR
	    }
	 
	 public enum Processo {
	       FINALIZAO, AGUARDANDO, GERADO
	    }
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "jogo_id")
	private Integer id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "processo")
	private Processo processo;

	//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@JoinColumn(name="para_jogo_id", referencedColumnName="jogo_id")
//	private List<Notificacoes> notificacoes;

	//@ManyToMany(cascade = CascadeType.ALL)
	//@JoinTable(name = "user_jogos", joinColumns = @JoinColumn(name = "jogo_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name="para_jogo_id", referencedColumnName="jogo_id", nullable = false, insertable = false, updatable = false)
//	private List<Notificacoes> notificacoes;

//	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
//	@JoinColumn(name="user_id", referencedColumnName="user_id", nullable = false, insertable = false, updatable = false)
//	private User userId;

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "user_jogos", joinColumns = @JoinColumn(name = "jogo_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
//

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "user_jogos", joinColumns = @JoinColumn(name="jogo_id", nullable = false,  insertable = false, updatable = false), inverseJoinColumns = @JoinColumn(name = "user_id", nullable = false,  insertable = false, updatable = false))
//	private List<User> usersJogo;

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "user_jogos", joinColumns = @JoinColumn(name="jogo_id", nullable = false,  insertable = false, updatable = false), inverseJoinColumns = @JoinColumn(name = "user_id", nullable = false,  insertable = false, updatable = false))
//	private List<UserJogo2> usersJogo2;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="jogo_id",  insertable = false,unique = false, nullable = false, updatable = false)
	private List<UserJogo2> usersJogo;

	@Column(name = "user_id")
	private Integer user_id;
	
	@Column(name = "maximoConfirmados")
	private Integer maximoConfirmados;



//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinTable(joinColumns = @JoinColumn(name= "jogo_id", insertable = false,unique = false, nullable = false, updatable = false))
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="jogo_id", referencedColumnName="jogo_id", nullable = false, insertable = false, updatable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<JogoPorData> jogoPorData;

//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "user_jogos",  joinColumns = {
//			@JoinColumn(name = "jogo_id", nullable = false, updatable = false) },
//			inverseJoinColumns = { @JoinColumn(name = "user_id",
//					nullable = false, updatable = false) })
//	private Set<User> user;

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "user_jogos", joinColumns = @JoinColumn(name = "jogo_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
//	private List<User> users;

	@Column(name = "aceitaExterno")
	private String aceitaExterno;

	@Column(name = "confirmacao")
	private Confirmacao confirmacao;

	@Column(name = "quadra_id")
	private Integer quadraId;

	@Column(name = "horaInicial")
	private String horaInicial;

	@Column(name = "horaFinal")
	private String horaFinal;

	@Column(name = "dia")
	private Dias dia;

	@Column(name = "status")
	private Status status;


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getAceitaExterno() {
		return aceitaExterno;
	}
	public void setAceitaExterno(String aceitaExterno) {
		this.aceitaExterno = aceitaExterno;
	}
	public Confirmacao getConfirmacao() {
		return confirmacao;
	}
	public void setConfirmacao(Confirmacao confirmacao) {
		this.confirmacao = confirmacao;
	}
	public String getHoraInicial() {
		return horaInicial;
	}
	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}
	public String getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}
	public Dias getDia() {
		return dia;
	}
	public void setDia(Dias dia) {
		this.dia = dia;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Integer getQuadraId() {
		return quadraId;
	}
	public void setQuadraId(Integer quadraId) {
		this.quadraId = quadraId;
	}


	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMaximoConfirmados() {
		return maximoConfirmados;
	}
	public void setMaximoConfirmados(Integer maximoConfirmados) {
		this.maximoConfirmados = maximoConfirmados;
	}
	public Processo getProcesso() {
		return processo;
	}
	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
	public List<UserJogo2> getUsersJogo() {
		return usersJogo;
	}
	public void setUsersJogo(List<UserJogo2> usersJogo) {
		this.usersJogo = usersJogo;
	}
	public List<JogoPorData> getJogoPorData() {
		return jogoPorData;
	}
	public void setJogoPorData(List<JogoPorData> jogoPorData) {
		this.jogoPorData = jogoPorData;
	}



}
