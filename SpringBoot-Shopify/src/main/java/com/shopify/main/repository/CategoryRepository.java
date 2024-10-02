package com.shopify.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopify.main.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
