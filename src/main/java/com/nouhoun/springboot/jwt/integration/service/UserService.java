package com.nouhoun.springboot.jwt.integration.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.nouhoun.springboot.jwt.integration.domain.User;



public interface UserService {
	public User findUserByEmail(String email);
	public User findUserById(Integer id);
	public void saveUser(User user,HttpServletRequest request);
	public void updateUser(User user,HttpServletRequest request);
	boolean isValidPass(User user, String rawPass);
	User loginUser(User user, HttpServletRequest request);
	
	public List<User> findAllUser();
}
