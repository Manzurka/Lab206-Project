package com.mcajayon.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String index(@ModelAttribute("error")String error) {
		return "index.jsp";
	}
	
	@RequestMapping(path="/", method=RequestMethod.POST)
	public String code(@RequestParam(value="code")String code, RedirectAttributes x) {
		if (code.equals("bushido")) {
			return "code.jsp";
		}
		x.addFlashAttribute("error", "You must train harder!");
		return "redirect:/";
	}
}