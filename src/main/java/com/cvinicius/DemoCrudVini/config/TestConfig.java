package com.cvinicius.DemoCrudVini.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cvinicius.DemoCrudVini.entities.User;
import com.cvinicius.DemoCrudVini.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private UserRepository userRepository;
	
	public void run(String... args) throws Exception{
		User u1 = new User(null, "Carlos vinicius", "c.viniciussantos@outlook.com", "1191234567");
		User u2 = new User(null, "Pessoa qualquer", "emailqualquer@email.com", "1391234567");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
}
