package com.lab206.controllers;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lab206.models.Comment;
import com.lab206.models.Feedback;
import com.lab206.models.File;
import com.lab206.models.Post;
import com.lab206.models.Project;
import com.lab206.models.Report;
import com.lab206.models.User;
import com.lab206.repositories.FileUploadDAO;
import com.lab206.services.AnnouncementService;
import com.lab206.services.CommentService;
import com.lab206.services.FileService;
import com.lab206.services.PostService;
import com.lab206.services.QuicklinkService;
import com.lab206.services.UserService;
import com.lab206.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
    private FileUploadDAO fileUploadDao;

	private UserService us;
	private PostService ps;
	private CommentService cs;
	private UserValidator uv;
	private AnnouncementService as;
	private QuicklinkService qs;
	private FileService fs;
	
	public UserController(UserService us,
			PostService ps, CommentService cs,
			UserValidator uv,
			AnnouncementService as,
			QuicklinkService qs,
			FileService fs) {
		this.us = us;
		this.ps = ps;
		this.uv = uv;
		this.cs = cs;
		this.qs = qs;
		this.as = as;
		this.fs = fs;
	}

	@RequestMapping("/login") 
	public String login(@ModelAttribute("user") User user,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			Model model){
		if(error != null) {
			model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
		}
		if(logout != null) {
			model.addAttribute("logoutMessage", "Logout Successful!");
		}
		return "login.jsp";
	}
	
	@RequestMapping("/user/new")
	public String newUser(@ModelAttribute("newUser") User newUser) {
		return "register.jsp";
	}
	
	@PostMapping("/user/create")
	public String createUser(@Valid @ModelAttribute("newUser") User newUser,
			BindingResult res,
			@Valid @RequestParam("avatar") MultipartFile file,
			HttpSession session,
			HttpServletRequest request,
			Model model) throws Exception {
		uv.validate(newUser, res);
		if (res.hasErrors()) {
			return "register.jsp";
		}
		us.saveWithUserRole(newUser);
		File newFile = fs.createFile(file);
		if (newFile == null) {
			return "redirect:/user/new";
		} else {
			newFile.setUser4avatar(newUser);
			fileUploadDao.save(newFile);
		}
		try {
			request.login(newUser.getEmail(),newUser.getPasswordConfirmation());
			return "redirect:/dashboard";
		} catch (ServletException e) {
			System.out.println("IT DID NOT WORK :<");
		}
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value = {"/", "/dashboard"})
	public String dashboard(@ModelAttribute("newPost") Post newPost, @ModelAttribute("editPost") Post editPost, 
      @ModelAttribute("newComment") Comment newComment,
			@ModelAttribute("user") User user,
			@ModelAttribute("feedb") Feedback feedback,
			@ModelAttribute("reportForm") Report report,
			Principal principal,
			Model model) {
		User currentUser = us.findByEmail(principal.getName());
		model.addAttribute("posts", ps.allPostsNew());
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("announcements", as.findAll());
		model.addAttribute("quicklinks", qs.findAll());
		model.addAttribute("users", us.findByPoints());
		return "dashboard.jsp";
	}
	
	@RequestMapping("/feedback")
	public String feedback(Principal principal,
                         Model model) {
		return "feedback.jsp";
	}
	
	
	@PostMapping("/user/edit")
	public String editUser(@Valid @ModelAttribute("user") User user,
			BindingResult res,
			@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "about") String about,
			@RequestParam(value = "passwordConfirmation") String passwordConfirmation,
			@Valid @RequestParam MultipartFile avatar,
			HttpSession session,
			HttpServletRequest request,
			Principal principal,
			Model model) throws Exception {
		uv.validate(user, res);
		User currentUser = us.findByEmail(principal.getName());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String userPassword = currentUser.getPassword();
		if (encoder.matches(passwordConfirmation, userPassword)) {
			currentUser.setFirstName(firstName);
			currentUser.setLastName(lastName);
			currentUser.setEmail(email);
			currentUser.setAbout(about);
			File newFile = fs.createFile(avatar);
			if (currentUser.getFile() != null && newFile != null) {
				fileUploadDao.delete(currentUser.getFile().getId());
				newFile.setUser4avatar(currentUser);
				fileUploadDao.save(newFile);
			} else {
				model.addAttribute("editing", true);
				model.addAttribute("filemessage", "Upload gif, jpg, png only");
				model.addAttribute("currentUser", currentUser);
				model.addAttribute("posts", ps.allPostsNew());
				model.addAttribute("announcements", as.findAll());
				model.addAttribute("quicklinks", qs.findAll());
				model.addAttribute("users", us.findByPoints());
				return "dashboard.jsp";
			}
			us.save(currentUser);
			try {
				request.login(user.getEmail(),user.getPasswordConfirmation());
				return "redirect:/dashboard";
			} catch (ServletException e) {
				System.out.println("IT DID NOT WORK :<");
			}
			return "redirect:/dashboard";
		}
		if (res.hasErrors()) {
			model.addAttribute("editing", true);
			model.addAttribute("currentUser", currentUser);
			model.addAttribute("posts", ps.allPostsNew());
			model.addAttribute("announcements", as.findAll());
			model.addAttribute("quicklinks", qs.findAll());
			model.addAttribute("users", us.findByPoints());
			return "dashboard.jsp";
		} else {
			return "dashboard.jsp";
		}
	}
	

	@RequestMapping("/profile/{id}") 
	  public String dashboard(Principal principal, Model model, @ModelAttribute("newProject") Project newProject, @PathVariable("id") Long id) { 
	    User currentUser = us.findByEmail(principal.getName()); 
	    model.addAttribute("posts", ps.allPostsNew()); 
	    model.addAttribute("currentUser", currentUser); 
	    model.addAttribute("user", us.findById(id)); 
	    model.addAttribute("comments", cs.findAll());
	    return "profile.jsp"; 
	  }

}
