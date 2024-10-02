package com.bloggingApp.Entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long postID;
	
	@Column(name = "title",length = 100)
	private String postTitle;
	
	@Column(name = "content",length = 1000)
	private String postContent;
	
	@Column(name = "date")
	private Date postDate;
	
	@Column(name = "image")
	private String postImage;
	
	@ManyToOne
	@JoinColumn(name="User_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="Category_id")
	private Category category;
	
	@OneToMany(mappedBy ="post",cascade = CascadeType.ALL)
	private Set<Comment> comments = new HashSet<Comment>(); 

	
	
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(long postID, String postTitle, String postContent, Date postDate, String postImage, User user,
			Category category) {
		super();
		this.postID = postID;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postDate = postDate;
		this.postImage = postImage;
		this.user = user;
		this.category = category;
	}

	public long getPostID() {
		return postID;
	}

	public void setPostID(long postID) {
		this.postID = postID;
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

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getPostImage() {
		return postImage;
	}

	public void setPostImage(String postImage) {
		this.postImage = postImage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	
	
	
}