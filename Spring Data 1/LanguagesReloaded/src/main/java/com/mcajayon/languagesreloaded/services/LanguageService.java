package com.mcajayon.languagesreloaded.services;

import java.util.List;
import java.util.Optional;
import com.mcajayon.languagesreloaded.models.Language;
import com.mcajayon.languagesreloaded.repositories.LanguageRepository;

import org.springframework.stereotype.Service;

@Service
public class LanguageService {
	
	private LanguageRepository languageRepository;
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}
	
	public void addLanguage(Language language) {
		languageRepository.save(language);
	}
	
	public void destroyLanguage(Long id) {
		languageRepository.deleteById(id);
	}
	
	public Language findLanguageById(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	
	public void updateLanguage(Language language) {
		languageRepository.save(language);
	}
	
}