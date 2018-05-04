package com.mcajayon.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloHuman {
	
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false, defaultValue="Human") String searchQuery, Model model) {
		model.addAttribute("name", searchQuery);
		return "index.jsp";
	}
}