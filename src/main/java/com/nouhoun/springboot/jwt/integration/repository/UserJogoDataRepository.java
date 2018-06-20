package com.nouhoun.springboot.jwt.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nouhoun.springboot.jwt.integration.domain.UserJogoData;

@Repository("userJogoDataRepository")
public interface UserJogoDataRepository extends JpaRepository<UserJogoData, Long> {

	
    
}
