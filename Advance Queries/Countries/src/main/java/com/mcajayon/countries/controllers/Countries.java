package com.mcajayon.countries.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcajayon.countries.services.ApiService;

@Controller
public class Countries {

	private final ApiService apiService;
	
	public Countries(ApiService apiService) {
		this.apiService = apiService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
//		List<Object[]> table1 = apiService.findSloveneSpeakingCountries();
//		for (Object[] row : table1) {
//			System.out.println(row[0] + " " + row[1] + " " + row[2]);
//		}
//		List<Object[]> table2 = apiService.countCities();
//		for (Object[] row : table2) {
//			System.out.println(row[0] + " " + row[1]);
//		}
//		List<Object[]> table3 = apiService.citiesInMexico();
//		for (Object[] row : table3) {
//			System.out.println(row[0] + " " + row[1]);
//		}
//		List<Object[]> table4 = apiService.languagesByPercentage();
//		for (Object[] row : table4) {
//			System.out.println(row[0] + " " + row[1]);
//		}
//		List<Object[]> table5 = apiService.countriesBySurfaceArea();
//		for (Object[] row : table5) {
//			System.out.println(row[0] + " " + row[1] + " " + row[2]);
//		}
//		List<Object[]> table6 = apiService.countriesWithConMonarchy();
//		for (Object[] row : table6) {
//			System.out.println(row[0] + " " + row[1] + " " + row[2] + " " + row[3] + " " + row[4]);
//		}
//		List<Object[]> table7 = apiService.findCitiesInArgentina();
//		for (Object[] row : table7) {
//			System.out.println(row[0] + " " + row[1] + " " + row[2] + " " + row[3]);
//		}
		List<Object[]> table8 = apiService.countriesInRegion();
		for (Object[] row : table8) {
			System.out.println(row[0] + " " + row[1]);
		}
		return null;
	}
}