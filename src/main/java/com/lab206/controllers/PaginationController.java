package com.lab206.controllers;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lab206.models.Comment;
import com.lab206.models.Post;
import com.lab206.models.User;
import com.lab206.services.AnnouncementService;
import com.lab206.services.PaginationService;
import com.lab206.services.QuicklinkService;
import com.lab206.services.UserService;

@Controller
public class PaginationController {
	
	private PaginationService ps;
	private UserService us;
	private AnnouncementService as;
	private QuicklinkService qs;
	
	public PaginationController(PaginationService ps, UserService us, AnnouncementService as, QuicklinkService qs) {
		this.ps = ps;
		this.us = us;
		this.as = as;
		this.qs = qs;
	}
	
	@RequestMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(@ModelAttribute("newPost") Post newPost,
			@ModelAttribute("editPost") Post editPost, 
		    @ModelAttribute("newComment") Comment newComment,
		    @ModelAttribute("user") User user,Model model,
		    @PathVariable("pageNumber") int pageNumber,
		    Principal principal) {
		
		// If the page number is equal to or less than 0, redirect to the page 1
		if (pageNumber <= 0) return "redirect:1";
		
	    Page<Post> posts = ps.postPerPage(pageNumber - 1);
	    
	    //Current signed in user
	    User currentUser = us.findByEmail(principal.getName());
	    
	    // total number of pages that we have
	    int totalPages = posts.getTotalPages();
	    
	    model.addAttribute("pageNumber", pageNumber);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("posts", posts);
	    model.addAttribute("currentUser", currentUser);
	    model.addAttribute("announcements", as.findAll());
		model.addAttribute("quicklinks", qs.findAll());
		model.addAttribute("users", us.findByPoints());
		
	    return "dashboard.jsp";
	}

}
