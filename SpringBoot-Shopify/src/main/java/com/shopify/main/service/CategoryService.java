package com.shopify.main.service;

import java.util.List;

import com.shopify.main.Dto.CategoryDto;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto category);
	
	CategoryDto updateCategory(CategoryDto category,int catId);
	
	void deleteCategory(int catId);
	
	CategoryDto getSingleCategory(int catId);
	
	List<CategoryDto> getAllCategory();
}
