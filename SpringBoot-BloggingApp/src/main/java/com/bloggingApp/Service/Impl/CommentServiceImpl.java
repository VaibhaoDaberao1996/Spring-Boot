package com.bloggingApp.Service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloggingApp.DtoLayers.CommentDto;
import com.bloggingApp.Entities.Comment;
import com.bloggingApp.Entities.Post;
import com.bloggingApp.Entities.User;
import com.bloggingApp.Exception.ResourceNotFoundException;
import com.bloggingApp.Repository.CommentRepository;
import com.bloggingApp.Repository.PostRepository;
import com.bloggingApp.Repository.UserRepository;
import com.bloggingApp.Service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepository comment_repository;
	
	@Autowired
	private ModelMapper model_conversion;

	@Autowired
	private UserRepository user_repository;
	
	@Autowired
	private PostRepository post_repository;
	
	
	@Override
	public CommentDto createComments(CommentDto comment,long user_id,long postId) {
		
		User user = this.user_repository.findById(user_id).orElseThrow(
				()->new ResourceNotFoundException("User", "user id ", user_id));
		
		Post post = this.post_repository.findById(postId).orElseThrow(
				()->new ResourceNotFoundException("Post", "post id ", postId));		
				
				
		Comment createComment =this.model_conversion.map(comment, Comment.class);
		
		createComment.setUser(user);
		createComment.setPost(post);
		
		Comment saveComment = this.comment_repository.save(createComment);
		
		return model_conversion.map(saveComment, CommentDto.class);
	}

	@Override
	public void deleteComment(long id) {
		
		Comment comment =this.comment_repository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("comment", "comment Id ", id));
		
		this.comment_repository.delete(comment);
	}
}
