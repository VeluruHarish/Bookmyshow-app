package com.hm.Capstoneproject.gmail.model;





import lombok.Data;

@Data

public class User {

	
	private int userId;
	
	private String username;
	
	private String email;
	
	private String password;

	private Role role;

}
