package com.lab206.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lab206.models.Announcement;
import com.lab206.models.Feedback;
import com.lab206.models.Report;
import com.lab206.models.User;
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
    public String mod(Principal principal, Model model,
    		@ModelAttribute("feedback") Feedback feedback,
    		@ModelAttribute("review") Feedback review,
    		@ModelAttribute("announce") Announcement announce) {
		model.addAttribute("all_announcements", as.findAll());
		model.addAttribute("all_feedback", fs.findAll());
		model.addAttribute("all_reports", rs.findAll());
				
		String email = principal.getName();
		model.addAttribute("currentUser", us.findByEmail(email));
        return "mod.jsp";
    }
	
	@RequestMapping("/mod/announce")
    public String announce(Principal principal, Model model, @ModelAttribute("announce") Announcement announce, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("all_announcements", as.findAll());
			return "mod.jsp";
		}
		as.createAnnouncement(announce);
		model.addAttribute("all_announcements", as.findAll());
        return "redirect:/mod";
    }
	
	// Route for marking a Feedback as reviewed(true). This route is displaying within the feedback modal
	@RequestMapping("/feedback/{id}/reviewed")
    public String feedReview(@PathVariable("id") Long id, Model model) {
		Feedback feedback = fs.findFeedbackById(id);
		fs.updateReview(feedback);
		System.out.println("Updated Review: " + feedback.getReviewed());
		
        return "redirect:/mod";
    }
	
	@RequestMapping("/report/{id}/reviewed")
    public String reportReview(@PathVariable("id") Long id) {
		Report report = rs.findReportById(id);
		rs.updateReportReview(report);
		System.out.println("Updated Review: " + report.getReviewed());
        return "redirect:/mod";
    }
	
	
	// Archiving Announcements (Deleting)
	@RequestMapping("/announcement/{id}/archive")
    public String archiveAnnouncements(@PathVariable("id") Long id) {
		Announcement archive = as.findById(id);
		as.removeAnnouncement(archive);
        return "redirect:/mod";
    }
	

}
