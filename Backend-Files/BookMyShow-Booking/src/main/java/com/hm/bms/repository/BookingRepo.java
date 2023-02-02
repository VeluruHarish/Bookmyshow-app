package com.hm.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.bms.model.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
	
	public List<Booking> findByShowId(int showId);

}
