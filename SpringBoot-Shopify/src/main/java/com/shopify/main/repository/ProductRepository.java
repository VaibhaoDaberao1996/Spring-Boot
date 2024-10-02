package com.shopify.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopify.main.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
