package com.lab206.controllers;


import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lab206.models.Project;
import com.lab206.services.ProjectService;

@Controller
public class ProjectController {
	
	private ProjectService projServ;
	
	public ProjectController(ProjectService projServ) {
		this.projServ = projServ;
	}
	
	@PostMapping("/project/create")
	public String newProject(@Valid @ModelAttribute("newProject") Project newProject,
			Principal principal, Model model) {
			projServ.newProject(newProject);
		return "redirect: /profile/{id}";
	}

}
