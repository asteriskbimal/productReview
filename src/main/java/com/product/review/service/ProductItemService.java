package com.product.review.service;

import java.util.Collection;

import com.product.review.model.ProductItem;

public interface ProductItemService {
	
	Collection<ProductItem> findAll();
	
	ProductItem findOne(Long id);
	
	Long create(ProductItem product);
	
	void update(ProductItem product);
	
	void delete(ProductItem product);
	
}
