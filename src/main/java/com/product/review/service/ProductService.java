package com.product.review.service;

import java.util.Collection;

import com.product.review.model.Product;


public interface ProductService {
	
	Collection<Product> findAll();
	
	Product findOne(Long id);
	
	Long create(Product product);
	
	void update(Product product);
	
	void delete(Product product);

}
