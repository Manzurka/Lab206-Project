package com.lab206.controllers;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lab206.models.File;
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
	
	@RequestMapping("/project/create")
	public String saveProject(@Valid Project project, 
			BindingResult res, 
			@RequestParam MultipartFile thumbnail) throws IOException{
			
			if( !thumbnail.getOriginalFilename().isEmpty()) {
			File uploadedFile = new File();
	        uploadedFile.setFileName(thumbnail.getOriginalFilename());
	        uploadedFile.setData(thumbnail.getBytes());
	        uploadedFile.setProject(project);
	        System.out.println("potato");
	        fileUploadDao.save(uploadedFile);
			}
			ps.saveProject(project);
			return "redirect:/profile/1";
	}
}
