package com.hm.Capstoneproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="multiplex")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Multiplex {
	
	@Id
	private int id;
	private String name;
	private int noOfScreens;
	private String address;
	@OneToOne(cascade = {CascadeType.MERGE})
	private City city;
	@JsonIgnore
	@OneToMany(cascade = {CascadeType.MERGE})
	private List<Show> shows;
	@OneToMany(cascade = {CascadeType.MERGE})
	private List<Screen> screens;
 	
	
	

}
