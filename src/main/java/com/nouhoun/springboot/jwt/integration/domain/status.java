package com.nouhoun.springboot.jwt.integration.domain;

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
@Table(name = "status")
public class status {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="status_id")
	private int id;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="doisValor_id")
	private DoisValores status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DoisValores getStatus() {
		return status;
	}
	public void setStatus(DoisValores status) {
		this.status = status;
	}
	
	
	
}
