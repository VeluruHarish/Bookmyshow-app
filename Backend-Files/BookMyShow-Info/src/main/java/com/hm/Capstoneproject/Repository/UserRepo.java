package com.hm.Capstoneproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.Capstoneproject.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
