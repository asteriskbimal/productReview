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

import com.product.review.model.Category;
import com.product.review.model.Editor;
import com.product.review.model.Product;
import com.product.review.model.ProductBrand;
import com.product.review.service.CategoryService;
import com.product.review.service.ProductBrandService;
import com.product.review.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
@EnableTransactionManagement
public class ProductController {

	@Autowired
	private ProductBrandService productBrandService;

	@Autowired
	private ProductService produtService;

	@Autowired
	private CategoryService categoryService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Category.class, new Editor(categoryService));
		binder.registerCustomEditor(ProductBrand.class, new Editor(productBrandService));

	}

	@CrossOrigin(origins = "http://localhost:3000/dashboard")
	@RequestMapping(value = "/api/product", method = RequestMethod.GET)
	public @ResponseBody List<Product> getAllProduct() {
		List<Product> test = (List<Product>) produtService.findAll();
		return test;
	}

	@RequestMapping(value = "/auth/admin/product", method = RequestMethod.GET)
	public String getAllProduct(Model model) {
		List<Product> product = (List<Product>) produtService.findAll();
		if (product == null) {
			// model.addAttribute("brand",brand.add(new Product()) );
		} else
			model.addAttribute("product", product);
		return "product";
	}

	@RequestMapping(value = "/auth/admin/product/add", method = RequestMethod.GET)
	public String addProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		Map<Category, String> category = new HashMap<Category, String>();

		for (Category c : categoryService.findAll()) {
			category.put(c, c.getCategoryName());
		}

		model.addAttribute("category", category);
		return "add-product";
	}

	@RequestMapping(value = "/auth/admin/product/add", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute Product product) {
		System.out.println("I was here for product");
		produtService.create(product);
		return "redirect:/auth/admin/product";
	}

	@RequestMapping(value = "/auth/admin/product/edit", params = { "id" }, method = RequestMethod.GET)
	public String editProduct(@RequestParam("id") long id, Model model) {

		model.addAttribute("product", produtService.findOne(id));
		Map<Category, String> category = new HashMap<Category, String>();

		for (Category c : categoryService.findAll()) {
			category.put(c, c.getCategoryName());
		}
		model.addAttribute("category", category);
		return "add-product";
	}

	@RequestMapping(value = "/auth/admin/product/edit", method = RequestMethod.POST)
	public String saveEditedProduct(@RequestParam(value = "_submit", required = false) String submit,
			@RequestParam(value = "_cancel", required = false) String cancel, @ModelAttribute Product product) {
		//System.out.println(product.getProductId());
		if (cancel != null) {
			return "redirect:/auth/admin/product";
		} else {
			produtService.update(product);
		}
		return "redirect:/auth/admin/product";
	}

	@RequestMapping(value = "/auth/admin/product/remove", params = { "id" }, method = RequestMethod.GET)
	public String deleteProduct(@RequestParam("id") long id, Model model) {
		produtService.delete(produtService.findOne(id));
		return "redirect:/auth/admin/product";
	}
}
