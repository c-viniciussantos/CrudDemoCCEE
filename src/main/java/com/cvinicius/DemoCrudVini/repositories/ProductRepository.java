package com.cvinicius.DemoCrudVini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cvinicius.DemoCrudVini.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
