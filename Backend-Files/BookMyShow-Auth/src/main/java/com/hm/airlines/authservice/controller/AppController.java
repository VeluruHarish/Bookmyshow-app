package com.hm.airlines.authservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.airlines.authservice.dto.Message;
import com.hm.airlines.authservice.model.User;

@RestController
@RequestMapping("/auth")
public class AppController {
	
	
	@GetMapping("/public")
	public Message sayHelloWorld() {
		return new Message("Hello World");
	}

	@GetMapping("/user")
	public Message sayHelloUser() {
		return new Message("Hello User");
	}
	
	@GetMapping("/admin")
	public Message sayHelloAdmin() {
		System.out.println("Hello");
		return new Message("Hello Admin");
	}
	@GetMapping("/login")
	public Message userlogin() {
		return new Message("our things");
	}
	
	@GetMapping("/userDetails")
	public User sendUser() {
		return null;
	}
}
