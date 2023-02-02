package com.hm.Capstoneproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hm.Capstoneproject.model.Multiplex;
import com.hm.Capstoneproject.model.Screen;
@Component
public interface Screenrepo extends JpaRepository<Screen, Integer> {
	
//	public List<Screen> findByMultiplexIn(List<Multiplex> multiplexes);

}
