package com.lab206.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lab206.models.Report;
import com.lab206.services.PostService;
import com.lab206.services.ReportService;
import com.lab206.services.UserService;

@Controller
public class ReportController {
	
	private ReportService rs;
	private UserService us;
	private PostService ps;
	
	public ReportController(ReportService rs, UserService us, PostService ps) {
		this.rs = rs;
		this.us = us;
		this.ps = ps;
	}
		
	@RequestMapping("/create/report")
	public String createReport(@ModelAttribute("reportFrom") Report report, Principal p, HttpServletRequest request) {
		report.setReporter(us.findByEmail(p.getName()));
		report.setReviewed(false);
		
		// Is received from an hidden input in script.js
		String postID = request.getParameter("post_id");
		
		// Converting the String postID to a Long data type
		long result = Integer.parseInt(postID);
		
		report.setReported(us.findByEmail(ps.findPostById(result).getAuthor().getEmail()));
	
		System.out.println("Reporter: " + report.getReporter());
		System.out.println("Reported: " + report.getReported());
		
		rs.creatingReport(report);
				
		return "redirect:/dashboard";
	}

}
