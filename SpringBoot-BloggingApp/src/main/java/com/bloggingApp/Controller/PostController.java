package com.bloggingApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bloggingApp.DtoLayers.PostDto;
import com.bloggingApp.Response.ApiResponse;
import com.bloggingApp.Response.PostsResponse;
import com.bloggingApp.Service.PostService;
import com.bloggingApp.Utils.AppConstants;

@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired
	private PostService post_service;

 
	//Add post
	@PostMapping("users/{user_id}/categories/{category_id}/posts")
	public ResponseEntity<PostDto> create_Post(
					@RequestBody PostDto postDto,
					@PathVariable long user_id,
					@PathVariable long category_id){
	PostDto createPostDto =	this.post_service.createPost(postDto, user_id, category_id);
		
		return new ResponseEntity<PostDto>(createPostDto,HttpStatus.CREATED);
	}
	
	
	//Update post
	@PutMapping("/posts/{post_id}")
	public ResponseEntity<PostDto> update_Post(@RequestBody PostDto postDto, @PathVariable long post_id){
		PostDto post = this.post_service.updatePost(postDto, post_id);
		
		return new ResponseEntity<PostDto>(post,HttpStatus.OK);
	}
	
	
	//Delete post
	@DeleteMapping("/posts/{post_id}")
	public ResponseEntity<ApiResponse> delete_Post(@PathVariable long post_id){
		this.post_service.deletePost(post_id);
		
		return new ResponseEntity<ApiResponse>(
			   new ApiResponse("Post with id : "+post_id+" deleted successfully",true),HttpStatus.OK);
	}
	
	//Get single post
	@GetMapping("posts/{post_id}")
	public ResponseEntity<PostDto> show_Singlepost(@PathVariable long post_id){
		PostDto post = this.post_service.getSinglePost(post_id);
		
		return new ResponseEntity<PostDto>(post,HttpStatus.FOUND);
	}
	
	
	//Get all posts
	@GetMapping("/posts")
	public ResponseEntity<PostsResponse> show_Allposts(
		  @RequestParam(value="pageNumber",defaultValue=AppConstants.PAGE_NUMBER,required = false)Integer pageNumber,
	      @RequestParam(value="pageSize",defaultValue=AppConstants.PAGE_SIZE,required = false ) Integer pageSize,
	      @RequestParam(value="sortBy",defaultValue="postTitle",required = false)String sortBy ){
		PostsResponse posts = this.post_service.getAllPost(pageNumber,pageSize,sortBy);
		
		return new ResponseEntity<PostsResponse>(posts,HttpStatus.FOUND);
	}
	
	
	//Get Posts by User
	@GetMapping("users/{user_id}/posts")
	public ResponseEntity<PostsResponse> showPosts_ByUser(
		  @PathVariable long user_id,
		  @RequestParam(value = "pageNumber",defaultValue=AppConstants.PAGE_NUMBER,required = false )Integer pageNumber,
		  @RequestParam(value = "pageSize",defaultValue=AppConstants.PAGE_SIZE,required = false )Integer pageSize){
	
		PostsResponse postsByUser =	this.post_service.getAllPostByUser(user_id,pageNumber,pageSize);
	
	return new ResponseEntity<PostsResponse>(postsByUser,HttpStatus.FOUND);
	}
	
	
	//Get posts by category
	@GetMapping("categories/{category_id}/posts")
	public ResponseEntity<PostsResponse> showPosts_ByCategory(
		  @PathVariable long category_id,
		  @RequestParam(value = "pageNumber",defaultValue=AppConstants.PAGE_NUMBER,required = false)Integer pageNumber,
		  @RequestParam(value = "pageSize",defaultValue=AppConstants.PAGE_SIZE,required = false)Integer pageSize){
		
		PostsResponse postsByCategory = this.post_service.getAllPostByCategory(category_id,pageNumber,pageSize);
		
		return new ResponseEntity<PostsResponse>(postsByCategory,HttpStatus.FOUND);
	}

	//search Post
	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPost_byTitle(@PathVariable String keyword){
		
		List<PostDto> posts= this.post_service.searchPost(keyword);
		
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.FOUND);
	}
}
