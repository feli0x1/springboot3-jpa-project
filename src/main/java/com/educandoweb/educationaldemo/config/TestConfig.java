package com.educandoweb.educationaldemo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.educationaldemo.entities.Order;
import com.educandoweb.educationaldemo.entities.User;
import com.educandoweb.educationaldemo.entities.enums.OrderStatus;
import com.educandoweb.educationaldemo.repositories.OrderRepository;
import com.educandoweb.educationaldemo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "William", "william@gmail.com", "321456789", "password1");
		User user2 = new User(null, "Charlotte", "charlotte@gmail.com", "437582943", "password2");
		
		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), 
				OrderStatus.WAITING_PAYMENT, user1);
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), 
				OrderStatus.PAID, user2);
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), 
				OrderStatus.SHIPPED, user1); 
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
	}
	
}