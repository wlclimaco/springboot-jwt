package com.nouhoun.springboot.jwt.integration.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "avaliacao_options")
public class AvaliacaoOptions{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "avaliacao_options_id")
	private Integer id;
	
	@Column(name = "chat_itens_id")
	private Integer chat_itens_id;
		
	@Column(name = "empresa_id") 
    private Integer empresa_id;
	
	@Column(name = "opcao") 
    private String opcao;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Integer getEmpresa_id() {
		return empresa_id;
	}

	public void setEmpresa_id(Integer empresa_id) {
		this.empresa_id = empresa_id;
	}

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public Integer getChat_itens_id() {
		return chat_itens_id;
	}

	public void setChat_itens_id(Integer chat_itens_id) {
		this.chat_itens_id = chat_itens_id;
	}
	
}
