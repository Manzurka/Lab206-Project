package com.lab206.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab206.models.Comment;
import com.lab206.models.Feedback;
import com.lab206.models.Post;
import com.lab206.services.CommentService;
import com.lab206.services.FeedbackService;
import com.lab206.services.PostService;
import com.lab206.services.UserService;

@RestController
@RequestMapping("/post")
public class PostRestController {
	
	private PostService ps;
	private CommentService cs;
	private UserService us;
	private FeedbackService fs;
	
	public PostRestController(PostService ps,
			CommentService cs,
			UserService us,
			FeedbackService fs) {
		this.ps = ps;
		this.cs = cs;
		this.us = us;
		this.fs = fs;
	}

	@RequestMapping("/show/{id}")
	public Post showPost(@PathVariable("id") Long id) {
		return ps.findPostById(id);
	}
	
	
	// Displaying feedback in moderator dashboard
	@RequestMapping("/feedbacks/{id}")
	public Feedback showFeedback(@PathVariable("id") Long id) {
		return fs.findFeedbackById(id);
	}
	
	@RequestMapping("/{id}/comments")
	public List<Long> getCommentsByPost(@PathVariable("id") Long id) {
		return cs.findByPostDesc(ps.findPostById(id));
	}
}
