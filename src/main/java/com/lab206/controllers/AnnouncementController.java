package com.lab206.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lab206.models.User;
import com.lab206.services.AnnouncementService;
import com.lab206.services.UserService;

@Controller
public class AnnouncementController {
	
	private UserService us;
	private AnnouncementService as;
	
	public AnnouncementController(UserService us, AnnouncementService as) {
		this.us = us;
		this.as = as;
	}
	
	@RequestMapping("/announcements")
	public String displayAllAnnouncements(Model model, Principal principal) {
		User currentUser = us.findByEmail(principal.getName());
		
		model.addAttribute("users", us.findByPoints());
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("announcements", as.findAll());
		return "announcements.jsp";
	}
	

}
