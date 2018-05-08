package com.mcajayon.grouplanguages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcajayon.grouplanguages.models.Language;
import com.mcajayon.grouplanguages.services.LanguageService;

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
	public String findLanguages(Model model, @PathVariable("id") int id) {
		Language language = languageService.findLanguages(id);
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages",languages);
		model.addAttribute("language", language);
		return "details.jsp";
	}
	
	@RequestMapping("languages/edit/{id}")
	public String editLanguage(@PathVariable("id") int id, Model model) {
		Language language = languageService.findLanguages(id);
		if (language != null) {
			model.addAttribute("language", language);
			return "edit.jsp";
		} else {
			return "redirect:/languages";
		}
	}
	
	@PostMapping("/languages/edit/{id}")
	public String updateLanguage(@PathVariable("id") int id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			languageService.updateLanguage(id, language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="/languages/delete/{id}")
	public String destroyLanguage(@PathVariable("id") int id) {
		languageService.destroyLanguage(id);
		return "redirect:/languages";
	}
}
