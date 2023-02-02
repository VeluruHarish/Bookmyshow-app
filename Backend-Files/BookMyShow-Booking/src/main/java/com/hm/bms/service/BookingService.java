package com.hm.bms.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hm.bms.dto.BookingRequest;
import com.hm.bms.model.Booking;

public interface BookingService {
	
	public List<Booking> getAllBookings();
	
//	public Booking getBookingById(int bookingid);
	
	public Booking saveBooking(BookingRequest bookingRequest,HttpServletRequest request);
	
//	public List<Booking> getBookingByShowId(int showId);
	
	public void getBooking(HttpServletRequest request);

}
