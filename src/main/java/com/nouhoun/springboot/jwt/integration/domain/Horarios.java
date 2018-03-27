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
@Table(name = "horarios")
public class Horarios{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "horarios_id")
	private int id;

	@Column(name = "dom")
	private int dom;
	@Column(name = "seg")
	private int seg;
	@Column(name = "ter")
	private int ter;
	@Column(name = "qua")
	private int qua;
	@Column(name = "qui")
	private int qui;
	@Column(name = "sex")
	private int sex;
	@Column(name = "sab")
	private int sab;
	
	@Column(name = "hora_inicial")
	private String horaInicial;
	@Column(name = "hora_final")
	private String horaFinal;
	@Column(name = "parent_id")
	private int ParentId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getHoraInicial() {
		return horaInicial;
	}
	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}
	
	public int getParentId() {
		return ParentId;
	}
	public void setParentId(int parentId) {
		ParentId = parentId;
	}
	public int getDom() {
		return dom;
	}
	public void setDom(int dom) {
		this.dom = dom;
	}
	public int getSeg() {
		return seg;
	}
	public void setSeg(int seg) {
		this.seg = seg;
	}
	public int getTer() {
		return ter;
	}
	public void setTer(int ter) {
		this.ter = ter;
	}
	public int getQua() {
		return qua;
	}
	public void setQua(int qua) {
		this.qua = qua;
	}
	public int getQui() {
		return qui;
	}
	public void setQui(int qui) {
		this.qui = qui;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getSab() {
		return sab;
	}
	public void setSab(int sab) {
		this.sab = sab;
	}
	public String getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}
	
}
