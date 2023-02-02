package com.hm.Capstoneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.Capstoneproject.Exception.NoSuchElementException;
import com.hm.Capstoneproject.Repository.Movierepo;
import com.hm.Capstoneproject.Repository.showrepo;
import com.hm.Capstoneproject.model.Genre;
import com.hm.Capstoneproject.model.Movie;
import com.hm.Capstoneproject.model.Show;

@Service
public class MovieServiceIMPL implements MovieService {

	 @Autowired
	    Movierepo repo;
	 
	 @Autowired
	 showrepo sRepo;
	 
	 @Autowired
	 ShowService showService;
	    @Override
	    public Movie getMovieById(int movieId) {
	    	if(!repo.existsById(movieId)) {
	    		throw new NoSuchElementException("Movie with Id "+movieId+" not found.");
	    	}
	        return repo.findById(movieId).get();
	    }
	    @Override
	    public List<Movie> getAllMovies() {
	    	if(repo.findAll().isEmpty()) {
	    		throw new NoSuchElementException("Movies Not Available");
	    	}
	        return repo.findAll();
	    }
	    
	    @Override
	    public List<Movie> getMoviesByGenre(List<Genre> genres) {
	    	if(repo.findByGenreIn(genres).isEmpty()){
    		throw new NoSuchElementException("No movie available on these"+genres);
	    	}
	        return repo.findByGenreIn(genres);
	    }
	    
	    @Override
	    public void deleteMovie(Movie movie) {
	    	System.out.println("Working");
	       List<Show> shows= showService.findByMovie(movie);
	       showService.deleteShowsWithSeats(shows);
//	       sRepo.deleteAllInBatch(shows);
	       repo.delete(movie);
	    }
	    
	    @Override
	    public Movie saveMovie(Movie movie) {
	        return repo.save(movie);
	    }
		
}
