package com.nouhoun.springboot.jwt.integration.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "avaliacao_itens")
public class AvaliacaoItens{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "chat_itens_id")
	private Integer id;
	
	@Column(name = "opcao_id")
	private Integer opcaoId;
	
	@Column(name = "nota") 
    private Integer nota;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOpcaoId() {
		return opcaoId;
	}

	public void setOpcaoId(Integer opcaoId) {
		this.opcaoId = opcaoId;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

}
