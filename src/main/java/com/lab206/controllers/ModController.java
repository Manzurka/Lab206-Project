package com.lab206.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lab206.models.Announcement;
import com.lab206.models.Badge;
import com.lab206.models.Feedback;
import com.lab206.models.File;
import com.lab206.models.Report;

import com.lab206.repositories.FileUploadDAO;

import com.lab206.services.AnnouncementService;
import com.lab206.services.BadgeService;
import com.lab206.services.FeedbackService;
import com.lab206.services.FileService;
import com.lab206.services.ReportService;
import com.lab206.services.UserService;


@Controller
public class ModController {
	
	@Autowired
    private FileUploadDAO fileUploadDao;
	
	private UserService us;
	private FeedbackService fs;
	private ReportService rs;
	private AnnouncementService as;
	private BadgeService bs;
	private FileService fileService;
	
	public ModController(UserService us, FeedbackService fs, AnnouncementService as, ReportService rs, BadgeService bs, FileService fileService) {
		this.us = us;
		this.fs = fs;
		this.rs = rs;
		this.as = as;
		this.bs = bs;
		this.fileService = fileService;
	}
	
	@RequestMapping("/mod")
    public String mod(Principal principal, Model model,
    		@ModelAttribute("feedback") Feedback feedback,
    		@ModelAttribute("review") Feedback review,
    		@ModelAttribute("announce") Announcement announce,
    		@ModelAttribute("badge") Badge badge) {
		model.addAttribute("all_announcements", as.findAll());
		model.addAttribute("all_feedback", fs.findAll());
		model.addAttribute("all_reports", rs.findAll());
				
		String email = principal.getName();
		model.addAttribute("currentUser", us.findByEmail(email));
        return "mod.jsp";
    }
	
	
	//Uploading a new Badge
	@PostMapping("/new/badge")
    public String badge(@Valid @ModelAttribute("badge") Badge badge,
			BindingResult res,
			@Valid @RequestParam("image") MultipartFile file,
			HttpSession session,
			HttpServletRequest request,
			Model model,
			Principal principal) throws Exception {
	   	bs.save(badge);
	    File newFile = fileService.createFile(file);
	    if (newFile != null) {
	    	newFile.setBadgefile(badge);
	    	fileUploadDao.save(newFile);
	    }
        return "redirect:/mod";
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
    public String feedReview(@PathVariable("id") Long id, Model model, Principal p) {
		Feedback feedback = fs.findFeedbackById(id);
		
		// Grabs the feedback ID and the current signed in user to mark the feedback as reviewed
		fs.updateReview(feedback, us.findByEmail(p.getName()));
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
