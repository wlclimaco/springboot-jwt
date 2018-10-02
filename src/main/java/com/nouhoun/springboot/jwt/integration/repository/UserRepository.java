package com.nouhoun.springboot.jwt.integration.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.domain.User1;

/**
 * Created by nydiarra on 06/05/17.
 */
public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT u  FROM User u WHERE u.email = :email")
	User findByUsername(@Param("email") String user);
	
	@Query("SELECT u  FROM User1 u WHERE u.email = :email")
	User1 findByUsername1(@Param("email") String user);
    
	@Query("SELECT u  FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String user);
    
	@Query("SELECT u  FROM User u WHERE u.id= :email")
    User findUserById(@Param("email") Integer user);
    
}
