package com.shopify.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopify.main.Dto.ReviewDto;
import com.shopify.main.response.ApiResponse;
import com.shopify.main.service.ReviewService;

@RestController
@RequestMapping("/shopify/apis")
public class ReviewController {
	
	@Autowired
	private ReviewService review_service;
	
	//post
	@PostMapping("/reviews")
	public ResponseEntity<ReviewDto> addReview(@RequestBody ReviewDto review){
		
		ReviewDto addReview = this.review_service.createReview(review);
		
		return new ResponseEntity<ReviewDto>(addReview,HttpStatus.CREATED);
	}
	
	//Get
	@GetMapping("/reviews/{revId}")
	public ResponseEntity<ReviewDto> getSingleReview(@PathVariable long revId){
		
		ReviewDto showReview = this.review_service.getSingleReview(revId);
		
		return new ResponseEntity<ReviewDto>(showReview,HttpStatus.FOUND);
	}
	
	//delete
	@DeleteMapping("/reviews/{revId}")
	public ResponseEntity<ApiResponse> deleteReview(@PathVariable long revId){
		
		this.review_service.deleteReview(revId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Review with id "+revId+" is deleted successfully", true),
												HttpStatus.OK);
	}
	
}
