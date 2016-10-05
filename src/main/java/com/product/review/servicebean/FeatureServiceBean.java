package com.product.review.servicebean;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.review.dao.IGenericDAO;
import com.product.review.model.Feature;
import com.product.review.service.FeatureService;

@Service
public class FeatureServiceBean implements FeatureService {

	@Autowired
	private IGenericDAO<Feature> genericDAOImpl;


	public Collection<Feature> findAll() {

		return genericDAOImpl.findAll(Feature.class);
	}


	public Feature findOne(Long id) {

		return genericDAOImpl.findOne(Feature.class,id);
	}

	public Long create(Feature feature) {

		if (feature.getFeatureId() != null) {
			return null;
		}
		return genericDAOImpl.create(feature);
	}


	public void update(Feature feature) {
		Feature add = genericDAOImpl.findOne(Feature.class,feature.getFeatureId());
		if (add == null) {
			
		}
		genericDAOImpl.update(feature);
	}

	public void delete(Feature feature) {
		genericDAOImpl.delete(feature);

	}

}
