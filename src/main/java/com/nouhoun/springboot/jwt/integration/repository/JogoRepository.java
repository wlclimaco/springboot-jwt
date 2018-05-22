package com.nouhoun.springboot.jwt.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nouhoun.springboot.jwt.integration.domain.Jogo;
import com.nouhoun.springboot.jwt.integration.domain.Jogo.Processo;
import com.nouhoun.springboot.jwt.integration.domain.Jogo.Status;
import com.nouhoun.springboot.jwt.integration.domain.UserJogo2;

@Repository("jogoRepository")
public interface JogoRepository extends JpaRepository<Jogo, Long> {

	//void save(List<JogoPorData> jogos);
	
//	Empresa findByEmail(String email);
	// custom query example and return a stream
    @Query("SELECT p  FROM UserJogo2 u, Jogo p WHERE p.id=u.jogo_id and u.user_id= :email")
    List<Jogo> findJogoByUser(@Param("email") Integer user);

    @Query("SELECT p  FROM Jogo  p WHERE p.id= :email")
    Jogo findJogoById(@Param("email") Integer user);
    
    @Modifying
	@Query("UPDATE Jogo  j SET j.status =?1 WHERE j.id=?2")
	List<UserJogo2> updateStatus(Status status,Integer jogoId);
    
    @Query("SELECT u  FROM Jogo u WHERE u.status =?1 and u.processo =?2")
    List<Jogo> findJogoByStatus(Status status, Processo processo);
	
}
