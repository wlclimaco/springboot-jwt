package com.nouhoun.springboot.jwt.integration.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nouhoun.springboot.jwt.integration.domain.User1;
import com.nouhoun.springboot.jwt.integration.domain.security.User;

/**
 * Created by stephan on 20.03.16.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
	
	@Query("SELECT u  FROM User1 u WHERE u.email = :email")
	User1 findByUsername1(@Param("email") String user);
    
	@Query("SELECT u  FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String user);
    
	@Query("SELECT u  FROM User u WHERE u.id= :email")
    User findUserById(@Param("email") Integer user);
}
