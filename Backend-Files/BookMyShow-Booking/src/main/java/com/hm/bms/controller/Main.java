package com.hm.bms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hm.bms.dto.BookingRequest;
import com.hm.bms.model.Booking;
import com.hm.bms.service.BookingService;

@RestController
//@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/booking")
public class Main {
	
	@Autowired
	RestTemplate rt;
	
	@Autowired
	BookingService service;
	
	@PostMapping("/book")
	public Booking bookShow(@RequestBody BookingRequest bookingRequest, HttpServletRequest request) {
//		System.out.println("hiiiiiiiii"+booking);
		return service.saveBooking(bookingRequest,request);
	}
	
	@GetMapping("/book")
	public List<Booking> getBookings() {
		return service.getAllBookings();
	}
	
	@GetMapping("/show")
	public void getshow(HttpServletRequest request) {
		service.getBooking(request);
	}

}
