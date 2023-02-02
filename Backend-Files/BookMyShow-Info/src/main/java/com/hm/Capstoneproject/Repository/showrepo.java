package com.hm.Capstoneproject.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hm.Capstoneproject.dto.DateShowDetails;
import com.hm.Capstoneproject.model.Movie;
import com.hm.Capstoneproject.model.Screen;
import com.hm.Capstoneproject.model.Show;
@Component
public interface showrepo extends JpaRepository<Show, Integer> {
	

//	public List<Show> findByScreenInAndMovieAndStartTimeBetween(List<Screen> screens,Movie movie,LocalDateTime time1,LocalDateTime time2 );
	
	public List<Show> findByScreenInAndMovie(List<Screen> screens,Movie movie);
	
//	public List<Show> findByScreenInAndMovieAndShowDate(List<Screen> screens,Movie movie,LocalDate date);

	
//	public List<Show> findByScreenInAndMovieAndStartTimeEquals(List<Screen> screens,Movie movie,LocalDate time1);
	
	public List<Show> findByScreen(Screen screen);
	
//	@Query(value="select showDate from Show where screen in :screens and movie = :movie")
//	public List<LocalDate> getAllShowDateByScreenInAndMovie(List<Screen> screens,Movie movie);
	
//	@Query(value="select showDate,id from Show where screen in :screens and movie = :movie group by showDate")
//	public List<DateShowDetails> getAllShowss(List<Screen> screens,Movie movie);
	
	public List<Show> findByMovie(Movie movie);
	
//	public List<Show> findByScreenInAndMovie(List<Screen> screens,Movie movie);
//    public List<Show> findByScreen(Screen screen);
    @Query(value="select startTime from Show where screen in :screens and movie = :movie")
    public List<LocalDateTime> findByScreenInAndMovie2(List<Screen> screens,Movie movie);
    public List<Show> findByScreenInAndMovieAndStartTimeBetween(List<Screen> screens,Movie movie,LocalDateTime time1,LocalDateTime time2);

	
	
	
}
