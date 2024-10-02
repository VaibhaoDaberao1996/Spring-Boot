package com.bloggingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloggingApp.Entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
