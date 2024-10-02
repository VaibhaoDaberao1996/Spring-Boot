package com.shopify.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopify.main.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
