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

@Entity
@Table(name = "avaliacao_itens")
public class AvaliacaoItens{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "chat_itens_id")
	private Integer id;
	
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "chat_itens_id",insertable = false, unique = false, nullable = false, updatable = false)	
	private AvaliacaoOptions opcao;
	
	@Column(name = "nota") 
    private Integer nota;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AvaliacaoOptions getOpcao() {
		return opcao;
	}

	public void setOpcao(AvaliacaoOptions opcao) {
		this.opcao = opcao;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

}
