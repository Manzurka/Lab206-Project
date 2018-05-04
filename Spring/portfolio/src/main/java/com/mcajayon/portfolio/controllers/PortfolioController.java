package com.mcajayon.portfolio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller

public class PortfolioController {
	@RequestMapping("/")
	public String index() {
		return "index.html";
	}
	
	@RequestMapping("/projects")
	public String projects() {
		return "projects.html";
	}
	
	@RequestMapping("/me")
	public String me() {
		return "me.html";
	}
}
