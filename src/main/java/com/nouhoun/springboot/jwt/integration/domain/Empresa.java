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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "empresa")
public class Empresa{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "empresa_id")
	private int id;
	@Column(name = "nome")
	@NotEmpty(message = "*Please provide an email")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	private String nome;
	@Column(name = "nomeResponsavel")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	private String nomeResponsavel;
	@Column(name = "email")
	@Email(message = "*Please provide a valid Email")
	private String email;
	@Column(name = "telefone")
	@NotEmpty(message = "*Please provide your last name")
	private String telefone;

//	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
//    @JoinColumn(name = "endereco_id", insertable = false, updatable = false, nullable = false)
//    private Endereco endereco;
	
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "endereco_id", unique = false, nullable = false, updatable = false)
    private Endereco endereco;

    @Column(name = "endereco_id", insertable = false, updatable = false, nullable = false)
    private Integer enderecoId;
    
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "empresa_quadra", joinColumns = @JoinColumn(name="empresa_id"), inverseJoinColumns = @JoinColumn(name = "quadra_id"))
	private List<Quadra> quadras;
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinTable(name = "notificacoes", joinColumns = @JoinColumn(name="para_empresa_id", referencedColumnName="empresa_id"))
//	private List<Notificacoes> notificacoes;
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name="para_empresa_id", referencedColumnName="empresa_id", nullable = false, insertable = false, updatable = false)
//	private List<Notificacoes> notificacoes;

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "horarioFunc", joinColumns = @JoinColumn(name="parent_id"), inverseJoinColumns = @JoinColumn(name = "horarios_id"))
//	private Set<Horarios> horarioFuncionamento;
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "status", joinColumns = @JoinColumn(name = "empresa_id"), inverseJoinColumns = @JoinColumn(name = "horario_id"))
//	private Set<DoisValores> status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Integer getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
	}

	public List<Quadra> getQuadras() {
		return quadras;
	}

	public void setQuadras(List<Quadra> quadras) {
		this.quadras = quadras;
	}

	public Empresa(int id, String nome, String nomeResponsavel, String email, String telefone, Endereco endereco,
			Integer enderecoId, List<Quadra> quadras, List<Notificacoes> notificacoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeResponsavel = nomeResponsavel;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.enderecoId = enderecoId;
		this.quadras = quadras;
	}

	public Empresa() {
		super();
	}



	
//	public Set<Horarios> getHorarioAberto() {
//		return horarioAberto;
//	}
//
//	public void setHorarioAberto(Set<Horarios> horarioAberto) {
//		this.horarioAberto = horarioAberto;
//	}
//
//	public Set<Horarios> getHorarioFuncionamento() {
//		return horarioFuncionamento;
//	}
//
//	public void setHorarioFuncionamento(Set<Horarios> horarioFuncionamento) {
//		this.horarioFuncionamento = horarioFuncionamento;
//	}
//
//	public Set<DoisValores> getStatus() {
//		return status;
//	}
//
//	public void setStatus(Set<DoisValores> status) {
//		this.status = status;
//	}

	
}
