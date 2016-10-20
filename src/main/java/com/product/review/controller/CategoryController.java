package com.product.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.product.review.model.Category;
import com.product.review.service.CategoryService;

/**
 * Handles requests for the application home page.
 */
@Controller
@EnableTransactionManagement
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

		
	@CrossOrigin(origins = "http://localhost:3000/dashboard")
	@RequestMapping(value="/api/category", method=RequestMethod.GET)
	public @ResponseBody List<Category> getAllCategories(){
		List<Category> test=(List<Category>) categoryService.findAll();
		return test;
	}
	
	@RequestMapping(value = "/auth/admin/category", method = RequestMethod.GET)
	public String getAllCategory(Model model) {
		List<Category> cat= (List<Category>) categoryService.findAll();
		if(cat==null){
			model.addAttribute("category",cat.add(new Category()) );
		}else
		model.addAttribute("category",cat);
		return "category";
	}

	@RequestMapping(value = "/auth/admin/category/add", method = RequestMethod.GET)
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "add-category";
	}

	@RequestMapping(value = "/auth/admin/category/add", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute Category category, Model model) {
		System.out.println("I was here");
		categoryService.create(category);
		return "redirect:/auth/admin/category";
	}

	@RequestMapping(value = "/auth/admin/category/edit", params = { "id" }, method = RequestMethod.GET)
	public String editCategory(@RequestParam("id") long id, Model model) {
        
		model.addAttribute("category", categoryService.findOne(id));
		return "add-category";
	}

	@RequestMapping(value = "/auth/admin/category/edit", method = RequestMethod.POST)
	public String saveEditedCategory(@RequestParam(value = "_submit", required = false) String submit,
			@RequestParam(value = "_cancel", required = false) String cancel, @ModelAttribute Category category) {
		System.out.println(category.getCategoryId());
		if (cancel != null) {
			return "redirect:/auth/admin/category";
		} else {
			categoryService.update(category);
		}
		return "redirect:/auth/admin/category";
	}

	@RequestMapping(value = "/auth/admin/category/remove", params = { "id" }, method = RequestMethod.GET)
	public String deleteCategory(@RequestParam("id") long id, Model model) {
		categoryService.delete(categoryService.findOne(id));
		return "redirect:/auth/admin/category";
	}
}
