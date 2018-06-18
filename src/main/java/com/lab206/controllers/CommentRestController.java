package com.lab206.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lab206.models.Comment;
import com.lab206.models.Post;
import com.lab206.models.User;
import com.lab206.services.CommentService;
import com.lab206.services.PostService;
import com.lab206.services.UserService;

@RestController
@RequestMapping("/comment")
public class CommentRestController {

	private CommentService cs;
	private PostService ps;
	private UserService us;
	
	public CommentRestController(CommentService cs,
			PostService ps,
			UserService us) {
		this.cs = cs;
		this.ps = ps;
		this.us = us;
	}
	
	@PostMapping("/create")
	public Comment createComment(@Valid @ModelAttribute("newComment") Comment newComment,
			BindingResult res,
			@RequestParam(value = "postId") Long postId,
			Principal principal) {
		User currentUser = us.findByEmail(principal.getName());
		if (res.hasErrors()) {
			System.out.println(res);
			return null;
		}
		Post post = ps.findPostById(postId);
		us.increasePoints(currentUser);
		return cs.createComment(newComment, post, currentUser);
	}
	
	@RequestMapping("/get/{id}")
	public Comment getComment (@PathVariable("id") Long id) {
		return cs.findById(id);
	}
}
