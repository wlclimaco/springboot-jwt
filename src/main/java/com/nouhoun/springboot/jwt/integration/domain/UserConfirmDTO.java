package com.nouhoun.springboot.jwt.integration.domain;

import com.nouhoun.springboot.jwt.integration.domain.JogoPorData.StatusJogoPorData;

/**
 *
 * {"name":"cat1", "priority":2, "parent":"pCat"}
 *
 * @author: kameshr
 */
public class UserConfirmDTO {
    Integer userId;
    StatusJogoPorData status;
    
    
	public UserConfirmDTO(Integer userId, StatusJogoPorData status) {
		super();
		this.userId = userId;
		this.status = status;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public StatusJogoPorData getStatus() {
		return status;
	}
	public void setStatus(StatusJogoPorData status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "UserConfirmDTO [getUserId()=" + getUserId() + ", getStatus()=" + getStatus() + ", toString()="
				+ super.toString() + "]";
	}

}
