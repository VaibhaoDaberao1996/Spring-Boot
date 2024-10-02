package com.shopify.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopify.main.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
