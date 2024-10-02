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

import com.shopify.main.Dto.ProductDto;
import com.shopify.main.response.ApiResponse;
import com.shopify.main.service.ProductService;

@RestController
@RequestMapping("/shopify/apis")
public class ProductController {
	
	@Autowired
	private ProductService product_service;
	
	//post
	@PostMapping("/products")
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto product){
		
		ProductDto createProduct = this.product_service.createProduct(product);
		
		return new ResponseEntity<ProductDto>(createProduct,HttpStatus.CREATED);
	}
	
	//put
	@PutMapping("/products/{productId}")
	public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto product,
													@PathVariable long productId){
		
		ProductDto updateProduct = this.product_service.updateProduct(productId, product);
		
		return new ResponseEntity<ProductDto>(updateProduct,HttpStatus.OK);
	}
	
	//get
	@GetMapping("/products/{productId}")
	public ResponseEntity<ProductDto> showProduct(@PathVariable long productId){
		
	  	ProductDto singleProduct = this.product_service.getSingleProduct(productId);
	  	
	  	return new ResponseEntity<ProductDto>(singleProduct,HttpStatus.FOUND);
	}
	
	//delete
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable long productId){
		
	  	 this.product_service.deleteProduct(productId);
	  	
	  	return new ResponseEntity<ApiResponse>(new ApiResponse("The product id with "+productId+" is deleted successfully", true),
	  											HttpStatus.OK);
	}
	
	//get all
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> showAllProducts(){
		
	  	List<ProductDto> allProduct = this.product_service.getAllProduct();
	  	
	  	return new ResponseEntity<List<ProductDto>>(allProduct,HttpStatus.FOUND);
	}
}
