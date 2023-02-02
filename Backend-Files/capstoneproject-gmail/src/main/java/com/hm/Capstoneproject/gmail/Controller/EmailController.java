package com.hm.Capstoneproject.gmail.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hm.Capstoneproject.gmail.Repository.EmailServiceImpl;
import com.hm.Capstoneproject.gmail.model.Booking;
import com.hm.Capstoneproject.gmail.model.EmailDetails;
import com.hm.Capstoneproject.gmail.model.User;

@RestController
public class EmailController {
@Autowired EmailServiceImpl Emailservice;

@PostMapping("/sendmail")
public String simpleemail(@RequestBody EmailDetails details) {
	return Emailservice.sendSimpleMail(details);
}

@PostMapping("/bookingMail")
public void sendMail(@RequestBody Booking booking) {
	Emailservice.Ticket(booking);
}
@PostMapping("/userEmail")
public void getEmail(@RequestBody User user) {
	Emailservice.Email(user);
}
}
