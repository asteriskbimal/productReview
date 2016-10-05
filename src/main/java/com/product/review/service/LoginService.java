package com.product.review.service;

import java.util.Collection;

import com.product.review.model.Login;


public interface LoginService {
	
	Collection<Login> findAll();
	
	Login findOne(Long id);
	
	Long create(Login login);
	
	void update(Login login);
	
	void delete(Login login);

}
