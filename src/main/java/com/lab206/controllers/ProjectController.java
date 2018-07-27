package com.lab206.controllers;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lab206.models.File;
import com.lab206.models.Project;
import com.lab206.models.User;
import com.lab206.repositories.FileUploadDAO;
import com.lab206.services.ProjectService;
import com.lab206.services.UserService;

@Controller
public class ProjectController {
	
	@Autowired
	private FileUploadDAO fileUploadDao;
	private ProjectService ps;
	private UserService us;
	
	public ProjectController(ProjectService ps, UserService us) {
		this.ps=ps;
		this.us=us;
	}
	
	@PostMapping("/project/create")
	public String createProject(@RequestParam(value="about") String about,
				Model model,
				@Valid @RequestParam MultipartFile thumbnail,
				HttpSession session,
				HttpServletRequest request,
				Principal principal)
						throws Exception {
	  	Project project = new Project();
	  	project.setAbout(about);
		User currentUser = us.findByEmail(principal.getName());
		Long id = currentUser.getId();
		project.setProjectCreator(currentUser);
		ps.saveProject(project);
		if(!thumbnail.isEmpty()) {
			if(!thumbnail.getOriginalFilename().isEmpty()) {
				if(thumbnail.getOriginalFilename().contains(".jpg") 
						|| thumbnail.getOriginalFilename().contains(".gif") 
						|| thumbnail.getOriginalFilename().contains(".png")) {
	    		File uploadedFile = new File();
	            uploadedFile.setFileName(thumbnail.getOriginalFilename());
	            uploadedFile.setData(thumbnail.getBytes());
	    		uploadedFile.setProject(project);
	            fileUploadDao.save(uploadedFile);
				} else {
					return "redirect:/profile/"+id; 
			}
		}      
	}
		return "redirect:/profile/"+id; 
  }
	@PostMapping("/project/{id}/update")
	public String updateProject(@PathVariable("id") Long id,
			@Valid @RequestParam MultipartFile thumbnail,
			@RequestParam(value="about")String about) throws Exception {
		Project proj = ps.findProjectById(id);
		if(!thumbnail.isEmpty()) {
			if (proj.getThumbnail() != null) {
				fileUploadDao.delete(proj.getThumbnail().getId());
		
			}
			if(!thumbnail.getOriginalFilename().isEmpty()) {
				if(thumbnail.getOriginalFilename().contains(".jpg") 
						|| thumbnail.getOriginalFilename().contains(".gif") 
						|| thumbnail.getOriginalFilename().contains(".png")) {
	    		File uploadedFile = new File();
	            uploadedFile.setFileName(thumbnail.getOriginalFilename());
	            uploadedFile.setData(thumbnail.getBytes());
	    		uploadedFile.setProject(proj);
	            fileUploadDao.save(uploadedFile);
				}
			}
		}
		proj.setAbout(about);
		ps.saveProject(proj);
		return "redirect:/profile/"+ proj.getProjectCreator().getId();
	}
}
