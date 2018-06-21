package com.lab206.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lab206.models.Feedback;
import com.lab206.services.AnnouncementService;
import com.lab206.services.FeedbackService;
import com.lab206.services.ReportService;
import com.lab206.services.UserService;
import com.lab206.validator.UserValidator;

@Controller
public class ModController {
	
	private final UserService us;
	private final FeedbackService fs;
	private final ReportService rs;
	private final AnnouncementService as;
	private final UserValidator userValidator;
	
	public ModController(UserService us, UserValidator userValidator, FeedbackService fs, AnnouncementService as, ReportService rs) {
		this.us = us;
		this.userValidator = userValidator;
		this.fs = fs;
		this.rs = rs;
		this.as = as;

	}
	
	@RequestMapping("/mod")
    public String mod(Principal principal, Model model, @ModelAttribute("feedback") Feedback feedback) {
		model.addAttribute("all_feedback", fs.findAll());
		model.addAttribute("all_reports", rs.findAll());
        return "mod.jsp";
    }
	
	@RequestMapping("/feedback/{id}")
	public String displayFeedback(@PathVariable("id") Long id, Model model) {
		model.addAttribute("reviewfeedback", fs.findById(id));
		return "feedback.jsp";
	}

}
