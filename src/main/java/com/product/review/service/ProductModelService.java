package com.product.review.service;

import java.util.Collection;

import com.product.review.model.Product;
import com.product.review.model.ProductModel;


public interface ProductModelService extends Service{
	
	Collection<ProductModel> findAll();
	
	Collection<ProductModel> findAllByProduct(Product p);
	
	Collection<ProductModel> findAllByProductId(Long Id);
	
	ProductModel findOne(Long id);
	
	Long create(ProductModel productModel);
	
	void update(ProductModel productModel);
	
	void delete(ProductModel productModel);

}
