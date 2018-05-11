package com.mcajayon.license.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcajayon.license.models.Person;
import com.mcajayon.license.services.PersonService;

@Controller
public class Persons {

	private final PersonService personService;
	public Persons(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("persons",personService.allPerson());
		return "index.jsp";
	}
	
	@RequestMapping("/person/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "dashboard.jsp";
	}
	
	@PostMapping("/person/new")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "dashboard.jsp";
		} else {
			personService.addPerson(person);
			return "redirect:/";
		}
	}
}