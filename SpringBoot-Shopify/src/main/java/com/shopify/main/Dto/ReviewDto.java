package com.shopify.main.Dto;

import com.shopify.main.entities.Product;
import com.shopify.main.entities.User;

public class ReviewDto {

	private long revId;
	
	private String content;
	
	private User user;
	
	private Product product;

	public ReviewDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getRevId() {
		return revId;
	}

	public void setRevId(long revId) {
		this.revId = revId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
