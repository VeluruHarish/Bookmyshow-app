package com.hm.Capstoneproject.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {

	private Multiplex multiplex;
	private List<Show> shows;
}
