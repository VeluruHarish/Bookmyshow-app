package com.hm.Capstoneproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hm.Capstoneproject.model.City;
import com.hm.Capstoneproject.model.Multiplex;
import com.hm.Capstoneproject.model.Screen;
import com.hm.Capstoneproject.model.Show;
@Component
public interface MultiplexRepo extends JpaRepository<Multiplex, Integer> {
	
	public List<Multiplex> findByCity(City city);
	
	public Multiplex findByName(String name);
	public boolean existsByName(String multiplexname);
    public Multiplex findByScreens(Screen screen);

}
