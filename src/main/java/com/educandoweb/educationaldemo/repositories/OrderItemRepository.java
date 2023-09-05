package com.educandoweb.educationaldemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.educationaldemo.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}