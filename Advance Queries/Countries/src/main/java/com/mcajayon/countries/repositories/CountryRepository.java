package com.mcajayon.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mcajayon.countries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

	List<Country> findAll();
	
//	@Query("SELECT l.language, l.percentage, c.name FROM Country AS c JOIN c.languages AS l WHERE l.language = 'Slovene' ORDER BY l.percentage DESC")
//	List<Object[]> findSloveneSpeakingCountries();
//	
//	@Query("SELECT c.name, COUNT(city) FROM Country c JOIN c.cities city GROUP BY c.name ORDER BY COUNT(city) DESC")
//	List<Object[]> countCities();
//	
//	@Query("SELECT c.name, c.surfaceArea, c.population FROM Country c WHERE c.surfaceArea < 501 AND c.population > 100000")
//	List<Object[]> countriesBySurfaceArea();
//	
//	@Query("SELECT c.name, c.governmentForm, c.surfaceArea, c.lifeExpectancy, FROM Country c WHERE c.governmentForm = 'Constitutional Monarchy' AND c.surfaceArea > 200 AND c.lifeExpectancy > 75")
//	List<Object[]> countriesWithConMonarchy();
	
	@Query("SELECT c.region, COUNT(c) FROM Country c GROUP BY c.region ORDER BY COUNT(c) DESC")
	List<Object[]> countriesInRegion();
}



























//	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language = 'Slovene' ORDER BY l.percentage DESC")
//	List<Object[]> allCountriesWhereLanguageSlovene();
//	
//	@Query("SELECT c.name, c.region, COUNT(ci) FROM Country c JOIN c.cities ci GROUP BY c.name ORDER BY COUNT(ci) DESC")
//	List<Object[]> numberCitiesByCountry();
//	
//	@Query("SELECT c.name, c.surfaceArea, c.population FROM Country c WHERE c.surfaceArea < 501 and c.population > 100000")
//	List<Object[]> countriesSurfaceAreaBelow501PopGreater100000();
//	
//	@Query("SELECT c.name, c.governmentForm, c.surfaceArea, c.lifeExpectancy FROM Country c WHERE c.governmentForm = 'Constitutional Monarchy' AND c.surfaceArea > 200 AND c.lifeExpectancy > 75")
//	List<Object[]> countriesConstitutionalMonarchy();
//	
//	@Query("SELECT c.region, COUNT(c) FROM Country c GROUP BY c.region ORDER BY COUNT(c) DESC")
//	List<Object[]> summaryCountriesInRegion();
//}