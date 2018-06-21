package com.lab206.services;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab206.models.User;

@RestController
@RequestMapping("/user")
public class UserRestController {

	private UserService us;
	
	public UserRestController(UserService us) {
		this.us = us;
	}
	
	@RequestMapping("/get/{id}")
	public User getUser(@PathVariable("id") Long id) {
		return us.findById(id);
	}
}
