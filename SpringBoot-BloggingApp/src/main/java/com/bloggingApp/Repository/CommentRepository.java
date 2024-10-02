package com.bloggingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloggingApp.Entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
