package com.hm.Capstoneproject.gmail.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@Component
public class Booking {
	
	
	private int id;
	private int showId;
	private LocalDateTime showtime;
	private String screenName;
	private String multiplexName;
	private String cityName;
	private String multiplexAddress;
	private String movieName;
	private List<Integer> bookedSeatNos;

}
