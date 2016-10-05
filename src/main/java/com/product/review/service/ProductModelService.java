package com.product.review.service;

import java.util.Collection;
import com.product.review.model.ProductModel;


public interface ProductModelService {
	
	Collection<ProductModel> findAll();
	
	ProductModel findOne(Long id);
	
	Long create(ProductModel productModel);
	
	void update(ProductModel productModel);
	
	void delete(ProductModel productModel);

}
