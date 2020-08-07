package com.cvinicius.DemoCrudVini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cvinicius.DemoCrudVini.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
