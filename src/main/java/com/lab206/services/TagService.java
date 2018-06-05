package com.lab206.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lab206.repositories.TagRepository;
import com.lab206.models.Tag;

@Service
public class TagService {
	
	private final TagRepository tr;
	
	public TagService(TagRepository tr) {
		this.tr = tr;
	}
	
	public List<Tag> allTags() {
		return tr.findAll();
	}
	
	public void createTag(Tag tag) {
		tr.save(tag);
	}

}
