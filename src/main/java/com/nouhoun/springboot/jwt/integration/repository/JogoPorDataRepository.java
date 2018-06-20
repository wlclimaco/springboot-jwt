package com.nouhoun.springboot.jwt.integration.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nouhoun.springboot.jwt.integration.domain.JogoPorData;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorData.StatusJogoPorData;

@Repository("jogoPorDataRepository")
public interface JogoPorDataRepository extends JpaRepository<JogoPorData, Long> {

	//void save(List<JogoPorData> jogos);
	
//	Empresa findByEmail(String email);

	//List<Empresa> findEmpresaByUser(Empresa empresa);
	
    @Query("SELECT u  FROM JogoPorData u WHERE cast(u.data as date) = :data AND cast(u.dataFinal as date) = :data1 AND u.jogoId = :jogoId")
    JogoPorData findJogoPorDataUserConfirmDTO(@Param("jogoId") Integer jogoId,@Param("data") Date data,@Param("data1") Date data1 );
    
    @Modifying
	@Query("UPDATE JogoPorData  j SET j.status =?1 WHERE j.jogoId=?2")
	List<JogoPorData> updateJogoPorDataStatus(StatusJogoPorData status,Integer jogoId);
    
    @Query("SELECT u  FROM JogoPorData u WHERE u.status =?1 and u.jogoId =?2")
    List<JogoPorData> findJogoPorDataByStatus(StatusJogoPorData status, Integer jogoId);
    
}
