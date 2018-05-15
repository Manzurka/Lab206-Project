package com.mcajayon.dojooverflow.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mcajayon.dojooverflow.models.Answer;
import com.mcajayon.dojooverflow.services.AnswerService;
import com.mcajayon.dojooverflow.services.QuestionService;

@Controller
public class Answers {

	private final AnswerService answerService;
	private final QuestionService questionService;
	
	public Answers(AnswerService answerService, QuestionService questionService) {
		this.answerService = answerService;
		this.questionService = questionService;
	}
	
	@PostMapping("answer/create")
	public String createAnswer(@Valid @ModelAttribute("a")Answer a, BindingResult result, @RequestParam("question") Long q_id, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("question", questionService.findById(q_id));
			return "displayquestion.jsp";
		}
		a.setQuestion(questionService.findById(q_id));
		answerService.createAnswer(a);
		return "redirect:/question/display/" + q_id;
	}
}
