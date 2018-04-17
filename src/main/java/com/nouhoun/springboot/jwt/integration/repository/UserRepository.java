package com.nouhoun.springboot.jwt.integration.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nouhoun.springboot.jwt.integration.domain.User;

/**
 * Created by nydiarra on 06/05/17.
 */
public interface UserRepository extends CrudRepository<User, Long> {
<<<<<<< HEAD
	@Query("SELECT p  FROM User u WHERE u.username = :email")
	User findByUsername(@Param("email") String user);
    
	@Query("SELECT p  FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String user);
    
	@Query("SELECT p  FROM User u p WHERE u.id= :email")
    User findUserById(@Param("email") Integer user);
    
=======
	@Query("SELECT j FROM User j where j.username =:username")
	User findByUsername(@Param("username") String username);
    
	@Query("SELECT j FROM User j where j.email =:email")
    User findByEmail(@Param("email") String email);
    
	@Query("SELECT j FROM User j where j.id =:id")
    User findUserById(@Param("id") Integer id);
>>>>>>> branch 'master' of https://github.com/wlclimaco85/springboot-jwt.git
}
