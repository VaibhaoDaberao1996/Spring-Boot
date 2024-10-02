package com.shopify.main.service;

import com.shopify.main.Dto.ReviewDto;

public interface ReviewService {

	ReviewDto createReview (ReviewDto review);
	
	void deleteReview(long revId);
	
	ReviewDto getSingleReview(long revId);
}
