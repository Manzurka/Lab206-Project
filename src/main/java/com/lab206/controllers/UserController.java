package com.lab206.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/")
	public String dashboard() {
		return "dashboard.jsp";
	}
}
