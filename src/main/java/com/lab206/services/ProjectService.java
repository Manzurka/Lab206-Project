package com.lab206.services;

import org.springframework.stereotype.Service;

import com.lab206.models.Project;
import com.lab206.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	private ProjectRepository pr;
	
	public ProjectService(ProjectRepository pr) {
		this.pr = pr;
	}
	
	public Project saveProject(Project project) {
		return pr.save(project);
	}
	
	public Project findProjectById(Long id) {
		return pr.findById(id).get();
	}
}
