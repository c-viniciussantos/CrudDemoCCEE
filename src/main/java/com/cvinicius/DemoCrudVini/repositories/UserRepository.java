package com.cvinicius.DemoCrudVini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cvinicius.DemoCrudVini.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
