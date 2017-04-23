package com.product.review.dao;

import java.util.Collection;

import com.product.review.model.Product;


public interface IGenericDAO<T> {

	Collection<T> findAll(Class<T> type);
	
	<U> Collection<T> findAllByProduct(Class<T> type,Product p);
	
	Collection<T> findAllByTypeId(Class<T> type,Long id);
	
	T  findOne(Class<T> type,Long id);
	
	Long create(T t);
	
	void update(T t);
	
	void delete(T t);

}
