package com.mcajayon.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller

public class CounterController {
	
	int counter = 0;
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		counter++;
		System.out.println("Counter " + counter);
		session.setAttribute("count", counter);
		Integer count = (Integer) session.getAttribute("count");
		System.out.println("count " + count);
		count++;
		System.out.println("Count increasing ");
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(Model model) {
		model.addAttribute("total", counter);
		return "counter.jsp";
	}
}
