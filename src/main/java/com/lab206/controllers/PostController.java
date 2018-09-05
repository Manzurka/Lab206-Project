package com.lab206.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
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
import com.lab206.services.AnnouncementService;
import com.lab206.services.CommentService;
import com.lab206.services.FileService;
import com.lab206.services.PostService;
import com.lab206.services.QuicklinkService;
import com.lab206.services.TagService;
import com.lab206.services.UserService;

@Controller
public class PostController {
	@Autowired
    private FileUploadDAO fileUploadDao;
	private PostService ps;
	private TagService ts;
	private UserService us;
	private AnnouncementService as;
	private QuicklinkService qs;
	private CommentService cs;
	private FileService fs;
	
	public PostController(PostService ps,
			TagService ts,
			UserService us,
			AnnouncementService as,
			QuicklinkService qs,
			CommentService cs,
			FileService fs){
		this.ps = ps;
		this.ts = ts;
		this.us = us;
		this.as = as;
		this.qs = qs;
		this.cs = cs;
		this.fs = fs;
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
			model.addAttribute("announcements", as.findAll());
			model.addAttribute("quicklinks", qs.findAll());
			model.addAttribute("users", us.findByPoints());
			return "dashboard.jsp";
		}
		List<Tag> tags = ts.findTagsBySubject(course, language, subjects);
		newPost.setTags(tags);
		newPost.setAuthor(currentUser);
		ps.createPost(newPost);
		us.increasePoints(currentUser, 1);
		ps.setPostAuthor(currentUser, ps.savePost(newPost));
		for (MultipartFile aFile : file){
    		if( aFile.getBytes() != null && aFile.getBytes().length>0) {
    			if (!aFile.getOriginalFilename().isEmpty()) {
    				File uploadedFile = new File();
	                uploadedFile.setFileName(aFile.getOriginalFilename());
	                uploadedFile.setData(aFile.getBytes());
	                uploadedFile.setPost4file(newPost);
	                fileUploadDao.save(uploadedFile);
    			} else {
    				model.addAttribute("posting", true);
    				model.addAttribute("filemessage", "Upload correct file type. Only gif, png, jpg are permitted");
    				model.addAttribute("currentUser", currentUser);
    				model.addAttribute("posts", ps.allPostsNew());
    				model.addAttribute("announcements", as.findAll());
    				model.addAttribute("quicklinks", qs.findAll());
    				model.addAttribute("users", us.findByPoints());
    				return "dashboard.jsp";
    			}
    		}
		}
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/post/{id}/show")
	public String showPost(@PathVariable("id") Long id,
			@ModelAttribute("newComment") Comment newComment,
			Principal principal,
			Model model) {
		User currentUser = us.findByEmail(principal.getName());
		Post post = ps.findPostById(id);
		System.out.println(post.getAttachments());
		String[] languages = new String[]{"C++", "C#", "CSS", "HTML", "Java", "JavaScript", "Perl", "PHP", "Python", "Ruby"};
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("post", post);
		model.addAttribute("announcements", as.findAll());
		model.addAttribute("quicklinks", qs.findAll());
		model.addAttribute("users", us.findByPoints());
		model.addAttribute("languages", languages);
		return "post.jsp";
	}
	
	@RequestMapping("/post/{id}/delete")
	public String deletePost(@PathVariable("id") Long id) {
		us.decreasePoints(ps.findPostById(id).getAuthor(), 1);
		ps.deletePost(id);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/post/{id}/edit")
	public String updatePost(@PathVariable("id") Long id, 
			@Valid @ModelAttribute("post") Post post, 
			BindingResult result,
			@RequestParam(value = "currentCourse", required = false) String course,
			@RequestParam(value = "currentLanguage") String language,
			@RequestParam(value = "tag1") String tag1,
			@RequestParam(value = "tag2") String tag2,
			@RequestParam(value = "tag3") String tag3,
			@Valid @RequestParam(value = "file1") MultipartFile file1,
			@Valid @RequestParam(value = "file2") MultipartFile file2,
			@Valid @RequestParam(value = "file3") MultipartFile file3,
			@Valid @RequestParam(value = "file4") MultipartFile file4,
			@Valid @RequestParam(value = "file5") MultipartFile file5,
            HttpServletRequest request,
			Principal principal,
			Model model) throws Exception {
		if (result.hasErrors()) {
			return "dashboard.jsp";
		}
		User author = us.findByEmail(principal.getName());
		List<MultipartFile> files = Arrays.asList(file1, file2, file3, file4, file5);
		List<String> subjects = Arrays.asList(tag1, tag2, tag3);
		List<Tag> tags = ts.findTagsBySubject(course, language, subjects);
		List<Tag> tags_reversed = new ArrayList<Tag>();
		for (int i = tags.size() - 1; i >= 0; i--) {
			tags_reversed.add(tags.get(i));
		}
		post.setTags(tags_reversed);
		for (MultipartFile file : files) {
			System.out.println(file);
		}
		ps.updatePost(post, author);
		// edit file upload stuff
		for (MultipartFile aFile : files){
    		if( aFile.getBytes() != null && aFile.getBytes().length>0) {
    			if (!aFile.getOriginalFilename().isEmpty()) {
    				File uploadedFile = new File();
	                uploadedFile.setFileName(aFile.getOriginalFilename());
	                uploadedFile.setData(aFile.getBytes());
	                uploadedFile.setPost4file(post);
	                fileUploadDao.save(uploadedFile);
    			} else {
    				model.addAttribute("posting", true);
    				model.addAttribute("filemessage", "Upload correct file type. Only gif, png, jpg are permitted");
    				model.addAttribute("currentUser", author);
    				model.addAttribute("posts", ps.allPostsNew());
    				model.addAttribute("announcements", as.findAll());
    				model.addAttribute("quicklinks", qs.findAll());
    				model.addAttribute("users", us.findByPoints());
    				return "dashboard.jsp";
    			}
    		}
		}
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/showFile/{postid}/{fileId}/delete")
	public String deleteFile(@PathVariable("postid") Long postId, @PathVariable("fileId") Long fileId) {
		// All credit to noahendr@ 
		fs.deleteFile(fileId);
		return "redirect:/post/" + postId + "/show";
	}
  
  @RequestMapping("/post/{id}/like")
  public String likePost(@PathVariable("id") Long id, Principal principal) {
    User user = us.findByEmail(principal.getName());
    Post post = ps.findPostById(id);
    ps.likePost(user, post);
    us.increasePoints(post.getAuthor(), 1);
    return "redirect:/post/" + id + "/show";
  }
  
  @RequestMapping("/post/{id}/unlike")
  public String unlikePost(@PathVariable("id") Long id, Principal principal) {
    User user = us.findByEmail(principal.getName());
    Post post = ps.findPostById(id);
    ps.unlikePost(user, post);
    us.decreasePoints(post.getAuthor(), 1);
    return "redirect:/post/" + id + "/show";
  }
  
  @RequestMapping("/post/{id}/answer/{commentId}")
  public String answerPost(@PathVariable("id") Long id,
		  @PathVariable("commentId") Long commentId,
		  Principal principal) {
	  Comment comment = cs.findById(commentId);
	  Post post = ps.findPostById(id);
	  ps.markAnswer(comment, post);
	  us.increasePoints(comment.getCommenter(), 3);
	  return "redirect:/post/" + id + "/show";
  }

}
