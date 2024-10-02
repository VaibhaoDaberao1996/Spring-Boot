package com.bloggingApp.Controller;

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

import com.bloggingApp.DtoLayers.CategoryDto;
import com.bloggingApp.Response.ApiResponse;
import com.bloggingApp.Service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	private CategoryService category_service;
	
	
	//addCategory
	@PostMapping("/categories")
	public ResponseEntity<CategoryDto> add_Category(@RequestBody CategoryDto categoryDto){
		CategoryDto addCategory = this.category_service.createCategory(categoryDto);
		
		return new ResponseEntity<CategoryDto>(addCategory,HttpStatus.CREATED);
	}
	
	
	//updateCategory
	@PutMapping("/categories/{category_id}")
	public ResponseEntity<CategoryDto> update_Category(@RequestBody CategoryDto categoryDto,@PathVariable long category_id){
		CategoryDto updCategory = this.category_service.updateCategory(categoryDto, category_id);
		
		return new ResponseEntity<CategoryDto>(updCategory,HttpStatus.OK);
	}
	
	
	//deleteCategory
	@DeleteMapping("/categories/{category_id}")
	public ResponseEntity<ApiResponse> delete_Category(@PathVariable long category_id){
		 this.category_service.deleteCategory(category_id);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category is Deleted Succesfully",true),HttpStatus.OK);
	}
	
	
	//show Single Category
	@GetMapping("/categories/{category_id}")
	public ResponseEntity<CategoryDto> show_singleCategory(@PathVariable long category_id){
		CategoryDto showCategory = this.category_service.get_singleCategory(category_id);
		
		return new ResponseEntity<CategoryDto>(showCategory,HttpStatus.OK);
	}
	
	
	//show all categories
	@GetMapping("/categories")
	public ResponseEntity<List<CategoryDto>> show_allCategory(){
		List<CategoryDto> showCategories = this.category_service.get_allCategories();
		
		return new ResponseEntity<List<CategoryDto>>(showCategories,HttpStatus.OK);
	}
}
