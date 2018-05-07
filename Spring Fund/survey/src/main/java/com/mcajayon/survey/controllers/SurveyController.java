package com.mcajayon.survey.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String login (@RequestParam Map <String,String> requestParams, Model model) throws Exception {
		model.addAttribute("name", requestParams.get("name"));
		model.addAttribute("location", requestParams.get("location"));
		model.addAttribute("language", requestParams.get("language"));
		model.addAttribute("comment", requestParams.get("comment"));
		return "result.jsp";
	}
}