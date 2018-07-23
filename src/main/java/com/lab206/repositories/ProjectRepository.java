package com.lab206.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lab206.models.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

	List<Project> findAll();
}
