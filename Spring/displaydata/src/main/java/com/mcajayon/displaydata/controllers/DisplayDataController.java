package com.mcajayon.displaydata.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller

public class DisplayDataController {
	
	Date d = new Date();
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	SimpleDateFormat date = new SimpleDateFormat("EEEEE, d MMMM, yyyy");
	
	@RequestMapping("/date")
	public String date(Model model) {
		model.addAttribute("date", date.format(d));
		return "date.jsp";
	}
	
	SimpleDateFormat time = new SimpleDateFormat ("hh:mm a");
	
	@RequestMapping("/time")
	public String time(Model model) {
		model.addAttribute("time", time.format(d));
		return "time.jsp";
	}
}