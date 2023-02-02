package com.hm.airlines.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.airlines.authservice.model.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
