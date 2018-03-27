package com.nouhoun.springboot.jwt.integration.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nouhoun.springboot.jwt.integration.domain.JogoPorData;

@Repository("jogoPorDataRepository")
public interface JogoPorDataRepository extends JpaRepository<JogoPorData, Long> {

	//void save(List<JogoPorData> jogos);
	
//	Empresa findByEmail(String email);

	//List<Empresa> findEmpresaByUser(Empresa empresa);
	
    @Query("SELECT u  FROM JogoPorData u WHERE u.data = :data and u.jogoId = :jogoId")
    List<JogoPorData> findJogoPorDataUserConfirmDTO(@Param("data") Date data,@Param("jogoId") Integer jogoId );
}
