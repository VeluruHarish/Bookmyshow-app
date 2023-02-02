package com.hm.Capstoneproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="city")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","movies"})
public class City {
 
	@Id
	private int id;
	private String name;
//	@JoinTable(name = "city_movie")
//	@ManyToMany(cascade = CascadeType.MERGE)
//	private List<Movie> movies;
}
