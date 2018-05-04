package com.mcajayon.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CounterController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("counter") == null) {
			session.setAttribute("count", 0);
		}
		int count = (int) session.getAttribute("counter");
		count++;
		session.setAttribute("counter", count);
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		if (session.getAttribute("counter") == null) {
			session.setAttribute("count", 0);
		}
		return "counter.jsp";
	}
}
