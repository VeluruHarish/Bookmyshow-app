package com.hm.bms.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int showId;
	private LocalDateTime showtime;
	private String screenName;
	private String multiplexName;
	private String cityName;
	private String multiplexAddress;
	private String movieName;
	@ElementCollection
	private List<Integer> bookedSeatNos;
	@Override
	public String toString() {
		return "Booking [id=" + id + ", showId=" + showId + ", showtime=" + showtime + ", screenName=" + screenName
				+ ", multiplexName=" + multiplexName + ", cityName=" + cityName + ", multiplexAddress="
				+ multiplexAddress + ", movieName=" + movieName + ", bookedSeatNos=" + bookedSeatNos + "]";
	}
	
//	public String toStringforList(List<Integer> nos) {
//		String string = "";
//		for (int no:nos) {
//			string.concat(""+no",);
//		}
//	}
	
	
	

}
