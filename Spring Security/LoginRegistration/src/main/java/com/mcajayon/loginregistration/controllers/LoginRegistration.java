package com.mcajayon.loginregistration.controllers;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mcajayon.loginregistration.models.User;
import com.mcajayon.loginregistration.services.UserService;

@Controller
public class LoginRegistration {

	private final UserService userService;
	
	public LoginRegistration(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/login")
	public String loginReg(@Valid @ModelAttribute("new_user") User user) {
		return "index.jsp";
	}
	
	@PostMapping("/registration")
	public String register(@Valid @ModelAttribute("new_user") User user, BindingResult result, Model model, HttpSession session) {
		System.out.println("test");
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			System.out.println("No errors");
			System.out.println(user.getEmail());
			userService.saveWithUserRole(user);
			return "redirect:/login";
		}
	}
	
//	@RequestMapping("/login")
//	public String login(@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required = false) String error, @RequestParam(value="logout", required = false) String logout, Model model) {
//		if (error != null) {
//			model.addAttribute("errorMessage", "Bad credentials, try again");
//		}
//		if (logout != null) {
//			model.addAttribute("logoutMessage", "Logout successful");
//		}
//		return "index.jsp";
//	}
	
	@RequestMapping(value = {"/", "/dashboard"})
	public String dashboard(Principal principal, Model model) {
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByUsername(username));
		Date date = new Date();
		model.addAttribute("logindate", date);
		return "dashboard.jsp";
	}
}