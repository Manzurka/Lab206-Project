package com.lab206.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab206.models.Badge;
import com.lab206.models.BadgeRequest;
import com.lab206.models.Comment;
import com.lab206.models.Post;
import com.lab206.models.Quicklink;
import com.lab206.models.User;
import com.lab206.repositories.BadgeRequestRepo;
import com.lab206.services.AnnouncementService;
import com.lab206.services.BadgeService;
import com.lab206.services.PaginationService;
import com.lab206.services.QuicklinkService;
import com.lab206.services.UserService;

@Controller
public class PaginationController {
	
	private PaginationService ps;
	private UserService us;
	private AnnouncementService as;
	private QuicklinkService qs;
	private BadgeService bs;
	private BadgeRequestRepo brr;
	
	public PaginationController(PaginationService ps, UserService us, AnnouncementService as, QuicklinkService qs, BadgeService bs, BadgeRequestRepo brr) {
		this.ps = ps;
		this.us = us;
		this.as = as;
		this.qs = qs;
		this.bs = bs;
		this.brr = brr;
	}
	
	@RequestMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(@ModelAttribute("newPost") Post newPost,
		    @ModelAttribute("quicklink") Quicklink quicklink,
		    @PathVariable("pageNumber") int pageNumber,
		    Model model,
		    Principal principal) {
		
		// If the page number is equal to or less than 0, redirect to the page 1
		if (pageNumber <= 0) return "redirect:1";
		
	    Page<Post> posts = ps.postPerPage(pageNumber - 1);
	    
	    //Current signed in user
	    User currentUser = us.findByEmail(principal.getName());
	    
	    // total number of pages that we have
	    int totalPages = posts.getTotalPages();
	    String[] languages = new String[]{"C++", "C#", "CSS", "HTML", "Java", "JavaScript", "Perl", "PHP", "Python", "Ruby"};
	    model.addAttribute("pageNumber", pageNumber);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("posts", posts);
	    model.addAttribute("currentUser", currentUser);
	    model.addAttribute("announcements", as.findAll());
		model.addAttribute("quicklinks", qs.findAll());
		model.addAttribute("users", us.findByPoints());
		model.addAttribute("badges", bs.findAll());
		model.addAttribute("languages", languages);
		
	    return "dashboard.jsp";
	}

}
