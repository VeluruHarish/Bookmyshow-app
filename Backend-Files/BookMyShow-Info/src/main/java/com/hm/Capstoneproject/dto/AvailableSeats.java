package com.hm.Capstoneproject.dto;

import java.util.List;

import com.hm.Capstoneproject.model.Show;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AvailableSeats {

	
	private List<LayoutSeat> layoutseats;
	private Show show;
}
