package com.lab206.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lab206.models.Post;

public interface PostRepository extends CrudRepository<Post, Long>{

	List<Post> findAll();
	
	@Query("SELECT p FROM Post p ORDER BY p.createdAt DESC")
	List<Post> findAllNew();
	
	@Query("SELECT p FROM Post p WHERE p.title LIKE %?1% OR p.content LIKE %?1%")
	List<Post> findByContentOrTitleContaining(String keyword);
	
}
