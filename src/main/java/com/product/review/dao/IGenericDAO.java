package com.product.review.dao;

import java.util.Collection;

public interface IGenericDAO<T> {

	Collection<T> findAll(Class<T> type);
	
	T  findOne(Class<T> type,Long id);
	
	Long create(T t);
	
	void update(T t);
	
	void delete(T t);

}
