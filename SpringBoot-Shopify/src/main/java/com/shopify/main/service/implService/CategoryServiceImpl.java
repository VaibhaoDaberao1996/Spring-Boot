package com.shopify.main.service.implService;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopify.main.Dto.CategoryDto;
import com.shopify.main.Exception.ResourceNotFoundException;
import com.shopify.main.entities.Category;
import com.shopify.main.repository.CategoryRepository;
import com.shopify.main.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository category_repository;
	
	@Autowired
	private ModelMapper model_conversion;
	
	@Override
	public CategoryDto createCategory(CategoryDto category) {
		//Category createCategory = this.model_conversion.map(category, Category.class);
		
		Category saveCategory = this.category_repository.save(
				this.model_conversion.map(category, Category.class));
		
		return model_conversion.map(saveCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto category, int catId) {
		Category findCategory = this.category_repository.findById(catId).orElseThrow(
				()->new ResourceNotFoundException("Category", "category Id", catId));
		
		findCategory.setName(category.getName());
		findCategory.setDescription(category.getDescription());
		
		Category saveCategory = this.category_repository.save(findCategory);
		
		return model_conversion.map(saveCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(int catId) {
		Category category = this.category_repository.findById(catId).orElseThrow(
				()->new ResourceNotFoundException("Category","category Id", catId));
		
		this.category_repository.delete(category);
	}
	
	@Override
	public CategoryDto getSingleCategory(int catId) {
		Category category = this.category_repository.findById(catId).orElseThrow(
				()->new ResourceNotFoundException("Category","category Id", catId));
		
		return model_conversion.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = this.category_repository.findAll();
		
		List<CategoryDto> categoriesDto = categories
		.stream()
		.map(category->this.model_conversion.map(category, CategoryDto.class))
		.toList();
		
		return categoriesDto;
	}


}
