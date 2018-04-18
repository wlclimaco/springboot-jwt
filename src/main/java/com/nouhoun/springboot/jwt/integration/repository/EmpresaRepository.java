package com.nouhoun.springboot.jwt.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nouhoun.springboot.jwt.integration.domain.Empresa;

@Repository("empresaRepository")
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	@Query("SELECT u  FROM Empresa u WHERE u.email = :email")
	Empresa findByEmail(@Param("email") String user);

	@Query("SELECT e  FROM User u, Empresa e  WHERE u.empresaId = e.id and u.email = :email")
	List<Empresa> findEmpresaByUser(@Param("email") String user);
}
