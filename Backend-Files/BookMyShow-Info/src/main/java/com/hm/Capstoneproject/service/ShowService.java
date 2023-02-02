package com.hm.Capstoneproject.service;

import java.util.List;

import com.hm.Capstoneproject.dto.AvailableSeats;
import com.hm.Capstoneproject.model.Movie;
import com.hm.Capstoneproject.model.Screen;
import com.hm.Capstoneproject.model.Show;

public interface ShowService {

	public Show addshow(Show Show);
	public void deleteshow(Show show);
	public Show updateShow(Show show);
	public List<Show> allShows();
	public Show getbyId(int id);
	public AvailableSeats detailsofshow(int id);
	
	public void deleteShowsWithSeats(List<Show> shows);
	public List<Show> findByScreen(Screen screen);
	
	public List<Show> findByMovie(Movie movie);
	 
}
