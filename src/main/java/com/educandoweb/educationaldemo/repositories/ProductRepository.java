package com.educandoweb.educationaldemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.educationaldemo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}