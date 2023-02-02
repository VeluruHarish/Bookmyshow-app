package com.hm.Capstoneproject.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hm.Capstoneproject.model.City;

import com.hm.Capstoneproject.model.Show;

@Repository
public interface Cityrepo extends JpaRepository<City, Integer> {
	@Query("from City where id=:cityid")
	public City xyz(City cityid);
}
