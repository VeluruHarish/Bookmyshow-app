package com.hm.Capstoneproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hm.Capstoneproject.dto.Result;
import com.hm.Capstoneproject.dto.ShowsByDate;
import com.hm.Capstoneproject.model.City;
import com.hm.Capstoneproject.model.Movie;
import com.hm.Capstoneproject.model.Multiplex;


public interface MultiplexService {
	
	public Multiplex addMultiplex(Multiplex multiplex);
	
	public Multiplex getMultiplexById(int multiplexId);
	
	public List<Multiplex> getAllMultiplexes();
	
	public void deleteMultiplex(Multiplex multiplex);
	
	public Multiplex findMultiplexByName(String multiplexName);
	
	public List<Multiplex> findMultiplexByCity(City city);
	
//	public List<Result> findMultiplexByCityAndMovie(int CityId,int movieId );
	
	public List<ShowsByDate> findMultiplxes(int CityId,int movieId );
	
	public Multiplex getmultiplexbyscreen(int id);

	
	

}
