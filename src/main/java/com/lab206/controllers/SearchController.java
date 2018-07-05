package com.lab206.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab206.models.Comment;
import com.lab206.models.Post;
import com.lab206.models.Tag;
import com.lab206.models.User;
import com.lab206.services.CommentService;
import com.lab206.services.PostService;
import com.lab206.services.TagService;
import com.lab206.services.UserService;

@Controller
public class SearchController {
	private final PostService ps;
	private final UserService us;
	private final CommentService cs;
	private final TagService ts;
	
	public SearchController(PostService ps, UserService us, CommentService cs,TagService ts) {
		this.ps = ps;
		this.us = us;
		this.cs = cs;
		this.ts = ts;
	}

	@RequestMapping("/search")
	public String searchResults(@RequestParam ("keyword") String keyword, 
			@RequestParam ("category") String category,
			@ModelAttribute("newPost") Post newPost,
			@ModelAttribute("editPost") Post editPost,
		    @ModelAttribute("newComment") Comment newComment,
		    @ModelAttribute("user") User user,
			Principal principal,
			Model model) {
			
			User currentUser = us.findByEmail(principal.getName());
			model.addAttribute("currentUser", currentUser);
			model.addAttribute("searchResults", true);
			
			if(category.equals("Posts")) {
				model.addAttribute("posts", ps.postsContaining(keyword));		
			}
			if (category.equals("Comments")) {
				model.addAttribute("comments", cs.commentsContaining(keyword));
			}
			if (category.equals("Users")) {
				model.addAttribute("users",us.findByName(keyword));
			}
			if (category.equals("Tags")) {
				Tag tag=ts.findTagBySubject(keyword);
				model.addAttribute("tags", tag.getPosts());
			}
			
			return "dashboard.jsp"; 
					
	}
	

}
