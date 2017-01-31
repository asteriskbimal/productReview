package com.product.review.service;

import java.util.Collection;

import com.product.review.model.Feature;


public interface FeatureService extends Service{
	
	Collection<Feature> findAll();
	
	Feature findOne(Long id);
	
	Long create(Feature feature);
	
	void update(Feature feature);
	
	void delete(Feature feature);

}
