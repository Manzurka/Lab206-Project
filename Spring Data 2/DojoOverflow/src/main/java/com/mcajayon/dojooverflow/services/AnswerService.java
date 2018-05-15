package com.mcajayon.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mcajayon.dojooverflow.models.Answer;
import com.mcajayon.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {

	private final AnswerRepository answerRep;
	public AnswerService(AnswerRepository answerRep) {
		this.answerRep = answerRep;
	}
	
	public List<Answer> allAnswers() {
		return answerRep.findAll();
	}
	
	public Answer createAnswer(Answer a) {
		return answerRep.save(a);
	}
}