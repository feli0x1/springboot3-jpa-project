package com.educandoweb.educationaldemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.educationaldemo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}