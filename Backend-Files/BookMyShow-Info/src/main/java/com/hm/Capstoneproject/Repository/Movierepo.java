package com.hm.Capstoneproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hm.Capstoneproject.model.Genre;
import com.hm.Capstoneproject.model.Movie;


public interface Movierepo extends JpaRepository<Movie, Integer> {
	
	public List<Movie> findByGenreIn(List<Genre> list);

}
