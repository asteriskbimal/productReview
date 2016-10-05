package com.product.review.service;

import java.util.Collection;

import com.product.review.model.SystemUser;


public interface SystemUserService {
	
	Collection<SystemUser> findAll();
	
	SystemUser findOne(Long id);
	
	Long create(SystemUser systemUser);
	
	void update(SystemUser systemUser);
	
	void delete(SystemUser systemUser);

}
