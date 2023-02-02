package com.hm.airlines.authservice.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.airlines.authservice.dto.JwtResponse;
import com.hm.airlines.authservice.dto.JwtToken;
import com.hm.airlines.authservice.dto.UserCredentials;
import com.hm.airlines.authservice.model.User;
import com.hm.airlines.authservice.service.UserAuthService;
import com.hm.airlines.authservice.service.UserService;
import com.hm.airlines.authservice.service.UserServiceImpl;


@RestController
@RequestMapping("/auth/public")
//@CrossOrigin(origins="http://localhost:4200/")
public class UserAuthenticationController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private UserAuthService authService;
	
//	@PostConstruct
//	public void initRolesAndUsers() {
//		service.initRolesAndUser();
//	}
	

	@PostMapping("/registerNewUser")
	public User addUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@PostMapping("/authenticate")
	public JwtResponse login(@RequestBody UserCredentials credentials) {
		return authService.validateCredentials(credentials);
	}
	
}
