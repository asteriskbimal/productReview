package com.product.review.servicebean;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.review.dao.IGenericDAO;
import com.product.review.model.Product;
import com.product.review.service.ProductService;

@Service
public class ProductServiceBean implements ProductService{
	
	@Autowired
	private IGenericDAO<Product> genericDAOImpl;


	public Collection<Product> findAll() {
		
		return genericDAOImpl.findAll(Product.class);
	}


	public Product findOne(Long id) {
		
		return genericDAOImpl.findOne(Product.class,id);
	}

	public Long create(Product product) {
		
		if(product.getProductId()!=null){
			return null;
		}
		return genericDAOImpl.create(product);
	}


	public void update(Product product) {
		Product prod=genericDAOImpl.findOne(Product.class,product.getProductId());
		if(prod==null){
			
		}
		genericDAOImpl.update(product);
	}

	public void delete(Product product) {
		genericDAOImpl.delete(product);
		
	}
	

}
