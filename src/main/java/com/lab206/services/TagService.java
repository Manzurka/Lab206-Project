package com.lab206.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.lab206.models.Tag;
import com.lab206.repositories.TagRepository;

@Service
public class TagService {

	private TagRepository tr;
	private List<String> userTagColors = Arrays.asList("bg-outer-space-light", "bg-shimmering-blush-light", "bg-neon-carrot-light", "bg-lapis-lazuli-light",
			"bg-amazon-light", "bg-antique-ruby-light", "bg-purple-navy-light", "bg-rajah-light", "bg-deep-space-sparkle-light", "bg-deep-tuscan-red-light", "bg-polished-pine-light");
	
	public TagService(TagRepository tr) {
		this.tr = tr;
	}
	
	public List<Tag> allTags() {
		return tr.findAll();
	}

	public Tag findTagBySubject(String sub) {
		return tr.findBySubject(sub);
	}
	
	public Tag createTag(Tag tag) {
		Random rand = new Random();
		int num = rand.nextInt(11);
		tag.setColor(userTagColors.get(num));
		return tr.save(tag);
	}
	
	public List<Tag> findTagsBySubject(String course, 
			String language,
			List<String> subjects) {
		List<Tag> tags = new ArrayList<Tag>();
		if (course != null) {
			tags.add(findTagBySubject("coursework"));
		}
		tags.add(findTagBySubject(language.toLowerCase()));
		for (String sub : subjects) {
			if (sub == "") {
				continue;
			} else {
				if (findTagBySubject(sub) != null) {
					tags.add(findTagBySubject(sub.toLowerCase().trim()));
				} else {
					Tag tag = new Tag(sub.toLowerCase().trim());
					tags.add(createTag(tag));
				}
			}
		}
		return tags;
	}
	
}
