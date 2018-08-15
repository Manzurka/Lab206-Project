package com.lab206.controllers;

import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lab206.models.Post;
import com.lab206.services.PaginationService;

public class PaginationController {
	
	private PaginationService ps;
	
	public PaginationController(PaginationService ps) {
		this.ps = ps;
	}
	
	@RequestMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
	    Page<Post> posts = ps.ninjasPerPage(pageNumber - 1);
	    
	    // total number of pages that we have
	    int totalPages = posts.getTotalPages();
	    
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("posts", posts);
	    return "dashboard.jsp";
	}

}
