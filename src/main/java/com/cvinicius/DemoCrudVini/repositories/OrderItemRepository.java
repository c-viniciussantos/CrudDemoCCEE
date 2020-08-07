package com.cvinicius.DemoCrudVini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cvinicius.DemoCrudVini.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
