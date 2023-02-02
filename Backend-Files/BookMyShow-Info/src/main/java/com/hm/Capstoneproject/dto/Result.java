package com.hm.Capstoneproject.dto;

import java.util.List;

import com.hm.Capstoneproject.model.Multiplex;
import com.hm.Capstoneproject.model.Show;

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
