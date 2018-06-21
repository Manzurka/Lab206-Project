package com.lab206.controllers;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab206.models.Comment;
import com.lab206.models.Post;
import com.lab206.models.Tag;
import com.lab206.models.User;
import com.lab206.services.PostService;
import com.lab206.services.TagService;
import com.lab206.services.UserService;

@Controller
public class PostController {
	
	private PostService ps;
	private TagService ts;
	private UserService us;
	
	public PostController(PostService ps,
			TagService ts,
			UserService us) {
		this.ps = ps;
		this.ts = ts;
		this.us = us;
	}

	@PostMapping("/post/create")
	public String createPost(@Valid @ModelAttribute("newPost") Post newPost,
			BindingResult res,
			@RequestParam(value = "course", required = false) String course,
			@RequestParam(value = "language") String language,
			@RequestParam(value = "tag1") String tag1,
			@RequestParam(value = "tag2") String tag2,
			@RequestParam(value = "tag3") String tag3,
			Principal principal,
			Model model) {
		User currentUser = us.findByEmail(principal.getName());
		List<String> subjects = Arrays.asList(tag1, tag2, tag3);
		if (res.hasErrors()) {
			model.addAttribute("posting", true);
			model.addAttribute("currentUser", currentUser);
			model.addAttribute("posts", ps.allPostsNew());
			return "dashboard.jsp";
		}
		List<Tag> tags = ts.findTagsBySubject(course, language, subjects);
		newPost.setTags(tags);
		newPost.setAuthor(currentUser);
		ps.createPost(newPost);
		us.increasePoints(currentUser);
		Post p = ps.savePost(newPost);
		User author = us.findByEmail(principal.getName());
		ps.setPostAuthor(author, p);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/post/{id}/delete")
	public String deletePost(@PathVariable("id") Long id) {
		ps.deletePost(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/post/{id}/edit")
	public String editPost(@ModelAttribute("editPost") Post post, @PathVariable("id") Long id, Principal principal, Model model) {
		User currentUser = us.findByEmail(principal.getName());
		System.out.println("testing");
		model.addAttribute("posts", ps.allPostsNew());
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("post", ps.findPostById(id));
		model.addAttribute("newPost", new Post());
		model.addAttribute("newComment", new Comment());
		model.addAttribute("editing", true);
		return "dashboard.jsp";
	}
	
	@PostMapping("/post/{id}/edit")
	public String updatePost(Principal principal, @PathVariable("id") Long id, @Valid @ModelAttribute("post") Post post, BindingResult result) {
		if (result.hasErrors()) {
			return "dashboard.jsp";
		}
		User author = us.findByEmail(principal.getName());
		ps.updatePost(post, author);
		return "redirect:/dashboard";
	}
}
