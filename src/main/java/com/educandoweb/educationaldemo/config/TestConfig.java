package com.educandoweb.educationaldemo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.educationaldemo.entities.User;
import com.educandoweb.educationaldemo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "William", "william@gmail.com", "321456789", "password1");
		User user2 = new User(null, "Charlotte", "charlotte@gmail.com", "437582943", "password2");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
	}
	
}