package com.hm.Capstoneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.Capstoneproject.Exception.NoSuchElementException;
import com.hm.Capstoneproject.Repository.Cityrepo;
import com.hm.Capstoneproject.model.City;
@Service
public class CityServiceIMPL implements CityService {

	@Autowired
	Cityrepo repo;
	@Override
	public void addcity(City city) {
		repo.save(city);
		
	}

	@Override
	public List<City> getallcity() {
		if(repo.findAll().isEmpty()) {
			throw new  NoSuchElementException("No Citys Available");
		}
		return repo.findAll();
	}

}
