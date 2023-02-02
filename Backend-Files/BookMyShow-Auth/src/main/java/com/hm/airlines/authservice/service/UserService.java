package com.hm.airlines.authservice.service;

import com.hm.airlines.authservice.model.User;

public interface UserService {

	public User getUserByUsername(String username);
	
	public User saveUser(User user);
	
	public void initRolesAndUser();
	
	public String getEncodedPassword(String password);
	
	
	
}
