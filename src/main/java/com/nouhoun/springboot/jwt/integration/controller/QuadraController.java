package com.nouhoun.springboot.jwt.integration.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nouhoun.springboot.jwt.integration.domain.Empresa;
import com.nouhoun.springboot.jwt.integration.domain.Quadra;
import com.nouhoun.springboot.jwt.integration.service.QuadraService;


@Controller
public class QuadraController {

	@Autowired
	private QuadraService quadraService;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/quadra/fetchAll", method = RequestMethod.POST)
	public ResponseEntity<List<Quadra>> fetchAllQuadra(@Valid Empresa user, BindingResult bindingResult) {

		List<Quadra> quadra = quadraService.findAllQuadra();

		return new ResponseEntity<List<Quadra>>(quadra, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/quadra/findQuadraByUser", method = RequestMethod.POST)
	public ResponseEntity<List<Quadra>> findQuadraByUser(@RequestBody Integer user, BindingResult bindingResult) {

		List<Quadra> quadra = quadraService.findQuadraByUser(user);

		return new ResponseEntity<List<Quadra>>(quadra, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/quadra/findAllQuadraByEmpresa", method = RequestMethod.POST)
	public ResponseEntity<List<Empresa>> findAllQuadraByEmpresa(@RequestBody String users, BindingResult bindingResult) {

		ObjectMapper mapper = new ObjectMapper();
		Empresa user;
		List<Empresa> quadra = null;
		try {
			user = mapper.readValue(users, Empresa.class);
			quadra = quadraService.findAllQuadraByEmpresa(user.getId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return new ResponseEntity<List<Empresa>>(quadra, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/quadra/findAllQuadraById", method = RequestMethod.POST)
	public ResponseEntity<List<Quadra>> findAllQuadraById(@Valid Quadra user, BindingResult bindingResult) {

		List<Quadra> quadra = quadraService.findQuadraByUser(user.getId());

		return new ResponseEntity<List<Quadra>>(quadra, HttpStatus.OK);
	}

}
