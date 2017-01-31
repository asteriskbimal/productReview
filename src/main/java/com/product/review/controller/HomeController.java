package com.product.review.controller;

import java.util.List;
import java.util.Locale;

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
import org.springframework.web.servlet.ModelAndView;

import com.product.review.model.SystemUser;
import com.product.review.service.SystemUserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@EnableTransactionManagement
public class HomeController {

	@Autowired
	private SystemUserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "login";
	}
	
	@CrossOrigin(origins = "http://localhost:3000/dashboard")
	@RequestMapping(value="/api", method=RequestMethod.GET)
	public @ResponseBody List<SystemUser> getAllUsers(){
		List<SystemUser> test=(List<SystemUser>) userService.findAll();
		return test;
	}
	
	@RequestMapping(value="/api/test", method=RequestMethod.GET)
	public String getAllUsersRest(){
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "authFailed", required = false) String authFailed,
			@RequestParam(value = "unauthorized", required = false) boolean unauthorized,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (authFailed != null) {
			model.addObject("authFailed", "Invalid username and password!");
		}

		if (unauthorized) {
			model.addObject("authFailed", "Sorry, you are not allowed to view this page. You are automatically logged out.");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;
	}
	
	@RequestMapping(value = "/auth/admin/user", method = RequestMethod.GET)
	public String afterAdminAuth(Model model) {
		model.addAttribute("systemUser", userService.findAll());
		return "home";
	}

	@RequestMapping(value = "/auth/admin/user/add", method = RequestMethod.GET)
	public String addUser(Model model) {
		model.addAttribute("systemUser", new SystemUser());
		return "add-user";
	}

	@RequestMapping(value = "/auth/admin/user/add", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute SystemUser user, Model model) {
		System.out.println("I am here");
		userService.create(user);
		return "redirect:/auth/admin/user";
	}

	@RequestMapping(value = "/auth/admin/user/edit", params = { "id" }, method = RequestMethod.GET)
	public String editUser(@RequestParam("id") long id, Model model) {
        
		model.addAttribute("systemUser", userService.findOne(id));
		return "add-user";
	}

	@RequestMapping(value = "/auth/admin/user/edit", method = RequestMethod.POST)
	public String saveEditedUser(@RequestParam(value = "_submit", required = false) String submit,
			@RequestParam(value = "_cancel", required = false) String cancel, @ModelAttribute SystemUser systemUser) {
		System.out.println(systemUser.getSystemUserId());
		//SystemUser s=userService.findOne(systemUser.getSystemUserId());
		
		if (cancel != null) {
			return "redirect:/auth/admin/user";
		} else {
			userService.update(systemUser);
		}
		return "redirect:/auth/admin/user";
	}

	@RequestMapping(value = "/auth/admin/user/remove", params = { "id" }, method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") long id, Model model) {
		userService.delete(userService.findOne(id));
		return "redirect:/auth/admin/user";
	}
}
