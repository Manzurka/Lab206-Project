package com.mcajayon.license.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcajayon.license.models.License;
import com.mcajayon.license.services.LicenseService;
import com.mcajayon.license.services.PersonService;

@Controller
public class Licenses {
	
	private final LicenseService licenseService;
	private final PersonService personService;
	public Licenses(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
	
	@RequestMapping("/license/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		model.addAttribute("persons", personService.allPerson());
		model.addAttribute("l", String.format("%06d", 1 + licenseService.allLicense().size()));
		return "new.jsp";
	}
	
	@PostMapping("/license/new")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("persons", personService.allPerson());
			return "new.jsp";
		} 
		licenseService.addLicense(license);
		return "redirect:/";
		
	}
}