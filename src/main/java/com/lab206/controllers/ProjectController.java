package com.lab206.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lab206.models.Project;
import com.lab206.repositories.FileUploadDAO;
import com.lab206.services.ProjectService;
import com.lab206.services.UserService;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService ps;
	private FileUploadDAO fileUploadDao;
	private UserService us;
	
	public ProjectController(ProjectService ps,
			UserService us) {
		this.ps = ps;
		this.us = us;
	}
	
	@PostMapping("/project/create")
	public String createProject (@RequestParam ("about1") String about1,
				@RequestParam ("about2") String about2,
				@RequestParam ("about3") String about3,
				@RequestParam MultipartFile[] thumbnail) throws IOException{
				Project p1 = new Project();
				p1.setAbout(about1);
				ps.saveProject(p1);
				Project p2 = new Project();
				p1.setAbout(about2);
				ps.saveProject(p2);
				Project p3 = new Project();
				p1.setAbout(about3);
				ps.saveProject(p3);      
				return "redirect/profile/{id}"; 
				}

}
