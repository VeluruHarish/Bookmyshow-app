package com.hm.Capstoneproject.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="screen")
public class Screen {
	@Id
	private int id;
	private String name;
	private int noOfSeats;
	@OneToMany(cascade = {CascadeType.MERGE})
	private List<Seat> seats;
}
