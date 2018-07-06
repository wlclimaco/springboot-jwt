package com.nouhoun.springboot.jwt.integration.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * The core Job Entity
 *
 * Created by Y.Kamesh on 8/2/2015.
 */
/**
 * @author Washington
 *
 */

public class NotasGolsDTO {
	List<NotasGols> notasGols = new ArrayList<NotasGols>();

	public List<NotasGols> getNotasGols() {
		return notasGols;
	}

	public void setNotasGols(List<NotasGols> notasGols) {
		this.notasGols = notasGols;
	}
	
	
}
