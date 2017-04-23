package com.product.review.controller;

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
import com.product.review.service.FeatureService;
import com.product.review.service.ProductItemService;
import com.product.review.service.ProductModelService;
import com.product.review.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
@EnableTransactionManagement
public class ProductModelController {

	@Autowired
	private FeatureService productFeatureService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductModelService produtModelService;

	@Autowired
	private ProductItemService productItemService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Feature.class, new Editor(productFeatureService));
		binder.registerCustomEditor(ProductItem.class, new Editor(productItemService));
		binder.registerCustomEditor(Product.class, new Editor(productService));

	}

	@CrossOrigin(origins = "http://localhost:3000/dashboard")
	@RequestMapping(value = "/api/productModel", method = RequestMethod.GET)
	public @ResponseBody List<ProductModel> getAllProduct() {
		List<ProductModel> test = (List<ProductModel>) produtModelService.findAll();
		return test;
	}

	@RequestMapping(value = "/auth/admin/productModel", method = RequestMethod.GET)
	public String getAllProduct(Model model) {
		List<ProductModel> productModel = (List<ProductModel>) produtModelService.findAll();
		if (productModel == null) {
			// model.addAttribute("brand",brand.add(new Product()) );
		} else
			model.addAttribute("productModel", productModel);
		return "productModel";
	}

	@RequestMapping(value = "/auth/admin/productModel/add", method = RequestMethod.GET)
	public String addProduct(Model model) {
		ProductModel productModel = new ProductModel();
		model.addAttribute("productModel", productModel);
		
		Map<Product, String> product = new HashMap<Product, String>();

		for (Product p : productService.findAll()) {
			product.put(p, p.getDescription());
		}

		model.addAttribute("product", product);
		return "add-product";
	}

	@RequestMapping(value = "/auth/admin/productModel/add", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute ProductModel productModel) {
		System.out.println("I was here for product");
		produtModelService.create(productModel);
		return "redirect:/auth/admin/productModel";
	}

	@RequestMapping(value = "/auth/admin/productModel/edit", params = { "id" }, method = RequestMethod.GET)
	public String editProduct(@RequestParam("id") long id, Model model) {

		model.addAttribute("productModel", produtModelService.findOne(id));
		Map<Product, String> product = new HashMap<Product, String>();

		for (Product p : productService.findAll()) {
			product.put(p,p.getDescription());
		}
		
		
		model.addAttribute("product", product);
		return "add-product";
	}

	@RequestMapping(value = "/auth/admin/productModel/edit", method = RequestMethod.POST)
	public String saveEditedProduct(@RequestParam(value = "_submit", required = false) String submit,
			@RequestParam(value = "_cancel", required = false) String cancel, @ModelAttribute ProductModel productModel) {
		//System.out.println(product.getProductId());
		if (cancel != null) {
			return "redirect:/auth/admin/productModel";
		} else {
			produtModelService.update(productModel);
		}
		return "redirect:/auth/admin/productModel";
	}

	@RequestMapping(value = "/auth/admin/productModel/remove", params = { "id" }, method = RequestMethod.GET)
	public String deleteProduct(@RequestParam("id") long id, Model model) {
		
		if(produtModelService.findOne(id).getProductItems().size()==0){
			produtModelService.delete(produtModelService.findOne(id));
		}
		return "redirect:/auth/admin/productModel";
	}
}
