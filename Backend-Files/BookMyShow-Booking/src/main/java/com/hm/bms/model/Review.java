package com.hm.bms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Review {
	
	private String user;
	private String reviewText;
	

}
