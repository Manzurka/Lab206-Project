package com.lab206.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class UserController {
	
	@RequestMapping("/profile")
    public String profilePage() {
        return "profile.jsp";
    }

}

