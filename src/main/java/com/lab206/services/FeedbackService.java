package com.lab206.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lab206.models.Feedback;
import com.lab206.repositories.FeedbackRepository;

@Service
public class FeedbackService {
	
	private final FeedbackRepository fr;
	
	public FeedbackService(FeedbackRepository fr) {
		this.fr = fr;
	}
	
	public List<Feedback> findAll() {
		return fr.findByOrderByIdDesc();
	}
	
	public Feedback findFeedbackById(Long id) {
		return fr.findById(id).get();
	}
	
	//Creating Feedback
	public void createFeedback(Feedback f) {
		fr.save(f);
	}
	
	// Update the Review status for Feedback
	public void updateReview(Feedback review) {
		review.setReviewed(true);
		fr.save(review);
	}

}
