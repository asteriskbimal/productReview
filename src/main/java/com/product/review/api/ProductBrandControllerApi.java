package com.product.review.api;


import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.product.review.model.ProductBrand;
import com.product.review.service.ProductBrandService;


@RestController
public class ProductBrandControllerApi {
	
	@Autowired
	private ProductBrandService productBrandServiceBean;
	
	
	@RequestMapping(value="/auth/admin/ListBrand", method = RequestMethod.GET)
	public ResponseEntity<List<ProductBrand>> getBrands(){
		
		List<ProductBrand> brands = (List<ProductBrand>) productBrandServiceBean.findAll();
				
		if(brands == null){
			return new ResponseEntity<List<ProductBrand>>(HttpStatus.NOT_FOUND);
		}
		
		System.out.println(brands.get(0).getBrandName());
		System.out.println(brands.get(1).getBrandName());
		System.out.println(brands.get(2).getBrandName());
		System.out.println(brands.get(3).getBrandName());
		System.out.println(brands.get(4).getBrandName());	
		
		return new ResponseEntity<List<ProductBrand>>(brands, HttpStatus.OK);
		//return brands;
	}
	
	@RequestMapping(value="/auth/admin/ListBrandwithCategory/{id}", method = RequestMethod.GET,produces="application/json; charset=UTF-8")
	public ResponseEntity<List<ProductBrand>> getBrandswithCategory(@PathVariable Long id){
		
		List<ProductBrand> brands = (List<ProductBrand>) productBrandServiceBean.findAll();
		List<ProductBrand> newbrands=new ArrayList<ProductBrand>();
		if(brands == null){
			return new ResponseEntity<List<ProductBrand>>(HttpStatus.NOT_FOUND);
		}
		for(ProductBrand pbd:brands){
			if(id==pbd.getCat().getCategoryId()){
				newbrands.add(pbd);
			}
		}	
		return new ResponseEntity<List<ProductBrand>>(newbrands, HttpStatus.OK);
	}
	
	//path variable define in url path  /ListProductItem/{id}
	@RequestMapping(value="/auth/admin/ListProductBrand/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductBrand> getProductBrand(@PathVariable Long id){
		
		ProductBrand productBrand = productBrandServiceBean.findOne(id);
		
		if(productBrand == null){
			return new ResponseEntity<ProductBrand>(HttpStatus.NOT_FOUND);
		}
			
		return new ResponseEntity<ProductBrand>(productBrand, HttpStatus.OK);
	}
	
		
	//Creating new ProductBrand
	@RequestMapping(value = "/auth/admin/CreateProductBrand", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> createProductBrand(ProductBrand productBrand) {
		return new ResponseEntity<Long>(productBrandServiceBean.create(productBrand), HttpStatus.CREATED);
	}
	
	//Creating new ProductBrand
	@RequestMapping(value = "/auth/admin/UpdateProductBrand", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateProductBrand(ProductBrand productBrand) {
		productBrandServiceBean.update(productBrand);
		return new ResponseEntity<String>("ProductBrand Updated", HttpStatus.CREATED);
	}
	
	//Deleting new ProductBrand
	@RequestMapping(value = "/auth/admin/DeleteProductBrand/{id}", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateProductBrand(@PathVariable Long id) {
		productBrandServiceBean.delete(productBrandServiceBean.findOne(id));
		return new ResponseEntity<String>("ProductBrand with id : "+id+" Successfully deleted", HttpStatus.CREATED);
	}

}
