package com.bloggingApp.DtoLayers;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PostDto {
	
	private long postId;

	private String postTitle;
	
	private String postContent;
	
	private String postImage;
	
	private Date postDate;
	
	private UserDto user;
	
	private CategoryDto category;
	
	private Set<CommentDto> comments = new HashSet<>();

	
	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostDto(String postTitle, String postContent, String postImage, Date postDate, UserDto user,
			CategoryDto category) {
		super();
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postImage = postImage;
		this.postDate = postDate;
		this.user = user;
		this.category = category;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostImage() {
		return postImage;
	}

	public void setPostImage(String postImage) {
		this.postImage = postImage;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public Set<CommentDto> getComments() {
		return comments;
	}

	public void setComments(Set<CommentDto> comments) {
		this.comments = comments;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}
  
	
}
