package com.product.review.service;

import java.util.Collection;

import com.product.review.model.ProductBrand;


public interface ProductBrandService {
	
	Collection<ProductBrand> findAll();
	
	ProductBrand findOne(Long id);
	
	Long create(ProductBrand productBrand);
	
	void update(ProductBrand productBrand);
	
	void delete(ProductBrand productBrand);

}
