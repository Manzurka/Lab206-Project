package com.lab206.services;

import org.springframework.stereotype.Service;

import com.lab206.models.Project;
import com.lab206.repositories.ProjectRepository;

@Service
public class ProjectService {
private ProjectRepository projRepo;
	
	public ProjectService(ProjectRepository projRepo) {
		this.projRepo = projRepo;
	}
	
	public void newProject(Project project) {
		projRepo.save(project);
	}

}
