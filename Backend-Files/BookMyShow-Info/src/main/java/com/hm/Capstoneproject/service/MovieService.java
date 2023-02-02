package com.hm.Capstoneproject.service;

import java.util.List;

import com.hm.Capstoneproject.model.Genre;
import com.hm.Capstoneproject.model.Movie;

public interface MovieService {

	 public Movie getMovieById(int movieid);
	    public List<Movie> getAllMovies();
	    public List<Movie> getMoviesByGenre(List<Genre> genres);
	    public void deleteMovie(Movie movie);
	    public Movie saveMovie(Movie movie);
	    
	//  public Movie updateMovie(Movie movie);
}
