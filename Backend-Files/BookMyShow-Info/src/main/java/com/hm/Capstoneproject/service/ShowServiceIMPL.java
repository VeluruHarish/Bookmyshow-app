package com.hm.Capstoneproject.service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.Capstoneproject.Repository.showrepo;
import com.hm.Capstoneproject.dto.AvailableSeats;
import com.hm.Capstoneproject.dto.LayoutSeat;
import com.hm.Capstoneproject.model.Movie;
import com.hm.Capstoneproject.model.Screen;
import com.hm.Capstoneproject.model.Seat;
import com.hm.Capstoneproject.model.Show;

@Service
public class ShowServiceIMPL  implements ShowService{

	@Autowired
	showrepo repo;

	
	@Override
	public Show addshow(Show show) {
		List<Show> shows = repo.findByScreen(show.getScreen());
		for(Show show1:shows) {
		long diff=show1.getStartTime().until(show.getStartTime(), ChronoUnit.HOURS);
		if(diff<4) {
			throw new NoSuchElementException("show in conflict with existing show");
		}
		}
		 return repo.save(show);
//		return "show saved";
	
	}

	@Override
	public void deleteshow(Show show) {
		if(repo.findById(show.getId()).isEmpty()) {
			throw new NoSuchElementException("No Show with id"+show.getId());
		}
		repo.delete(show);
		
	}

	@Override
	public Show updateShow(Show show) {
		return repo.save(show);
	}

	@Override
	public List<Show> allShows() {
		if(repo.findAll().isEmpty()) {
			throw new NoSuchElementException("No Shows Available");
		}
		return repo.findAll();
	}

	@Override
	public Show getbyId(int id) {
		if(!repo.existsById(id)) {
			throw new NoSuchElementException("No Show with Id"+id);
		}
		return repo.getById(id);
	}

	@Override
	public AvailableSeats detailsofshow(int id) {
		List<LayoutSeat> ls=new ArrayList<>();
		Show show=repo.getById(id);
		if(!(show==null)) {
			List<Integer> bookedSeats=show.getBookedSeats();
			for (Seat seat:show.getScreen().getSeats()) {
			ls.add(new LayoutSeat(seat.getId(),seat.getSeatNo(),false,(bookedSeats.contains(seat.getId()))));
			}
			System.out.println(ls);
		}
		return new AvailableSeats(ls,show);
	}

	@Override
	public void deleteShowsWithSeats(List<Show> shows) {
	
		for (Show show:shows) {
			show.setBookedSeats(null);
		}
		repo.deleteAllInBatch(shows);
	}

	@Override
	public List<Show> findByScreen(Screen screen) {
		// TODO Auto-generated method stub
		return repo.findByScreen(screen);
	}

	@Override
	public List<Show> findByMovie(Movie movie) {
		// TODO Auto-generated method stub
		return repo.findByMovie(movie);
	}
	
	

}
