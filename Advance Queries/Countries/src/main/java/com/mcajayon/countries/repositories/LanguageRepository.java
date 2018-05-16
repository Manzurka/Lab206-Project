package com.mcajayon.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mcajayon.countries.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

	List<Language> findAll();
	
//	@Query("SELECT c.name, l.language, l.percentage FROM Language l JOIN l.country c WHERE l.percentage > 89 ORDER BY l.percentage DESC")
//	List<Object[]> languagesByPercentage();
}