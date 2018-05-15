package com.mcajayon.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mcajayon.dojooverflow.models.Answer;
import com.mcajayon.dojooverflow.models.Question;
import com.mcajayon.dojooverflow.models.Tag;
import com.mcajayon.dojooverflow.services.QuestionService;
import com.mcajayon.dojooverflow.services.TagService;

@Controller
public class Questions {

	private final QuestionService questionService;
	private final TagService tagService;
	
	public Questions(QuestionService questionService, TagService tagService) {
		this.questionService = questionService;
		this.tagService = tagService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("questions", questionService.allQuestions());
		return "index.jsp";
	}
	
	@RequestMapping("/question/new")
	public String newQuestion(@ModelAttribute("q") Question q) {
		return "newquestion.jsp";
	}
	
	@PostMapping("/question/create")
	public String createQuestion(@Valid @ModelAttribute("q") Question q, BindingResult result, @RequestParam("tagA") String tagA, @RequestParam("tagB") String tagB, @RequestParam("tagC") String tagC) {
		if (result.hasErrors()) {
			return "newquestion.jsp";
		}
		Question question = questionService.createQuestion(q);
		List<String> tagList = new ArrayList<String>(Arrays.asList(tagA,tagB,tagC));
		List<Tag> tags = new ArrayList<Tag>();
		for (int i=0; i<tagList.size(); i++) {
			if (tagService.findTagBySubject(tagList.get(i)) != null) {
				tags.add(tagService.findTagBySubject(tagList.get(i)));
			}
		}
		question.setTags(tags);
		questionService.createQuestion(question);
		return "redirect:/question/display/" + question.getId();
	}
	
	@RequestMapping("/question/display/{id}")
	public String displayQuestion(@ModelAttribute("a") Answer a, @PathVariable("id") Long id, Model model) {
		model.addAttribute("question", questionService.findById(id));
		return "displayquestion.jsp";
	}
}
