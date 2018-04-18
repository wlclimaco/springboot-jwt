package com.nouhoun.springboot.jwt.integration.service;

import java.util.List;

import com.nouhoun.springboot.jwt.integration.domain.Empresa;



public interface EmpresaService {
	public Empresa findEmpresaByEmail(String email);
	public void saveEmpresa(Empresa empresa);
	public void updateEmpresa(Empresa empresa);
	public void deleteEmpresa(Empresa empresa);
	public List<Empresa> findEmpresaByUser(String empresa);
	public List<Empresa> findAllEmpresa();
}
