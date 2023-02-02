package com.hm.Capstoneproject.dto;
import java.time.LocalDate; 
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ShowsByDate{
	public LocalDate date;
	public List<Result> results;
}