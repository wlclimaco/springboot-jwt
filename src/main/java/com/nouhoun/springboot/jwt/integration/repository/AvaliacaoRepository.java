package com.nouhoun.springboot.jwt.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nouhoun.springboot.jwt.integration.domain.Avaliacao;

@Repository("avaliacaoRepository")
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
	
}
