package com.product.review.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.product.review.model.ProductItem;
import com.product.review.service.ProductItemService;


@RestController
public class ProductItemController {
	
	@Autowired
	private ProductItemService productServiceBean;
	
	
	@RequestMapping(value="/ListProductItem", method = RequestMethod.GET)
	public ResponseEntity<List<ProductItem>> getProductItem(){
		
		List<ProductItem> productItems = (List<ProductItem>) productServiceBean.findAll();
		
		if(productItems == null){
			return new ResponseEntity<List<ProductItem>>(HttpStatus.NOT_FOUND);
		}
			
		return new ResponseEntity<List<ProductItem>>(productItems, HttpStatus.OK);
	}
	
	//path variable define in url path  /ListProductItem/{id}
	@RequestMapping(value="/ListProductItem/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductItem> getProductItem(@PathVariable Long id){
		
		ProductItem productItem = (ProductItem) productServiceBean.findOne(id);
		
		if(productItem == null){
			return new ResponseEntity<ProductItem>(HttpStatus.NOT_FOUND);
		}
			
		return new ResponseEntity<ProductItem>(productItem, HttpStatus.OK);
	}
	
		
	//Creating new ProductItem
	@RequestMapping(value = "/CreateProductItem", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> createGreeting(ProductItem productItem) {
		return new ResponseEntity<Long>(productServiceBean.create(productItem), HttpStatus.CREATED);
	}

	//Deleting new Category
		@RequestMapping(value = "/DeleteProductItem/{id}", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> updateCategory(@PathVariable Long id) {	
			productServiceBean.delete(productServiceBean.findOne(id));
			return new ResponseEntity<String>("ProductItem with id : "+id+" Successfully deleted", HttpStatus.CREATED);
		}
	
}
