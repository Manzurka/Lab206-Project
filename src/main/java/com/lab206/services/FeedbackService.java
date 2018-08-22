package com.lab206.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lab206.models.Feedback;
import com.lab206.models.User;
import com.lab206.repositories.FeedbackRepository;

@Service
public class FeedbackService {
	
	private FeedbackRepository fr;
	
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
	
	// Update the Review status for Feedback and Grab the Moderators ID that approved the Feedback
	public void updateReview(Feedback review, User reviewer) {
		review.setFeedbackResolver(reviewer);
		review.setReviewed(true);
		fr.save(review);
	}

}
