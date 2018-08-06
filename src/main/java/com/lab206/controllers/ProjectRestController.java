package com.lab206.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab206.models.Project;
import com.lab206.services.ProjectService;

@RestController
public class ProjectRestController {
	private ProjectService ps;
	
	public ProjectRestController(ProjectService ps) {
		this.ps = ps;
	}

	@RequestMapping("/project/get/{id}")
	public Project getProject(@PathVariable("id")Long id) {
		return ps.findProjectById(id);
	}
	
}
