package com.lab206.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lab206.models.Post;
import com.lab206.models.User;

public interface PostRepository extends CrudRepository<Post, Long>{

	List<Post> findAll();
	
	@Query("SELECT p FROM Post p ORDER BY p.createdAt DESC")
	List<Post> findAllNew();
	
	@Query("SELECT p FROM Post p WHERE user_id <= ?1 ORDER BY p.createdAt DESC")
	List<Post> findRecentPosts(User user);

	
	
	
}
