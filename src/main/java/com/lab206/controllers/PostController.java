package com.lab206.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.lab206.models.Comment;
import com.lab206.models.File;
import com.lab206.models.Post;
import com.lab206.models.Tag;
import com.lab206.models.User;
import com.lab206.repositories.FileUploadDAO;
import com.lab206.services.PostService;
import com.lab206.services.TagService;
import com.lab206.services.UserService;

@Controller
public class PostController {
	@Autowired
    private FileUploadDAO fileUploadDao;
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
			@Valid @RequestParam MultipartFile[] file,
            HttpServletRequest request,
			Principal principal,
			Model model) throws Exception {
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
		
        	for (MultipartFile aFile : file){
        		if( !aFile.getOriginalFilename().isEmpty()) {
	        		File uploadedFile = new File();
	                uploadedFile.setFileName(aFile.getOriginalFilename());
	                uploadedFile.setData(aFile.getBytes());
	                uploadedFile.setPost4file(newPost);
	                fileUploadDao.save(uploadedFile);
        		}
        	}
		
		
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