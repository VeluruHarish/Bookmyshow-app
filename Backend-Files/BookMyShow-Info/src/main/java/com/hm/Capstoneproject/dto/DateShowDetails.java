package com.hm.Capstoneproject.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;


@Data
public class DateShowDetails {

	private LocalDate date;
	private List<Integer> ids;
}
