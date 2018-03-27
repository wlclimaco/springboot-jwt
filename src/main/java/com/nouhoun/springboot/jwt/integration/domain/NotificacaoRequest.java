package com.nouhoun.springboot.jwt.integration.domain;

/**
 * {"name":"job1", "metadataJsonString":"{}", "callbackUrl":"", "catId":1}
 *
 * @author: kameshr
 */
public class NotificacaoRequest {
    Integer userId;
    Role role;
    Integer empresaId;
    Integer jogoId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Integer getEmpresaId() {
		return empresaId;
	}
	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}
	public Integer getJogoId() {
		return jogoId;
	}
	public void setJogoId(Integer jogoId) {
		this.jogoId = jogoId;
	}
	@Override
	public String toString() {
		return "NotificacaoRequest [getUserId()=" + getUserId() + ", getRole()=" + getRole() + ", getEmpresaId()="
				+ getEmpresaId() + ", getJogoId()=" + getJogoId() + ", toString()=" + super.toString() + "]";
	}

   
}
