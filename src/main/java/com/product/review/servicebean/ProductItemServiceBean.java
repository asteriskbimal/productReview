package com.product.review.servicebean;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.review.dao.IGenericDAO;
import com.product.review.model.ProductItem;
import com.product.review.service.ProductItemService;

@Service
@Transactional
public class ProductItemServiceBean implements ProductItemService{

	@Autowired
	private IGenericDAO<ProductItem> genericDAOImpl;
	
		

	public Collection<ProductItem> findAll() {
		 
		return genericDAOImpl.findAll(ProductItem.class);
	}

	public ProductItem findOne(Long id) {
		
		return genericDAOImpl.findOne(ProductItem.class,id);
	}


	public Long create(ProductItem product) {
		
//		if(product.getProductmodelId()!=null){
//			return null;
//		}
		return genericDAOImpl.create(product);
	}


	public void update(ProductItem product) {
		
//		ProductItem productPersisted = genericDAOImpl.findOne(ProductItem.class,product.getProductmodelId());
//		if(productPersisted == null ){
//			
//		}
		 genericDAOImpl.update(product);
	}

	public void delete(ProductItem product) {
		genericDAOImpl.delete(product);
	}

}
