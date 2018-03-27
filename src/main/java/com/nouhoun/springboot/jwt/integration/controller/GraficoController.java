package com.nouhoun.springboot.jwt.integration.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nouhoun.springboot.jwt.api.APIResponse;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.service.UserService;


@Controller
public class GraficoController {

	@Autowired
	private UserService userService;


//	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/grafico/insert", method = RequestMethod.POST)
	public @ResponseBody APIResponse createNewMensagem(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> erros = new ArrayList<>();
		User userExists = userService.findUserByEmail(user.getUsername());
		if (userExists != null) {
			erros.add("There is already a user registered with the email provided");
		}

			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");


	HashMap<String, Object> authResp = new HashMap<>();
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	Object token = auth.getCredentials();
	authResp.put("token", token);
	authResp.put("user", user);
	authResp.put("Error", erros);


    return APIResponse.toOkResponse(authResp);
	}

//	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/grafico/update", method = RequestMethod.POST)
	public @ResponseBody APIResponse updateMensagem(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> erros = new ArrayList<>();
		User userExists = userService.findUserByEmail(user.getUsername());
		if (userExists != null) {
			erros.add("There is already a user registered with the email provided");
		}

			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");


	HashMap<String, Object> authResp = new HashMap<>();
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	Object token = auth.getCredentials();
	authResp.put("token", token);
	authResp.put("user", user);
	authResp.put("Error", erros);


    return APIResponse.toOkResponse(authResp);
	}

//	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/grafico/delete", method = RequestMethod.POST)
	public @ResponseBody APIResponse deleteMensagem(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> erros = new ArrayList<>();
		User userExists = userService.findUserByEmail(user.getUsername());
		if (userExists != null) {
			erros.add("There is already a user registered with the email provided");
		}

			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");


	HashMap<String, Object> authResp = new HashMap<>();
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	Object token = auth.getCredentials();
	authResp.put("token", token);
	authResp.put("user", user);
	authResp.put("Error", erros);


    return APIResponse.toOkResponse(authResp);
	}

//	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/grafico/fetchByUser", method = RequestMethod.POST)
	public @ResponseBody APIResponse fetchByUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> erros = new ArrayList<>();
		User userExists = userService.findUserByEmail(user.getUsername());
		if (userExists != null) {
			erros.add("There is already a user registered with the email provided");
		}

			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");


	HashMap<String, Object> authResp = new HashMap<>();
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	Object token = auth.getCredentials();
	authResp.put("token", token);
	authResp.put("user", user);
	authResp.put("Error", erros);


    return APIResponse.toOkResponse(authResp);
	}

	private void createAuthResponse(User user, HashMap<String, Object> authResp,ArrayList<String> erros) {
        String token = "";
        		//Jwts.builder().setSubject(user.getEmail())
               // .claim("role", user.getRole().name()).setIssuedAt(new Date())
              // .signWith(SignatureAlgorithm.HS256, JWTTokenAuthFilter.JWT_KEY).compact();
        authResp.put("token", token);
        authResp.put("user", user);
        authResp.put("Error", erros);
    }


}
