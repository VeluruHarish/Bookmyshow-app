package com.hm.airlines.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hm.airlines.authservice.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findUserByUsername(String username);
	
	
	public boolean existsByUsername(String username);
	
}
