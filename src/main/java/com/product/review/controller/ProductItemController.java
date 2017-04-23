/*package com.product.review.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.product.review.model.Editor;
import com.product.review.model.Feature;
import com.product.review.model.Product;
import com.product.review.model.ProductItem;
import com.product.review.model.ProductModel;
import com.product.review.model.Review;
import com.product.review.service.FeatureService;
import com.product.review.service.ProductItemService;
import com.product.review.service.ProductModelService;
import com.product.review.service.ProductService;
import com.product.review.service.ReviewService;

*//**
 * Handles requests for the application home page.
 *//*
@Controller
@EnableTransactionManagement
public class ProductItemController {

	@Autowired
	private ProductModelService productModelService;
	
	@Autowired
	private ReviewService reviewsService;

	@Autowired
	private ProductItemService productItemService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Review.class, new Editor(reviewsService));
		binder.registerCustomEditor(ProductModel.class, new Editor(productModelService));
	}

	@CrossOrigin(origins = "http://localhost:3000/dashboard")
	@RequestMapping(value = "/api/productItem", method = RequestMethod.GET)
	public @ResponseBody List<ProductModel> getAllProduct() {
		List<ProductModel> test = (List<ProductModel>) productItemService.findAll();
		return test;
	}

	@RequestMapping(value = "/auth/admin/productItem", method = RequestMethod.GET)
	public String getAllProduct(Model model) {
		List<ProductModel> productItem = (List<ProductModel>) productItemService.findAll();
		if (productItem == null) {
			// model.addAttribute("brand",brand.add(new Product()) );
		} else
			model.addAttribute("productItem", productItem);
		return "productItem";
	}

	@RequestMapping(value = "/auth/admin/productItem/add", method = RequestMethod.GET)
	public String addProduct(Model model) {
		ProductModel productItem = new ProductModel();
		model.addAttribute("productItem", productItem);
		
		Map<ProductModel, String> productModel = new HashMap<ProductModel, String>();

		for(ProductModel p : productModelService.findAll()) {
			productModel.put(p, p.getModel());
		}

		model.addAttribute("productModel", productModel);
		return "add-product";
	}

	@RequestMapping(value = "/auth/admin/productItem/add", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute ProductModel productItem) {
		System.out.println("I was here for product");
		productItemService.create(productItem);
		return "redirect:/auth/admin/productItem";
	}

	@RequestMapping(value = "/auth/admin/productItem/edit", params = { "id" }, method = RequestMethod.GET)
	public String editProduct(@RequestParam("id") long id, Model model) {

		model.addAttribute("productItem", productItemService.findOne(id));
		Map<ProductModel, String> product = new HashMap<ProductModel, String>();

		for (ProductModel p : productModelService.findAll()) {
			product.put(p,p.getDescription());
		}
		
		
		model.addAttribute("product", product);
		return "add-product";
	}

	@RequestMapping(value = "/auth/admin/productItem/edit", method = RequestMethod.POST)
	public String saveEditedProduct(@RequestParam(value = "_submit", required = false) String submit,
			@RequestParam(value = "_cancel", required = false) String cancel, @ModelAttribute ProductItem productItem) {
		//System.out.println(product.getProductId());
		if (cancel != null) {
			return "redirect:/auth/admin/productItem";
		} else {
			productItemService.update(productItem);
		}
		return "redirect:/auth/admin/productItem";
	}

	@RequestMapping(value = "/auth/admin/productItem/remove", params = { "id" }, method = RequestMethod.GET)
	public String deleteProduct(@RequestParam("id") long id, Model model) {
		
		
			produtModelService.delete(produtModelService.findOne(id));
		
		return "redirect:/auth/admin/productItem";
	}
}
*/