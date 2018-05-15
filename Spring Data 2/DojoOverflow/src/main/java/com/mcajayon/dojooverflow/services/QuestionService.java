package com.mcajayon.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mcajayon.dojooverflow.models.Question;
import com.mcajayon.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {

	private final QuestionRepository questionRep;
	public QuestionService(QuestionRepository questionRep) {
		this.questionRep = questionRep;
	}
	
	public List<Question> allQuestions() {
		return questionRep.findAll();
	}
	
	public Question createQuestion(Question q) {
		return questionRep.save(q);
	}
	
	public Question findById(Long id) {
		Optional<Question> q = questionRep.findById(id);
		if (q != null) {
			return q.get();
		}
		return null;
	}
}
