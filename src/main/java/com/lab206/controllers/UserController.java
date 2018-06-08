package com.lab206.controllers;

import java.security.Principal;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab206.models.Role;
import com.lab206.models.User;
import com.lab206.services.UserService;
import com.lab206.validator.UserValidator;

@Controller
public class UserController {
	
	private final UserService userService;
	private final UserValidator userValidator;
	
	
	public UserController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;

	}
	
	
	@RequestMapping("/login")
    public String login(@ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        
        
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        
        while (salt.length() < 16) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        System.out.println(saltStr);
        
        
        return "login.jsp";
    }
	
	
//	
//	@RequestMapping(value = {"/", "/dashboard"})
//    public String home(Principal principal, Model model) {
//        String username = principal.getName();
//        model.addAttribute("currentUser", userService.findByUsername(username));
//        return "dashboard.jsp";
//    }
	
//	
	@RequestMapping("/admin")
    public String admin(Principal principal, Model model, @ModelAttribute("announce") User announce, @ModelAttribute("invite") User invite) {
		model.addAttribute("all_users", userService.findAll());
        return "admin.jsp";
    }
	
	@RequestMapping("/user/{id}/delete")
	public String removeUser(@PathVariable("id") Long id, Principal p) {
		User user = userService.findById(id);
		userService.removeUser(user);
		return "redirect:/admins";				
	}
	
	
}
