package com.mcajayon.events.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mcajayon.events.models.User;
import com.mcajayon.events.services.UserService;
import com.mcajayon.events.validator.UserValidator;

@Controller
public class UsersController {
	private final UserValidator userValidator;
	private final UserService userService;
	private String[] listOf50states;
	
	public UsersController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.listOf50states=new String[] {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};
		this.userValidator = userValidator;
	}
	
	@RequestMapping("/login") 
		public String home(@ModelAttribute("user") User user,@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
		if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        model.addAttribute("listOfstates", listOf50states);
		return "index.jsp";
	}
	
	@RequestMapping("/registration") 
		public String reg(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session, HttpServletRequest request) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			model.addAttribute("listOfstates", listOf50states);
            return "index.jsp";
        }
		userService.saveWithUserRole(user);
        try {
            request.login(user.getEmail(),user.getPasswordConfirmation());
        } catch (ServletException e) {
            System.out.println("It didn't work, test.");
        }	
        return "redirect:/events";
	}
}