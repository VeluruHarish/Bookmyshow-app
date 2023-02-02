package com.hm.airlines.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hm.airlines.authservice.dto.JwtResponse;
import com.hm.airlines.authservice.dto.JwtToken;
import com.hm.airlines.authservice.dto.UserCredentials;
import com.hm.airlines.authservice.exception.InvalidCredentialsException;
import com.hm.airlines.authservice.model.User;
import com.hm.airlines.authservice.repository.UserRepository;
import com.hm.airlines.authservice.util.JwtUtil;
import com.netflix.discovery.converters.Auto;

@Service
public class UserAuthService {
	
	@Autowired
	private UserRepository repo;
	@Autowired
	RestTemplate rt;
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public JwtResponse validateCredentials(UserCredentials credentials) {
		
		System.out.println(credentials);
		User user = repo.findUserByUsername(credentials.getUsername());
//		rt.exchange("http://BOOKMYSHOW-GMAIL/userEmail",HttpMethod.POST, user,User.class);
		
		if(!passwordEncoder.matches(credentials.getPassword(),user.getPassword())) {
			throw new InvalidCredentialsException("Incorrect Password");
		}
		
		String jwt = jwtUtil.generateJwt(user.getUsername());
		
//		JwtToken jwtToken = new JwtToken(jwt);
		
		return new JwtResponse(jwt,user);
		
		
	}
	
	
	
	
}
