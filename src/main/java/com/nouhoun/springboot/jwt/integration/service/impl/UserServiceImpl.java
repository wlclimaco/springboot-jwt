package com.nouhoun.springboot.jwt.integration.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.repository.RoleRepository;
import com.nouhoun.springboot.jwt.integration.repository.UserRepository;
import com.nouhoun.springboot.jwt.integration.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    

	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void updateUser(User user, HttpServletRequest request) {
        user.setCurrentLoginAt(new Date());
        user.setCurrentLoginIp(request.getRemoteHost());
		userRepository.save(user);
	}
	@Override
	public void saveUser(User user, HttpServletRequest request) {
		user.setPassword(User.hashPassword(user.getPassword()));
        user.setCurrentLoginAt(new Date());
        user.setCurrentLoginIp(request.getRemoteHost());
        user.setLoginCount(0);
		userRepository.save(user);
	}

	@Override
	public boolean isValidPass(User user, String rawPass) {
		return User.doesPasswordMatch(rawPass, user.getPassword());
	}

	@Override
	public User loginUser(User user, HttpServletRequest request) {
		Integer a = 1;
    	if(user.getLoginCount() != null)
    	{
    		a = user.getLoginCount() + 1;
    	}
		user.setLastLoginAt(user.getCurrentLoginAt());
        user.setLastLoginIp(user.getCurrentLoginIp());
        user.setCurrentLoginAt(new Date());
        user.setCurrentLoginIp(request.getRemoteHost());
        user.setLoginCount(a);
        user.setUpdatedAt(new Date());

        return userRepository.save(user);
	}

	@Override
	public User findUserById(Integer id) {
		return userRepository.findUserById(id);
	}

	@Override
	public List<User> findAllUser() {
		return (List<User>) userRepository.findAll();
	}



}
