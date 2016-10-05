package com.product.review.servicebean;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.review.dao.IGenericDAO;
import com.product.review.model.Review;
import com.product.review.service.ReviewService;

@Service
public class ReviewServiceBean implements ReviewService {

	@Autowired
	private IGenericDAO<Review> genericDAOImpl;

	public Collection<Review> findAll() {

		return genericDAOImpl.findAll(Review.class);
	}

	public Review findOne(Long id) {

		return genericDAOImpl.findOne(Review.class,id);
	}

	public Long create(Review review) {

		if (review.getReviewId() != null) {
			return null;
		}
		return genericDAOImpl.create(review);
	}

	public void update(Review review) {
		Review add = genericDAOImpl.findOne(Review.class,review.getReviewId());
		if (add == null) {
			
		}
		genericDAOImpl.update(review);
	}

	public void delete(Review review) {
		genericDAOImpl.delete(review);

	}

}
