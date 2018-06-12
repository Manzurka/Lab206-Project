package com.lab206.controllers;

import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab206.models.User;
import com.lab206.services.UserService;
import com.lab206.validator.UserValidator;

@Controller
public class UserController {
	
	private UserService us;
	private UserValidator uv;
	
	public UserController(UserService us,
			UserValidator uv) {
		this.us = us;
		this.uv = uv;
	}

	@RequestMapping("/login") 
	public String login(@ModelAttribute("user") User user,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			Model model){
		if(error != null) {
			model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
		}
		if(logout != null) {
			model.addAttribute("logoutMessage", "Logout Successful!");
		}
		return "login.jsp";
	}
	
	@RequestMapping("/user/new")
	public String newUser(@ModelAttribute("newUser") User newUser) {
		return "register.jsp";
	}
	
	@PostMapping("/user/create")
	public String createUser(@Valid @ModelAttribute("newUser") User newUser,
			BindingResult res,
			HttpSession session,
			HttpServletRequest request,
			Model model) {
		uv.validate(newUser, res);
		if (res.hasErrors()) {
			return "register.jsp";
		}
		us.saveUserWithModRole(newUser);
		try {
			request.login(newUser.getEmail(),newUser.getPasswordConfirmation());
			return "redirect:/dashboard";
		} catch (ServletException e) {
			System.out.println("IT DID NOT WORK :<");
		}
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Principal principal,
			Model model) {
		User currentUser = us.findByEmail(principal.getName());
		model.addAttribute("currentUser", currentUser);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/feedback")
	public String feedback(Principal principal, Model model) {
		return "feedback.jsp";
	}

}
