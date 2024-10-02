package com.shopify.main.Dto;

public class CategoryDto {

	private int catId;
	
	private String name;
	
	private String description;

	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
