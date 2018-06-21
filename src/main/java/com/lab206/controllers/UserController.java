package com.lab206.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lab206.models.Comment;
import com.lab206.models.File;
import com.lab206.models.Post;
import com.lab206.models.User;
import com.lab206.repositories.FileUploadDAO;
import com.lab206.services.PostService;
import com.lab206.services.UserService;
import com.lab206.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
    private FileUploadDAO fileUploadDao;

	private UserService us;
	private PostService ps;
	private UserValidator uv;
	
	public UserController(UserService us,
			PostService ps,
			UserValidator uv) {
		this.us = us;
		this.ps = ps;
		this.uv = uv;
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
			HttpSession session,
			HttpServletRequest request,
			Model model) {
		uv.validate(newUser, res);
		if (res.hasErrors()) {
			return "register.jsp";
		}
		us.saveWithUserRole(newUser);
		try {
			request.login(newUser.getEmail(),newUser.getPasswordConfirmation());
			return "redirect:/dashboard";
		} catch (ServletException e) {
			System.out.println("IT DID NOT WORK :<");
		}
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value = {"/", "/dashboard"})
	public String dashboard(@ModelAttribute("newPost") Post newPost, 
      @ModelAttribute("newComment") Comment newComment,
			@ModelAttribute("user") User user,
			Principal principal,
			Model model) {
		User currentUser = us.findByEmail(principal.getName());
		model.addAttribute("posts", ps.allPostsNew());
		model.addAttribute("currentUser", currentUser);
		
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
		System.out.println(passwordConfirmation);
		System.out.println(currentUser.getPassword());
		String userPassword = currentUser.getPassword();
		if (encoder.matches(passwordConfirmation, userPassword)) {
			currentUser.setFirstName(firstName);
			currentUser.setLastName(lastName);
			currentUser.setEmail(email);
			currentUser.setAbout(about);
			
			if (!avatar.isEmpty()) {
				System.out.println(avatar.getName());
				if (currentUser.getFile() != null) {
					fileUploadDao.delete(currentUser.getFile().getId());
					System.out.println("done");
				}
				
		 //file upload
			
//				for (MultipartFile aFile : avatar) {
					if( !avatar.getOriginalFilename().isEmpty()) {
	        		File uploadedFile = new File();
	                uploadedFile.setFileName(avatar.getOriginalFilename());
	                uploadedFile.setData(avatar.getBytes());
	                uploadedFile.setUser4avatar(currentUser);
	                fileUploadDao.save(uploadedFile);
        			}
//				}
				us.save(currentUser);
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
			return "dashboard.jsp";
		} else {
			return "dashboard.jsp";
		}
		}
	
	@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
	  public void showImage(@RequestParam("id") Long userId, HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException{
		Long imageId = us.findById(userId).getFile().getId();
		File item = fileUploadDao.findById(imageId).get();      
	    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    response.getOutputStream().write(item.getData());
	    response.getOutputStream().close();
	}
}
