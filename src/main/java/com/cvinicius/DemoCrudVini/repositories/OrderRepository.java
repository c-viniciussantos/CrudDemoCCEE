package com.cvinicius.DemoCrudVini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cvinicius.DemoCrudVini.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
