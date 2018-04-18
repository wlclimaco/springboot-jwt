package com.nouhoun.springboot.jwt.integration.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nouhoun.springboot.jwt.integration.domain.User;

/**
 * Created by nydiarra on 06/05/17.
 */
public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT u  FROM User u WHERE u.username = :email")
	User findByUsername(@Param("email") String user);
    
	@Query("SELECT u  FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String user);
    
	@Query("SELECT u  FROM User u WHERE u.id= :email")
    User findUserById(@Param("email") Integer user);
    
}
