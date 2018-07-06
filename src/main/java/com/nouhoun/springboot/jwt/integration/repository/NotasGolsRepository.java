package com.nouhoun.springboot.jwt.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nouhoun.springboot.jwt.integration.domain.NotasGols;
import com.nouhoun.springboot.jwt.integration.domain.UserJogoData;

@Repository("NotasGolsRepository")
public interface NotasGolsRepository extends JpaRepository<NotasGols, Long> {

	
    
}
