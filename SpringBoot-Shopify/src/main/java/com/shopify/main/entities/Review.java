package com.shopify.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reviews")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long revId;
	
	private String content;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Product product;

	public Review() {
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
	
	
}
