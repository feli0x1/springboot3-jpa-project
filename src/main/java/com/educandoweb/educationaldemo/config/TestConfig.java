package com.educandoweb.educationaldemo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.educationaldemo.entities.Category;
import com.educandoweb.educationaldemo.entities.Order;
import com.educandoweb.educationaldemo.entities.Product;
import com.educandoweb.educationaldemo.entities.User;
import com.educandoweb.educationaldemo.entities.enums.OrderStatus;
import com.educandoweb.educationaldemo.repositories.CategoryRepository;
import com.educandoweb.educationaldemo.repositories.OrderRepository;
import com.educandoweb.educationaldemo.repositories.ProductRepository;
import com.educandoweb.educationaldemo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", 
				"Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", 
				"Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", 
				"Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", 
				"Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", 
				"Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
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