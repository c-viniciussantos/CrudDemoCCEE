package com.cvinicius.DemoCrudVini.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvinicius.DemoCrudVini.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Vinicius", "carlos.vinicius@ccee.org.br", "11912345678");
		return ResponseEntity.ok().body(u);
	}
}
