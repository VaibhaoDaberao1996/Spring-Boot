package com.shopify.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopify.main.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
