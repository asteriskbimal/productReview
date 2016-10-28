package com.product.review.servicebean;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.review.dao.IGenericDAO;
import com.product.review.model.Category;
import com.product.review.service.CategoryService;

@Service
@Transactional
public class CategoryServiceBean implements CategoryService {

	@Autowired
	private IGenericDAO<Category> genericDAOImpl;
	

	public Collection<Category> findAll() {

		return genericDAOImpl.findAll(Category.class);
	}


	public Category findOne(Long id) {

		return genericDAOImpl.findOne(Category.class,id);
	}


	public Long create(Category category) {

		if (category.getCategoryId() != null) {
			return null;
		}
		return genericDAOImpl.create(category);
	}


	public void update(Category category) {
		genericDAOImpl.update(category);
	}


	public void delete(Category category) {
		genericDAOImpl.delete(category);

	}

}
