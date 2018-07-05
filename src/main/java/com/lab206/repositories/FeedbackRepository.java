package com.lab206.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lab206.models.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
	
	List <Feedback> findByOrderByIdDesc();

}
