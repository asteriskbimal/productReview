package com.product.review.service;

import java.util.Collection;

import com.product.review.model.Address;


public interface AddressService {
	
	Collection<Address> findAll();
	
	Address findOne(Long id);
	
	Long create(Address address);
	
	void update(Address address);
	
	void delete(Address address);

}
