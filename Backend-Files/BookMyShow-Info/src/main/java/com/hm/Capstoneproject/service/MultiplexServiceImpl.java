package com.hm.Capstoneproject.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.Capstoneproject.Exception.NoSuchElementException;
import com.hm.Capstoneproject.Repository.Cityrepo;
import com.hm.Capstoneproject.Repository.Movierepo;
import com.hm.Capstoneproject.Repository.MultiplexRepo;
import com.hm.Capstoneproject.Repository.Screenrepo;
import com.hm.Capstoneproject.Repository.showrepo;
import com.hm.Capstoneproject.dto.Result;
import com.hm.Capstoneproject.dto.ShowsByDate;
import com.hm.Capstoneproject.model.City;
import com.hm.Capstoneproject.model.Movie;
import com.hm.Capstoneproject.model.Multiplex;

import com.hm.Capstoneproject.model.Screen;
import com.hm.Capstoneproject.model.Seat;
import com.hm.Capstoneproject.model.Show;


@Service
public class MultiplexServiceImpl implements MultiplexService {
	
	@Autowired
	MultiplexRepo repo;
	
	@Autowired
	showrepo showrepo;
	
	@Autowired
	Cityrepo cityRepo;
	
	@Autowired
	Movierepo movieRepo;
	
	@Autowired
	Screenrepo screenRepo;
	
	
	
	@Override
	public Multiplex addMultiplex(Multiplex multiplex) {

		for(Screen screen: multiplex.getScreens())
		{
			
//			Show morningShow = new Show();
//			morningShow.setScreen(screen);
//			LocalTime time1 = LocalTime.NOON;
//			morningShow.setStartTime(LocalDateTime.of(LocalDate.now(),time1));
//			morningShow.setStartTime(LocalDateTime.of(2022, 12, 30, 10, 30));
//			shows.add(morningShow);
//			Show afternoonShow = new Show();
//			afternoonShow.setScreen(screen);
//			afternoonShow.setStartTime(LocalDateTime.of(2022, 12, 30, 13, 0));
//			shows.add(afternoonShow);
//			Show eveningShow = new Show();
//			eveningShow.setScreen(screen);
//			eveningShow.setStartTime(LocalDateTime.of(2022, 12, 30, 17, 0));	
//			shows.add(eveningShow);
			List<Seat> seats = new ArrayList<>();
			for(int i=1;i<=screen.getNoOfSeats();i++) {
				Seat seat = new Seat();
				seat.setSeatNo(i);
				seats.add(seat);
			}
			screen.setSeats(seats);
		}
//		multiplex.setShows(shows);
		return repo.save(multiplex);
	}

	@Override
	public Multiplex getMultiplexById(int multiplexId) {
		if(!repo.existsById(multiplexId)) {
			throw new NoSuchElementException("No multiplex with id"+multiplexId);
		}
		return repo.getById(multiplexId);
	}

	@Override
	public List<Multiplex> getAllMultiplexes() {
		if(repo.findAll().isEmpty()) {
			throw new NoSuchElementException("multiplexs Not found");
		}
		return repo.findAll();
	}

	@Override
	public void deleteMultiplex(Multiplex multiplex) {
		if(!repo.existsById(multiplex.getId())) {
			throw new NoSuchElementException("No multiplex with ID"+multiplex.getId());
		}
		multiplex.setScreens(null);
		multiplex.setShows(null);
		repo.delete(multiplex);
	}

	@Override
	public Multiplex findMultiplexByName(String multiplexName) {
		if(repo.existsByName(multiplexName)) {
			throw new NoSuchElementException("No multiplex with name"+multiplexName);
		}
		return repo.findByName(multiplexName);
	}

	@Override
	public List<Multiplex> findMultiplexByCity(City city) {
	if(repo.findByCity(city).isEmpty()) {
		throw new NoSuchElementException("No Multiplex in these"+city);
	}
		return repo.findByCity(city);
	}

//	@Override
//	public List<Result> findMultiplexByCityAndMovie(int cityid, int movieId) {
//
//			List<Multiplex> multiplexs = repo.findByCity(cityRepo.getById(cityid));
//			System.out.println(multiplexs);
//			Map<Multiplex, List<Show>> MultiplexVsShows = new HashMap<>();
//			for(Multiplex multiplex : multiplexs) {
//				System.out.println(multiplex.getId());
//	            List<Show> givenMovieShows = new ArrayList<>();
//	            List<Show> shows = multiplex.getShows();
//	            for(Show show : shows) {
//	            	System.out.println(show.getMovie());
//	            	if(! (show.getMovie()==null)){
//	                if(show.getMovie().getId() == movieId && show.getStartTime().isAfter(LocalDateTime.now())){
//	                    givenMovieShows.add(show);
//	                    System.out.println(show);
//	                }
//	            	}
//	            }
//	            if(!givenMovieShows.isEmpty()) {
////	            	System.out.println(Multiplex);
//	                MultiplexVsShows.put(multiplex, givenMovieShows);
//	            }
//	        }
////		
//			Result result = new Result();
//			List<Result> results=new ArrayList<>();
//			for (Map.Entry<Multiplex,List<Show>> mapElement : MultiplexVsShows.entrySet()) {
//				Multiplex t = mapElement.getKey();
//				List<Show> shows = mapElement.getValue();
//				result = new Result(t, shows);
//				results.add(result);
//				System.out.println(result);
//			}
//			return results;
//	}

	//@Override
//	public List<Result> findMultiplxes(int cityId, int movieId) {		
//		List<Multiplex> multiplexes = repo.findByCity(cityRepo.getById(cityId));
//		if(repo.findByCity(cityRepo.getById(cityId)).isEmpty()) {
//			throw new NoSuchElementException ("NO city with Id"+cityId +"and no movi with"+movieId);
//		}
//		List<Result> results = new ArrayList<>();
//		for(Multiplex multiplex:multiplexes) {
//			List<Show> shows =showrepo.findByScreenInAndMovie(multiplex.getScreens(), movieRepo.getById(movieId));
//			if(!shows.isEmpty()) {
//			Result result = new Result(multiplex,shows);
//			results.add(result);
//			}
//		}
//		if(results.isEmpty()) {
//			throw new NoSuchElementException ("NO Results found");
//		}
//		return results;
//	}
//
	@Override
	public Multiplex getmultiplexbyscreen(int id) {
		Screen screen = screenRepo.findById(id).get();
		return repo.findByScreens(screen);
	}
//	
//	
@Override
	public List<ShowsByDate> findMultiplxes(int cityId, int movieId) {
		List<ShowsByDate> showsWithDate = new ArrayList<>();
		Movie movie = movieRepo.findById(movieId).get();
		List<Multiplex> multiplexes = repo.findByCity(cityRepo.getById(cityId));
		List<LocalDateTime> datetimes = new ArrayList<>();
		for (Multiplex multiplex : multiplexes) {
			datetimes.addAll(
					showrepo.findByScreenInAndMovie2(multiplex.getScreens(), movieRepo.findById(movieId).get()));
		}
		Set<LocalDate> dates = datetimes.stream().map(LocalDateTime::toLocalDate).collect(Collectors.toSet());
		for (LocalDate date : dates) {
			List<Result> results = new ArrayList<>();
			for (Multiplex multiplex : multiplexes) {
				List<Show> shows = showrepo.findByScreenInAndMovieAndStartTimeBetween(multiplex.getScreens(), movie,
						LocalDateTime.of(date, LocalTime.MIN), LocalDateTime.of(date, LocalTime.MAX));
				if (!shows.isEmpty()) {
					results.add(new Result(multiplex, shows));
				}
			}
			showsWithDate.add(new ShowsByDate(date, results));
		}
		return showsWithDate;
	}


	}
	
	

	

