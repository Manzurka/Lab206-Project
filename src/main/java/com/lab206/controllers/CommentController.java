package com.lab206.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab206.models.Comment;
import com.lab206.models.Post;
import com.lab206.models.User;
import com.lab206.services.CommentService;
import com.lab206.services.PostService;
import com.lab206.services.UserService;

@Controller
public class CommentController {
	
	private CommentService cs;
	private PostService ps;
	private UserService us;
	
	public CommentController(CommentService cs,
			PostService ps,
			UserService us) {
		this.cs = cs;
		this.ps = ps;
		this.us = us;
	}
	
	@PostMapping("/comment/create")
	public String createComment(@RequestParam(value = "postId") Long postId,
			@Valid @ModelAttribute("newComment") Comment comment,
			BindingResult res,
			Principal principal) {
		if (res.hasErrors()) {
			return "redirect:/post/" + postId + "/show";
		}
		User currentUser = us.findByEmail(principal.getName());
		Post post = ps.findPostById(postId);
		cs.createComment(comment, post, currentUser);
		us.increasePoints(currentUser, 1);
		return "redirect:/post/" + postId + "/show";
	}
	
	@RequestMapping("/comment/{id}/like")
	public String likeComment(@PathVariable("id") Long id,
			Principal principal) {
		User currentUser = us.findByEmail(principal.getName());
		Comment comment = cs.findById(id);
		cs.likeComment(comment, currentUser);
		us.increasePoints(comment.getCommenter(), 1);
		return "redirect:/post/" + comment.getPost().getId() + "/show";
	}
	
	@RequestMapping("/comment/{id}/unlike")
	public String unlikeComment(@PathVariable("id") Long id,
			Principal principal) {
		User currentUser = us.findByEmail(principal.getName());
		Comment comment = cs.findById(id);
		cs.removeLikedComment(comment, currentUser);
		us.decreasePoints(comment.getCommenter(), 1);
		return "redirect:/post/" + comment.getPost().getId() + "/show";
	}

}
