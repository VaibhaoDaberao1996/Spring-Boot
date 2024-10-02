package com.shopify.main.service.implService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopify.main.Dto.ReviewDto;
import com.shopify.main.Exception.ResourceNotFoundException;
import com.shopify.main.entities.Review;
import com.shopify.main.repository.ReviewRepository;
import com.shopify.main.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewRepository review_repository;
	
	@Autowired
	private ModelMapper model_conversion;
	
	@Override
	public ReviewDto createReview(ReviewDto review) {
		Review saveReview =this.review_repository.save(
				this.model_conversion.map(review, Review.class));
		
		return this.model_conversion.map(saveReview, ReviewDto.class);
	}

	@Override
	public void deleteReview(long revId) {
		Review review = this.review_repository.findById(revId).orElseThrow(
				()->new ResourceNotFoundException("Review", "review Id ", revId));
		this.review_repository.delete(review);
	}
	
	@Override
	public ReviewDto getSingleReview(long revId) {
		Review review = this.review_repository.findById(revId).orElseThrow(
				()->new ResourceNotFoundException("Review", "review Id ", revId));
		
		return this.model_conversion.map(review, ReviewDto.class);
	}


}
