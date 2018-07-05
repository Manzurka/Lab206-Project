package com.lab206.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab206.models.Comment;
import com.lab206.models.Post;
import com.lab206.services.CommentService;
import com.lab206.services.PostService;
import com.lab206.services.UserService;

@RestController
@RequestMapping("/post")
public class PostRestController {
	
	private PostService ps;
	private CommentService cs;
	private UserService us;
	
	public PostRestController(PostService ps,
			CommentService cs,
			UserService us) {
		this.ps = ps;
		this.cs = cs;
		this.us = us;
	}

	@RequestMapping("/show/{id}")
	public Post showPost(@PathVariable("id") Long id) {
		return ps.findPostById(id);
	}
	
	@RequestMapping("/{id}/comments")
	public List<Comment> getCommentsByPost(@PathVariable("id") Long id) {
		return cs.findByPostDesc(ps.findPostById(id));
	}
}
