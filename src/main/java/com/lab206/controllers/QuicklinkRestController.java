package com.lab206.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab206.models.Quicklink;
import com.lab206.models.Tag;
import com.lab206.services.QuicklinkService;
import com.lab206.services.TagService;

@RestController
public class QuicklinkRestController {
	
	private QuicklinkService qs;
	private TagService ts;
	
	public QuicklinkRestController(QuicklinkService qs,
			TagService ts) {
		this.qs = qs;
		this.ts = ts;
	}
	
	@RequestMapping("/quicklink/filter/{language}")
	public List<Quicklink> filterQuicklinks(@PathVariable("language") String language) {
		if (language.equals("C")) {
			Tag cTag = ts.findTagBySubject("c#");
			return qs.findByTag(cTag);
		}
		Tag tag = ts.findTagBySubject(language.toLowerCase());
		return qs.findByTag(tag);
	}

}
