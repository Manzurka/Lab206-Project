package com.mcajayon.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mcajayon.events.models.Comment;
import com.mcajayon.events.models.Event;

@Repository
public  interface CommentRepository extends CrudRepository<Comment, Long>{
	List<Comment>findAll();

	void save(Event event);
}