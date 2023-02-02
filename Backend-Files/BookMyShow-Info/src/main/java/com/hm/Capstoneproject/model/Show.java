package com.hm.Capstoneproject.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.mapping.ToOne;
import org.springframework.data.convert.Jsr310Converters.LocalDateTimeToInstantConverter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import lombok.Data;

@Data
@Entity
@Table(name="shows")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Show {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime startTime;
//	private LocalDate showDate;
//	private LocalTime showStartTime;
	@OneToOne
	private Movie movie;
	@OneToOne
	private Screen screen;
	@ElementCollection
	private List<Integer> bookedSeats;

}
