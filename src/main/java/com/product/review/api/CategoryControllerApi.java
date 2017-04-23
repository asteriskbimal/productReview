package com.product.review.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.product.review.model.Category;
import com.product.review.service.CategoryService;
@CrossOrigin
@RestController
public class CategoryControllerApi {

	@Autowired
	private CategoryService categoryServiceBean;

	@RequestMapping(value="ListCategory", method = RequestMethod.GET,headers = "Accept=application/json")
	public ResponseEntity<List<Category>> getCategories(CorsRegistry registry){
		
		List<Category> categories = (List<Category>) categoryServiceBean.findAll();
		
		if(categories == null){
			return new ResponseEntity<List<Category>>(HttpStatus.NOT_FOUND);
		}
		
		/* registry.addMapping("/*").allowedOrigins("*").allowedMethods("GET", "POST", "OPTIONS", "PUT")
         .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                 "Access-Control-Request-Headers")
         .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
         .allowCredentials(true).maxAge(3600);*/
			
		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}

	// path variable define in url path /ListProductItem/{id}
	@RequestMapping(value = "/auth/admin/ListCategory/{id}", method = RequestMethod.GET)
	public ResponseEntity<Category> getCategory(@PathVariable Long id) {

		Category category = categoryServiceBean.findOne(id);

		if (category == null) {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}

	// Creating new Category
	@RequestMapping(value = "/CreateCategory", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> createCategory(Category category) {
		return new ResponseEntity<Long>(categoryServiceBean.create(category), HttpStatus.CREATED);
	}

	// Creating new Category
	@RequestMapping(value = "/auth/admin/UpdateCategory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateCategory(Category category) {
		categoryServiceBean.update(category);
		return new ResponseEntity<String>("Category Updated", HttpStatus.CREATED);
	}

	// Deleting new Category
	@RequestMapping(value = "/auth/admin/DeleteCategory/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateCategory(@PathVariable Long id) {
		categoryServiceBean.delete(categoryServiceBean.findOne(id));
		return new ResponseEntity<String>("Category with id : " + id + " Successfully deleted", HttpStatus.CREATED);
	}

}
