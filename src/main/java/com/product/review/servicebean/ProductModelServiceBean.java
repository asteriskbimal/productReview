package com.product.review.servicebean;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.review.dao.IGenericDAO;
import com.product.review.model.ProductModel;
import com.product.review.service.ProductModelService;

@Service
@Transactional
public class ProductModelServiceBean implements ProductModelService {

	
	
	@Autowired
	private IGenericDAO<ProductModel> genericDAOImpl;
	
		
	public Collection<ProductModel> findAll() {
		 
		return genericDAOImpl.findAll(ProductModel.class);
	}


	public ProductModel findOne(Long id) {
		
		return genericDAOImpl.findOne(ProductModel.class,id);
	}


	public Long create(ProductModel productModel) {
		
		if(productModel.getProductmodelId()!=null){
			return null;
		}
		return genericDAOImpl.create(productModel);
	}


	public void update(ProductModel productModel) {
		
		ProductModel productModelPersisted = genericDAOImpl.findOne(ProductModel.class,productModel.getProductmodelId());
		if(productModelPersisted == null ){
			
		}
		genericDAOImpl.update(productModel);
	}


	public void delete(ProductModel productModel) {
		genericDAOImpl.delete(productModel);
	}


}
