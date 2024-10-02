package com.bloggingApp.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloggingApp.DtoLayers.CategoryDto;
import com.bloggingApp.Entities.Category;
import com.bloggingApp.Exception.ResourceNotFoundException;
import com.bloggingApp.Repository.CategoryRepository;
import com.bloggingApp.Service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository category_repository;
	
	@Autowired
	private ModelMapper model_mapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category =this.model_mapper.map(categoryDto, Category.class);
		Category addCategory =this.category_repository.save(category);
		
		return model_mapper.map(addCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, long category_id) {
		Category category = this.category_repository.findById(category_id).
							orElseThrow(()->new ResourceNotFoundException("Category", "ID :", category_id));
		
		category.setCategory_title(categoryDto.getCategory_title());
		category.setCategory_description(categoryDto.getCategory_description());
		
		Category updateCategory =this.category_repository.save(category);
		
		return model_mapper.map(updateCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(long category_id) {
		Category delCategory =this.category_repository.findById(category_id).
		orElseThrow(()->new ResourceNotFoundException("Category", "ID :", category_id));
		
		this.category_repository.delete(delCategory);
	}

	@Override
	public CategoryDto get_singleCategory(long category_id) {
		Category singleCategory = this.category_repository.findById(category_id).
		orElseThrow(()->new ResourceNotFoundException("Category", "ID :", category_id));
		
		return model_mapper.map(singleCategory, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> get_allCategories() {
		List<Category> allCategories = this.category_repository.findAll();
		
		List<CategoryDto> allDtoCategories = allCategories.stream().map(category->this.model_mapper.
											 map(category,CategoryDto.class)).
											 collect(Collectors.toList());
		
		return allDtoCategories;
	}

}
