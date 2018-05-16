package com.mcajayon.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mcajayon.countries.repositories.CityRepository;
import com.mcajayon.countries.repositories.CountryRepository;
import com.mcajayon.countries.repositories.LanguageRepository;

@Service
public class ApiService {

	private final CityRepository cityRep;
	private final CountryRepository countryRep;
	private final LanguageRepository languageRep;
	
	public ApiService(CityRepository cityRep, CountryRepository countryRep, LanguageRepository languageRep) {
		this.cityRep = cityRep;
		this.countryRep = countryRep;
		this.languageRep = languageRep;
	}
	
//	public List<Object[]> findSloveneSpeakingCountries() {
//		return countryRep.findSloveneSpeakingCountries();
//	}
//	
//	public List<Object[]> countCities() {
//		return countryRep.countCities();
//	}
//	
//	public List<Object[]> citiesInMexico() {
//		return cityRep.citiesInMexico();
//	}
//	
//	public List<Object[]> languagesByPercentage() {
//		return languageRep.languagesByPercentage();
//	}
//	
//	public List<Object[]> countriesBySurfaceArea() {
//		return countryRep.countriesBySurfaceArea();
//	}
//	
//	public List<Object[]> countriesWithConMonarchy() {
//		return countryRep.countriesWithConMonarchy();
//	}
//	
//	public List<Object[]> findCitiesInArgentina() {
//		return cityRep.findCitiesInArgentina();
//	}
//	
	public List<Object[]> countriesInRegion() {
		return countryRep.countriesInRegion();
	}
}