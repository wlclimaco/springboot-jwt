package com.nouhoun.springboot.jwt.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nouhoun.springboot.jwt.integration.domain.UserJogo2;
import com.nouhoun.springboot.jwt.integration.domain.UserJogo2.StatusUser;

@Repository("jogoUserRepository")
public interface JogoUserRepository extends JpaRepository<UserJogo2, Long> {

	@Query("SELECT p  FROM UserJogo2  p WHERE p.jogo_id= :email")
	List<UserJogo2> findJogoUserByJogoId(@Param("email") Integer user);
	
	@Query("UPDATE UserJogo2  j SET j.status_user =:status WHERE j.jogo_id= :jogoId")
	List<UserJogo2> updateStatus(@Param("status") StatusUser status,@Param("jogoId") Integer jogoId);
	
	//void save(List<JogoPorData> jogos);
	
//	Empresa findByEmail(String email);

	//List<Empresa> findEmpresaByUser(Empresa empresa);
}
