package com.hm.bms.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Movie {

	private int id;
	private String title;
	private String genre;
	private String language;
	private String format;
	private double rating;
	private int duration;
	private LocalDate dateOfRelease;
	private String about;
	private String cast;
	private String crew;
	private String image;
	private String backgroundImage;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<Review> reviews;
	
	
	
}
