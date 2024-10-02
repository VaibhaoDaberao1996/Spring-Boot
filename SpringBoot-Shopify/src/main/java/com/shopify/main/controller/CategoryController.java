package com.shopify.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopify.main.Dto.CategoryDto;
import com.shopify.main.response.ApiResponse;
import com.shopify.main.service.CategoryService;

@RestController
@RequestMapping("/shopify/apis")
public class CategoryController {
	
	@Autowired
	private CategoryService category_service;
	
	//Post
	@PostMapping("/categories")
	public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto category){
		
		CategoryDto addCategory = this.category_service.createCategory(category);
		
		return new ResponseEntity<CategoryDto>(addCategory,HttpStatus.CREATED);
	}
	
	//Put
	@PutMapping("/categories/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto category,
												   @PathVariable int catId){
		
		CategoryDto updateCategory = this.category_service.updateCategory(category, catId);
		
		return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);
	}
	
	//Delete
	@DeleteMapping("/categories/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable int catId){
		
		 this.category_service.deleteCategory(catId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category id with "+catId+" deleted Succesfully", true),
												HttpStatus.OK);
	}
	
	//Get
	@GetMapping("/categories/{catId}")
	public ResponseEntity<CategoryDto> showSingleCategory(@PathVariable int catId){
		
		CategoryDto showCategory = this.category_service.getSingleCategory(catId);
		
		return new ResponseEntity<CategoryDto>(showCategory,HttpStatus.FOUND);
	}
	
	//Get All
	@GetMapping("/categories")
	public ResponseEntity<List<CategoryDto>> showAllCategory(){
		
		List<CategoryDto> showAllCategory = this.category_service.getAllCategory();
		
		return new ResponseEntity<List<CategoryDto>>(showAllCategory,HttpStatus.FOUND);
	}

}
