package com.nouhoun.springboot.jwt.integration.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nouhoun.springboot.jwt.integration.domain.User;

/**
 * Created by nydiarra on 06/05/17.
 */
public interface UserRepository extends CrudRepository<User, Long> {
	@Query("SELECT j FROM User j where j.username =:username")
	User findByUsername(@Param("username") String username);
    
	@Query("SELECT j FROM User j where j.email =:email")
    User findByEmail(@Param("email") String email);
    
	@Query("SELECT j FROM User j where j.id =:id")
    User findUserById(@Param("id") Integer id);
}
