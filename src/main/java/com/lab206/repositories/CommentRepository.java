package com.lab206.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lab206.models.Comment;
import com.lab206.models.Post;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

	List<Comment> findAll();
	
	@Query("SELECT c.id FROM Comment c WHERE c.post = ?1 ORDER BY c.createdAt DESC")
	List<Long> findByPostDesc(Post post);
}