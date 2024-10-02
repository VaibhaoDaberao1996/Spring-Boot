package com.bloggingApp.DtoLayers;

public class CategoryDto {

	private long category_id;
	
	private String category_title;
	
	private String category_description;

	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

	public String getCategory_title() {
		return category_title;
	}

	public void setCategory_title(String category_title) {
		this.category_title = category_title;
	}

	public String getCategory_description() {
		return category_description;
	}

	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}
	
	
}
