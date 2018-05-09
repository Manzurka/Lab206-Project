package com.mcajayon.languagesreloaded.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcajayon.languagesreloaded.models.Language;
import com.mcajayon.languagesreloaded.services.LanguageService;

@Controller
public class Languages {

	private final LanguageService languageService;
	public Languages(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/languages")
	public String languages(@ModelAttribute("language") Language language, Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages",languages);
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String createLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			languageService.addLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/{id}")
	public String findLanguageById(@PathVariable("id") Long id, Model model) {
		model.addAttribute("language", languageService.findLanguageById(id));
		return "details.jsp";
	}
	
	@RequestMapping("languages/edit/{id}")
	public String editLanguage(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguageById(id);
		if (language != null) {
			System.out.println("hello");
			model.addAttribute("language", language);
			return "edit.jsp";
		} else {
			return "redirect:/languages";
		}
	}
	
	@PostMapping("/languages/edit/{id}")
	public String updateLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="/languages/delete/{id}")
	public String destroyLanguage(@PathVariable("id") Long id) {
		languageService.destroyLanguage(id);
		return "redirect:/languages";
	}
}