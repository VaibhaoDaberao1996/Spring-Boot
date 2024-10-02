package com.bloggingApp.Service;

import java.util.List;

import com.bloggingApp.DtoLayers.CategoryDto;

public interface CategoryService {

	//create
	 CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto, long category_id);
	
	//delete
	void deleteCategory(long category_id);
	
	//getSingle
	CategoryDto get_singleCategory(long category_id);
	
	//getAll
	List<CategoryDto> get_allCategories();
}
