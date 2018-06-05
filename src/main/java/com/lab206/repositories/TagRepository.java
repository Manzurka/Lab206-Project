package com.lab206.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lab206.models.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {
	
	List<Tag> findAll();
	Tag findBySubject(String name);
	
}	
