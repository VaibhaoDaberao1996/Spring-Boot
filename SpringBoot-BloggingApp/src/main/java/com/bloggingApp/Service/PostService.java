package com.bloggingApp.Service;

import java.util.List;

import com.bloggingApp.DtoLayers.PostDto;
import com.bloggingApp.Response.PostsResponse;

public interface PostService {

	//create 
	public PostDto createPost(PostDto postDto,long user_id,long category_id);
	
	//update
	public PostDto updatePost(PostDto postDto,long postId);
	
	//delete
	public void deletePost(long postId);
	
	//getSingle
	public PostDto getSinglePost(long postId);
	
	//getAll
	public PostsResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy);
	
	//getAllPostByUser
	public PostsResponse getAllPostByUser (long user_id,Integer pageNumber,Integer pageSize);
	
	//getByCategory
	public PostsResponse getAllPostByCategory(long category_id,Integer pageNumber,Integer pageSize);
	
	//search Post
	public List<PostDto> searchPost(String keyword);
}
