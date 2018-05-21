package com.mcajayon.admindashboard.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mcajayon.admindashboard.models.User;
import com.mcajayon.admindashboard.services.UserService;
import com.mcajayon.admindashboard.validator.UserValidator;

@Controller
public class UsersController {

	private UserService userService;
	
	private UserValidator userValidator;
	
	public void Users(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
//	@RequestMapping("/")
//	public String index() {
//		return "index.jsp";
//	}
	
	@RequestMapping("/register")
	public String registerForm(@Valid @ModelAttribute("user") User user) {
		return "register.jsp";
	}
	
	@PostMapping("/register")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "index.jsp";
		}
		if (userService.findRoleByName("ROLE_ADMIN").getUsers().size() == 0) {
			userService.saveUserWithAdminRole(user);
		} else {
			userService.saveWithUserRole(user);
		}
		
		return "redirect:/login";
	}
	
	@RequestMapping("/")
	public String login(@Valid @ModelAttribute("user") User user,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			Model model) {
		if (error != null) {
			model.addAttribute("errorMessage", "Invalid credentials, please try again.");
		} if (logout != null) {
			model.addAttribute("logoutMessage", "Logout successsful");
		}
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String display(Principal principal,
			Model model) {
		User user = userService.findUserByUsername(principal.getName());
		if (user.getRoles().contains(userService.findRoleByName("ROLE_ADMIN"))) {
			return "redirect:/admin";
		}
		model.addAttribute("currentUser", user);
		return "display.jsp";
	}
	
	@RequestMapping("/admin")
	public String adminDashboard(Principal principal,
			@ModelAttribute("errors") String errors,
			Model model) {
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findUserByUsername(username));
		model.addAttribute("admin", userService.findRoleByName("ROLE_ADMIN"));
		model.addAttribute("users", userService.findAllUsers());
		return "admin.jsp";
	}
	
	@RequestMapping("/admin/user/delete/{id}")
	public String destroyUser(@PathVariable("id") Long id,
			RedirectAttributes errors) {
		if (userService.findUserById(id).getRoles().contains(userService.findRoleByName("ROLE_ADMIN"))) {
			errors.addFlashAttribute("errors", "Cannot delete another admin.");
			return "redirect:/admin";
		}
		userService.deleteUserById(id);
		return "redirect:/admin";
	}
	
	@RequestMapping("/admin/user/makeAdmin/{id}")
	public String makeUserAdmin(@PathVariable("id") Long id) {
		userService.saveUserWithAdminRole(userService.findUserById(id));
		return "redirect:/admin";
	}
}