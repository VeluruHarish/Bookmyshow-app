package com.hm.Capstoneproject.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;



public class Booking {
	
	
	private Show show;
	private	List<Seat> bookedSeats= new ArrayList<>();
	

}
