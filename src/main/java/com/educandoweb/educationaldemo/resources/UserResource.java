package com.educandoweb.educationaldemo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.educationaldemo.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User user1 = new User(1L, "James", "james@gmail.com", "123456789", "password123");
		return ResponseEntity.ok().body(user1);
	}
}