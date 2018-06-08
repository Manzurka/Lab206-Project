package com.lab206.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lab206.models.FileModel;
import com.lab206.models.User;
import com.lab206.persistence.HibernateUtil;
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
        return "login.jsp";
    }
	
	@RequestMapping(value = {"/", "/dashboard"})
    public String home(Principal principal, Model model) {
        String username = principal.getName();
        User currentUser = userService.findByUsername(username);
        model.addAttribute("currentUser", currentUser);
        return "dashboard.jsp";
    }
	
	@RequestMapping("/registration") 
		public String reg(@ModelAttribute("user") User user) {
			return "register.jsp";
	
	}
	@PostMapping("/registration")
	public String reg(@Valid @ModelAttribute("user") User user, BindingResult result, 
			Model model, HttpSession session, HttpServletRequest request) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
	        return "register.jsp";
	    }
        if (userService.findRoleByName("ROLE_ADMIN").getUsers().size() == 0) {
	    	userService.saveUserWithAdminRole(user);
    	}else {
			userService.saveWithUserRole(user);
		    try {
		        request.login(user.getEmail(),user.getPasswordConfirmation());
		        return "redirect:/dashboard";
		    } catch (ServletException e) {
		        System.out.println("IT DID NOT WORK :C");
		        System.out.println(e);
		    }	
    	}
		    return "redirect:/dashboard";
	}
        
}

