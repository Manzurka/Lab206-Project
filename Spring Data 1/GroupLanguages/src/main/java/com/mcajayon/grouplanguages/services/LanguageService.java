package com.mcajayon.grouplanguages.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.mcajayon.grouplanguages.controllers.Languages;
import com.mcajayon.grouplanguages.models.Language;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {
	
	private List<Language> languages = new ArrayList(Arrays.asList(
			new Language("Java", "James Gosling", "1.8"),
			new Language("Python", "Guido van Rossum", "3.6"),
			new Language("Javascript", "Brendon Eich", "1.9")
			));
	
	public List<Language> allLanguages() {
		return languages;
	}
	
	public Language findLanguages(int index) {
		if (index < languages.size()) {
			return languages.get(index);
		} else {
			return null;
		}
	}
	
	public void addLanguage(Language language) {
		languages.add(language);
	}
	
	public void updateLanguage(int id, Language language) {
		if (id < languages.size()) {
			languages.set(id, language);
		}
	}
	
	public void destroyLanguage(int id) {
		if (id < languages.size()) {
			languages.remove(id);
		}
	}
}
