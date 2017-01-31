package com.product.review.service;

import java.util.Collection;

import com.product.review.model.Review;


public interface ReviewService extends Service{
	
	Collection<Review> findAll();
	
	Review findOne(Long id);
	
	Long create(Review review);
	
	void update(Review review);
	
	void delete(Review review);

}
