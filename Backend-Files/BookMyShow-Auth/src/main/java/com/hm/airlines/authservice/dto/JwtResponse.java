package com.hm.airlines.authservice.dto;

import com.hm.airlines.authservice.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
	
	private String jwtToken;
	private User user;

}
