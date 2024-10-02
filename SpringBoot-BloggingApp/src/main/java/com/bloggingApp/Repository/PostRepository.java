package com.bloggingApp.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bloggingApp.Entities.Category;
import com.bloggingApp.Entities.Post;
import com.bloggingApp.Entities.User;

public interface PostRepository extends JpaRepository<Post, Long> {

	Page<Post> findByUser(User user,Pageable page);
	
	Page<Post> findByCategory(Category category,Pageable page);
	
	List<Post> findByPostTitleContaining(String postTitle);
}
