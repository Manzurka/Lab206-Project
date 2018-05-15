package com.mcajayon.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mcajayon.dojooverflow.models.Tag;
import com.mcajayon.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	
	private final TagRepository tagRep;
	public TagService(TagRepository tagRep) {
		this.tagRep = tagRep;
	}
	
	public List<Tag> allTags() {
		return tagRep.findAll();
	}
	
	public void createTag(Tag tag) {
		tagRep.save(tag);
	}
	
	public Tag findTagBySubject(String subject) {
		Tag tag = tagRep.findBySubject(subject);
		if (tag != null) {
			return tag;
		}
		return tagRep.save(new Tag(subject));
	}

}
