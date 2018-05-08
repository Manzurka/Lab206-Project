package com.mcajayon.learningplatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LearningPlatformController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping("/m{chapter}/0553/{lessonNumber}")
	public String lesson(@PathVariable String chapter, @PathVariable String lessonNumber, Model model) {
		model.addAttribute("chapter", chapter);
		if (Integer.valueOf(chapter) == 38) {
			model.addAttribute("topic", "Fortran");
			if (Integer.valueOf(lessonNumber) == 0733) {
				model.addAttribute("content", "Setting up your servers");
			} 
			else if (Integer.valueOf(lessonNumber) == 0342) {
				model.addAttribute("content", "Punch Cards");
			}
			else if (Integer.valueOf(chapter) == 26) {
				model.addAttribute("content", "Advanced Fortran Intro");
				if (Integer.valueOf(lessonNumber) == 2342) {
					model.addAttribute("content", "Advanced Fortran Intro");
				}
			}
		}
		return "lesson.jsp";
	}
	
	@RequestMapping("/m{chapter}/0483/{assingmentNumber}")
	public String assignment(@PathVariable String chapter, @PathVariable String assignmentNumber, Model model) {
		model.addAttribute("chapter", chapter);
		if (Integer.valueOf(chapter) == 38) {
			model.addAttribute("topic", "Fortran");
			if (Integer.valueOf(assignmentNumber) == 0345) {
				model.addAttribute("content", "Coding Forms");
			}
			else if (Integer.valueOf(chapter) == 26) {
				model.addAttribute("topic", "Advanced");
				if (Integer.valueOf(assignmentNumber) == 2342) {
					model.addAttribute("content", "Fortran to Binary");
				}
			}
		}
		return "assignment.jsp";
	}
}