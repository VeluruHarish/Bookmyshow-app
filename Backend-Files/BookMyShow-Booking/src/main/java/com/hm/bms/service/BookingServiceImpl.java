package com.hm.bms.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.hm.bms.dto.BookingRequest;
import com.hm.bms.model.Booking;
import com.hm.bms.model.Multiplex;
import com.hm.bms.model.Seat;
import com.hm.bms.model.Show;
import com.hm.bms.repository.BookingRepo;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingRepo repo;
	
	@Autowired
	RestTemplate rt;

	@Override
	public List<Booking> getAllBookings() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

//	@Override
//	public Booking getBookingById(int bookingid) {
//		// TODO Auto-generated method stub
//		return repo.getById(bookingid);
//	}
	public HttpEntity<String> httpreuest(HttpServletRequest request) {
	String header = request.getHeader("auth");
	System.out.println(header);
	
	HttpHeaders headers = new HttpHeaders();
	headers.set("Accept", "application/json");
	headers.set("auth", header);
	HttpEntity<String> httpEntity = new HttpEntity<>(null,headers);
	return httpEntity;
	}
	@Override
	public Booking saveBooking(BookingRequest bookingRequest,HttpServletRequest request) {
		System.out.println("hi");
		HttpEntity<String> httpEntity= httpreuest(request);
		System.out.println(bookingRequest);
		int showId= bookingRequest.getShowId();
		List<Integer> wantedSeats = bookingRequest.getBookedSeatIds();
		ResponseEntity<Show> showres = rt.exchange("http://BOOKMYSHOW-INFO/info/show/"+showId,HttpMethod.GET,httpEntity,Show.class);
		Show show=showres.getBody();
		List<Integer> bookedSeats = show.getBookedSeats();
		for (int seatId:wantedSeats) {
			if(bookedSeats.contains(seatId)) {
				System.out.println("already booked"+seatId);
				return null;
		}}
		List<Integer> seatNos= new ArrayList<>();
		for(int seatId:wantedSeats) {
			for(Seat seat:show.getScreen().getSeats()) {
				if(seat.getId()==seatId) {
					seatNos.add(seat.getSeatNo());
				}
			}
	
		}
		bookedSeats.addAll(bookingRequest.getBookedSeatIds());
		HttpEntity<Show> hEntity = new HttpEntity<Show>(show, httpEntity.getHeaders());
		rt.exchange("http://BOOKMYSHOW-INFO/info/show/"+bookingRequest.getShowId(), HttpMethod.POST,hEntity,Show.class);
		Booking booking = new Booking();
		booking.setShowId(showId);
		booking.setShowtime(show.getStartTime());
		booking.setBookedSeatNos(seatNos);
		booking.setScreenName(show.getScreen().getName());
		ResponseEntity<Multiplex> multiplexres=rt.exchange("http://BOOKMYSHOW-INFO/info/multiplex/screen/"+show.getScreen().getId(),HttpMethod.GET,httpEntity,Multiplex.class);
		Multiplex multiplex=multiplexres.getBody();
		booking.setMultiplexName(multiplex.getName());
		booking.setCityName(multiplex.getCity().getName());
		booking.setMultiplexAddress(multiplex.getAddress());
		booking.setMovieName(show.getMovie().getTitle());
		repo.save(booking);
		HttpEntity<Booking> mEntity = new HttpEntity<Booking>(booking,httpEntity.getHeaders());
		rt.exchange("http://BOOKMYSHOW-GMAIL/bookingMail", HttpMethod.POST,mEntity, Booking.class);
		return booking;
		}

@Override
public void getBooking(HttpServletRequest request) {
	// TODO Auto-generated method stub
	HttpEntity<String> httpEntity= httpreuest(request);
	ResponseEntity<Show> showres =rt.exchange("http://BOOKMYSHOW-INFO/info/show/"+595,HttpMethod.GET,httpEntity, Show.class);
	Show show=showres.getBody();
	HttpEntity<Show> hEntity = new HttpEntity<Show>(show, httpEntity.getHeaders());
	rt.exchange("http://BOOKMYSHOW-INFO/info/show/"+595,HttpMethod.POST,hEntity, Show.class);
}
	
	
}
	



	
	
	
	

//	@Override
//	public List<Booking> getBookingByShowId(int showId) {
//		// TODO Auto-generated method stub
//		return repo.findByShowId(showId);
//	}


