package com.lab206.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lab206.models.Announcement;
import com.lab206.models.Feedback;
import com.lab206.services.FeedbackService;
import com.lab206.services.UserService;

@Controller
public class FeedbackController {
	
	private FeedbackService fs;
	private UserService us;
	
	public FeedbackController(FeedbackService fs, UserService us) {
		this.fs = fs;
		this.us = us;
	}
	
	
	@RequestMapping("create/feedback")
	public String creatingFeedback(@ModelAttribute("feedb") Feedback feedback, Principal p) {
		
		// Fetching the current signed in users email address to grab the Feedback Creator
		feedback.setFeedbackCreator(us.findByEmail(p.getName()));
		fs.createFeedback(feedback);
		return "redirect:/dashboard";
	}
	

}
