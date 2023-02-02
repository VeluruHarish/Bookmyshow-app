package com.hm.Capstoneproject.Controller;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hm.Capstoneproject.Repository.Cityrepo;
import com.hm.Capstoneproject.Repository.Movierepo;
import com.hm.Capstoneproject.Repository.Screenrepo;
import com.hm.Capstoneproject.Repository.UserRepo;
import com.hm.Capstoneproject.Repository.MultiplexRepo;

import com.hm.Capstoneproject.Repository.showrepo;
import com.hm.Capstoneproject.dto.AvailableSeats;
import com.hm.Capstoneproject.dto.ShowsByDate;
import com.hm.Capstoneproject.model.City;
import com.hm.Capstoneproject.model.Genre;

import com.hm.Capstoneproject.model.Movie;
import com.hm.Capstoneproject.model.Result;
import com.hm.Capstoneproject.model.Screen;
import com.hm.Capstoneproject.model.Seat;
import com.hm.Capstoneproject.model.Show;
import com.hm.Capstoneproject.model.User;
import com.hm.Capstoneproject.service.CityService;
import com.hm.Capstoneproject.service.MovieService;
import com.hm.Capstoneproject.service.MultiplexService;
import com.hm.Capstoneproject.service.ShowService;
import com.netflix.discovery.converters.Auto;
import com.hm.Capstoneproject.model.Multiplex;


@RestController
//@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/info")
public class MainController {

	@Autowired
	CityService cityservice;
	@Autowired
	Movierepo MOVIEREPO;
	@Autowired
	MovieService movieservice;
	@Autowired
	Screenrepo SCREENREPO;
	@Autowired
	ShowService showservice;
	@Autowired
	showrepo SHOWREPO;
	@Autowired
	MultiplexRepo THEATREREPO;
	
	@Autowired
	MultiplexService multiplexService;
	
	@Autowired
	UserRepo userRepo;
	
	@Bean
	public String getString() {
		return new String();
	}
	
	@PostMapping("/user")
	public void addUser(@RequestBody User user) {
		System.out.println(user);
		userRepo.save(user);
	}
	@GetMapping("/user")
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	@PostMapping("/city")
	public void addcity(@RequestBody City city) {
		cityservice.addcity(city);
	}
	@GetMapping("/city")
	public List<City> getallcity(){
		return cityservice.getallcity();
	}
	@PostMapping("/movie")
	public Movie addmovie(@RequestBody Movie movie) {
		System.out.println(movie);
		return movieservice.saveMovie(movie);
	}
	
	@PutMapping("/updatemovie")
	public Movie updateMovie(@RequestBody Movie movie){
		return movieservice.saveMovie(movie);
	}
	
	@GetMapping("movie/{movieid}")
	public Movie getMovieById(@PathVariable int movieid) {
		return movieservice.getMovieById(movieid);
	}
	@PutMapping("movie/delete")
     public void deletemovie(@RequestBody Movie movie) {
		movieservice.deleteMovie(movie);
	}
	@GetMapping("/movie/")
	public List<Movie> getMovieByGenre(@RequestParam(name="genre",required = false) List<Genre> genres) {
		List<Genre> list = new ArrayList<>();
		if(genres==null || genres.isEmpty()) {
			return movieservice.getAllMovies();
		}
		else {
			list.addAll(genres);
		}
		return movieservice.getMoviesByGenre(genres);
	}
	
	@PostMapping("/screen")
	public void addscreen(@RequestBody Screen screen) {
		SCREENREPO.save(screen);
	}
	@GetMapping("/screen")
	public List<Screen> getallscreen(){
		return SCREENREPO.findAll();
	}
	
	@GetMapping("/multiplex/screen/{id}")
		public Multiplex getmultiplexbyscreen(@PathVariable int id) {
			return multiplexService.getmultiplexbyscreen(id);
		}
	
	@PostMapping("/show")
	public Show addshow(@RequestBody Show show) {
		return showservice.addshow(show);
	}
	
	@GetMapping("/show")
	public List<Show> getshows(){
		return showservice.allShows();
	}
	
	@DeleteMapping("/show")
	public void deleteshows(@RequestBody Show show){
	showservice.deleteshow(show);
	}
	
	@GetMapping("/show/{id}")
	public Show getshows(@PathVariable int id){
		return showservice.getbyId(id);
	}
	
	@PostMapping("/show/{id}")
	public Show editShows(@RequestBody Show show){
		return showservice.updateShow(show);
	}
	@PostMapping("/showDetails/{id}")
	public AvailableSeats Detailsofshow(@PathVariable int id) {
		return showservice.detailsofshow(id);
	}
	
	@PostMapping("/multiplex")
	public void addshowseat(@RequestBody Multiplex multiplex) {
		multiplexService.addMultiplex(multiplex);
	}
	
	@GetMapping("/multiplex")
	public List<Multiplex> getTheatre(){
		return multiplexService.getAllMultiplexes();
	}
	
	@GetMapping("multiplex/{id}")
	public Multiplex getMultiplexById(@PathVariable int id) {
		return multiplexService.getMultiplexById(id);
	}
	
	@PostMapping("/multiplexShows/{cityId}/{movieId}")
	public List<ShowsByDate> getsomething(@PathVariable int cityId,@PathVariable int movieId){
		System.out.println(movieId+""+cityId);
		return multiplexService.findMultiplxes(cityId, movieId);		
	}
	@PutMapping("multiplex/delete")
	public void deleteMultiplex(@RequestBody Multiplex multiplex) {
		System.out.println(multiplex);
		 multiplexService.deleteMultiplex(multiplex);
	}
}
	
	
		
		
	


//List<Multiplex> theatres = THEATREREPO.findByCity(CITYREPO.getById(1));
//List<Multiplex> list2;
////System.out.println(theatres);
//Map<Multiplex, List<Show>> theatreVsShows = new HashMap<>();
//for(Multiplex theatre : theatres) {
//
//    List<Show> givenMovieShows = new ArrayList<>();
//    List<Show> shows = theatre.getShows();
////    System.out.println(shows);
//
//    for(Show show : shows) {
//        if(show.getMovie().getId() == 101) {
//            givenMovieShows.add(show);
//        }
//    }
//    if(!givenMovieShows.isEmpty()) {
////    	System.out.println(theatre);
//        theatreVsShows.put(theatre, givenMovieShows);
//    }
//}
//
////List<List<Show>> list3 = new ArrayList<>(theatreVsShows.values());
////List<Theatre> list4 = new ArrayList<>(theatreVsShows.keySet());
////System.out.println(" "+list3);
//Result result = new Result();
//List<Result> resultList;
//for (Map.Entry<Multiplex,List<Show>> mapElement : theatreVsShows.entrySet()) {
//	Multiplex t = mapElement.getKey();
////	Theatre t2 = new Theatre();
//	List<Show> shows = mapElement.getValue();
//	result = new Result(t, shows);
//	System.out.println(result);
//}
//return result;
//}
//	@GetMapping("/city/{cityid}")
//	public List<Theatre> getAllshow(@PathVariable int cityid){
//		return CITYREPO.getById(cityid).getTheatres();
//	}
	
	


