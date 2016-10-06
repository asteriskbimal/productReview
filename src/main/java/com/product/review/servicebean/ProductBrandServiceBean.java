package com.product.review.servicebean;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.review.dao.IGenericDAO;
import com.product.review.model.ProductBrand;
import com.product.review.service.ProductBrandService;

@Service
@Transactional
public class ProductBrandServiceBean implements ProductBrandService {

	@Autowired
	private IGenericDAO<ProductBrand> genericDAOImpl;


	public Collection<ProductBrand> findAll() {

		return genericDAOImpl.findAll(ProductBrand.class);
	}


	public ProductBrand findOne(Long id) {

		return genericDAOImpl.findOne(ProductBrand.class,id);
	}


	public Long create(ProductBrand productBrand) {

		if (productBrand.getBrandId()!= null) {
			return null;
		}
		return genericDAOImpl.create(productBrand);
	}


	public void update(ProductBrand productBrand) {
		ProductBrand add = genericDAOImpl.findOne(ProductBrand.class,productBrand.getBrandId());
		if (add == null) {
			
		}
		genericDAOImpl.update(productBrand);
	}


	public void delete(ProductBrand productBrand) {
		genericDAOImpl.delete(productBrand);

	}

}
