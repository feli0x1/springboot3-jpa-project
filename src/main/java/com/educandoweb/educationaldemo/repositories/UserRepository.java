package com.educandoweb.educationaldemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.educationaldemo.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}