package com.lab206.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lab206.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

	List<Tag> findAll();
	
	@Query("SELECT t FROM Tag t WHERE t.subject = ?1")
	Tag findBySubject(String subject);
}
