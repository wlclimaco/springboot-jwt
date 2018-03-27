package com.nouhoun.springboot.jwt.integration.service;

import java.util.List;

import com.nouhoun.springboot.jwt.integration.domain.Empresa;
import com.nouhoun.springboot.jwt.integration.domain.Quadra;



public interface QuadraService {

	public List<Quadra> findQuadraByUser(Integer userId);
	public List<Quadra> findAllQuadra();
	public List<Empresa> findAllQuadraByEmpresa(Integer empresaId);
	public Quadra findAllQuadraById(Integer id);

}
