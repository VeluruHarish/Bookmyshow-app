 
package com.hm.Capstoneproject.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="movie")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Movie {

	@Id
	private int id;
	private String title;
//	@ElementCollection
	@Enumerated(EnumType.STRING)
	private Genre genre;
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
