package com.bloggingApp.Service.Impl;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bloggingApp.DtoLayers.PostDto;
import com.bloggingApp.Entities.Category;
import com.bloggingApp.Entities.Post;
import com.bloggingApp.Entities.User;
import com.bloggingApp.Exception.ResourceNotFoundException;
import com.bloggingApp.Repository.CategoryRepository;
import com.bloggingApp.Repository.PostRepository;
import com.bloggingApp.Repository.UserRepository;
import com.bloggingApp.Response.PostsResponse;
import com.bloggingApp.Service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository post_repository;
	
	@Autowired
	private UserRepository user_repository;
	
	@Autowired
	private CategoryRepository category_repository;
	
	@Autowired
	private ModelMapper model_conversion;
	
	
	//Create Post
	@Override
	public PostDto createPost(PostDto postDto, long user_id, long category_id) {
		
		User user =this.user_repository.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User", "user id", user_id));
		Category category = this.category_repository.findById(category_id).orElseThrow(()->new ResourceNotFoundException("Category", "category id", category_id));
		
		Post post = this.model_conversion.map(postDto, Post.class);
		post.setPostImage("default.png");
		post.setPostDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post new_Post = this.post_repository.save(post);
		return this.model_conversion.map(new_Post,PostDto.class);
	}
	
	//update post
	@Override
	public PostDto updatePost(PostDto postDto, long postId) {
		Post post = this.post_repository.findById(postId).orElseThrow(
					()->new ResourceNotFoundException("Post", "post id", postId));
		
		post.setPostTitle(postDto.getPostTitle());
		post.setPostContent(postDto.getPostContent());
		post.setPostImage(postDto.getPostImage());
		
		Post updatedPost = this.post_repository.save(post);
		
		return this.model_conversion.map(updatedPost, PostDto.class);
	}
	
	//delete single post
	@Override
	public void deletePost(long postId) {
		this.post_repository.deleteById(postId);
		
	}
	
	//Get Single Post
	@Override
	public PostDto getSinglePost(long postId) {
		Post post = this.post_repository.findById(postId).orElseThrow(()->
					new ResourceNotFoundException("Post", "post id", postId));
		
		return this.model_conversion.map(post, PostDto.class);
	}
	
	//get all posts
	@Override
	public PostsResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy) {
		
		Pageable page = PageRequest.of(pageNumber, pageSize,Sort.by(sortBy));
		
		Page<Post> pagePost = this.post_repository.findAll(page);
		
		List<Post> allPosts = pagePost.getContent();
		
		List<PostDto> postDtos = allPosts.stream().map(postData->this.model_conversion.map(
								 postData, PostDto.class)).collect(Collectors.toList());
		
		PostsResponse posts = new PostsResponse();
		
		posts.setContent(postDtos);
		posts.setPageNumber(pageNumber);
		posts.setPageSize(pageSize);
		posts.setTotalElement(pagePost.getTotalElements());
		posts.setLastPage(pagePost.isLast());
		return posts;
	}
	
	//Get posts by User
	@Override
	public PostsResponse getAllPostByUser(long user_id,Integer pageNumber,Integer pageSize) {
	User user =	this.user_repository.findById(user_id).orElseThrow(
				()->new ResourceNotFoundException("Post", "user id ", user_id));
		
		Pageable page = PageRequest.of(pageNumber,pageSize);
		
		Page<Post> pagePosts = this.post_repository.findByUser(user, page);
		
		List<Post> posts = pagePosts.getContent();		
		
		List<PostDto>postDtos = posts.stream().map(postData->this.model_conversion.map(
						   postData,PostDto.class)).collect(Collectors.toList());
		
		PostsResponse userPosts= new PostsResponse();
		
		userPosts.setContent(postDtos);
		userPosts.setPageNumber(pageNumber);
		userPosts.setPageSize(pageSize);
		userPosts.setTotalElement(pagePosts.getTotalElements());
		userPosts.setLastPage(pagePosts.isLast());
		
		return userPosts;
	}
	
	//Get posts by category
	@Override
	public PostsResponse getAllPostByCategory(long category_id,Integer pageNumber,Integer pageSize) {
		Category category = this.category_repository.findById(category_id).orElseThrow(
							()->new ResourceNotFoundException("Post", "category_id", category_id));
		
		Pageable page = PageRequest.of(pageNumber, pageSize);
		
		Page<Post> pagePosts = this.post_repository.findByCategory(category,page);
		
		List<Post> posts = pagePosts.getContent();
		
		List<PostDto> postDtos = posts.stream().map(postData->this.model_conversion.map(
						   postData,PostDto.class)).collect(Collectors.toList());
		
		PostsResponse catPosts = new PostsResponse();
		
		catPosts.setContent(postDtos);
		catPosts.setPageNumber(pageNumber);
		catPosts.setPageSize(pageSize);
		catPosts.setTotalElement(pagePosts.getTotalElements());
		catPosts.setLastPage(pagePosts.isLast());
		
		return catPosts;
	}

	//Search posts
	@Override
	public List<PostDto> searchPost(String keyword) {
	List<Post> posts = this.post_repository.findByPostTitleContaining(keyword);
		
	List<PostDto> postDtos = posts.stream().map(post->this.model_conversion
				  .map(post, PostDto.class)).collect(Collectors.toList());
	
	return postDtos;
	}

}
