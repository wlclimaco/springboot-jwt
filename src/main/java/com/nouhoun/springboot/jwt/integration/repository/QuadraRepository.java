package com.nouhoun.springboot.jwt.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nouhoun.springboot.jwt.integration.domain.Empresa;
import com.nouhoun.springboot.jwt.integration.domain.Quadra;

@Repository("quadraRepository")
public interface QuadraRepository extends JpaRepository<Quadra, Long> {
	
	@Query("select u from Quadra u where u.id = ?1")
	public List<Quadra> findQuadraByUser(Integer userId);

//	select account, payment
//	from Account as account
//	    left outer join account.payments as payment+
//	"order by pos.dataFim, pos.nivel"
	@Query("select u from Empresa u where u.id = ?1")
	public List<Empresa> findAllQuadraByEmpresa(Integer empresaId);
	@Query("select u from Quadra u where u.id = ?1")
	public Quadra findAllQuadraById(Integer id);
}
