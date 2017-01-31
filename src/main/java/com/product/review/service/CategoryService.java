package com.product.review.service;

import java.util.Collection;

import com.product.review.model.Category;


public interface CategoryService extends Service{
	
	Collection<Category> findAll();
	
	Category findOne(Long id);
	
	Long create(Category category);
	
	void update(Category category);
	
	void delete(Category category);

}
