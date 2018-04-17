package com.nouhoun.springboot.jwt.integration.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> branch 'master' of https://github.com/wlclimaco85/springboot-jwt.git

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nouhoun.springboot.jwt.integration.domain.Role;
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
	public void saveUser(User user) {
<<<<<<< HEAD
	//	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    //    user.setActive(1);
=======
		//user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
>>>>>>> branch 'master' of https://github.com/wlclimaco85/springboot-jwt.git
    //    Role userRole = roleRepository.findByRole("ADMIN");
    //    user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
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
<<<<<<< HEAD

	@Override
	public List<User> findAllUser() {
		return (List<User>) userRepository.findAll();
	}

=======
>>>>>>> branch 'master' of https://github.com/wlclimaco85/springboot-jwt.git

}
