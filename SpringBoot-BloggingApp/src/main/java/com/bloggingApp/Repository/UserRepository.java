package com.bloggingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloggingApp.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
