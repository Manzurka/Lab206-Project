package com.mcajayon.countries.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
@Table(name = "countries")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Size(max = 3)
	private String code;
	
	@Column
	@Size(max = 52)
	private String name;
	
	@Column
	private String continent;
	
	@Column
	@Size(max = 26)
	private String region;
	
	@Column
	@Digits(integer = 10, fraction = 2)
	private double surfaceArea;
	
	@Column
	@Digits(integer = 6, fraction = 0)
	private short indepYear;
	
	@Column
	@Digits(integer = 11, fraction = 0)
	private Integer population;
	
	@Column
	@Digits(integer = 3, fraction = 1)
	private double lifeExpectancy;
	
	@Column
	@Digits(integer = 10, fraction = 2)
	private double gnp;
	
	@Column
	@Digits(integer = 10, fraction = 2)
	private double gnpOld;
	
	@Column
	@Size(max = 45)
	private String localName;
	
	@Column
	@Size(max = 45)
	private String governmentForm;
	
	@Column
	@Size(max = 60)
	private String headOfState;
	
	@Column
	@Digits(integer = 11, fraction = 0)
	private Integer capital;
	
	@Column
	@Size(max = 2)
	private String code2;
	
	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
	private List<Language> languages;
	
	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
	private List<City> cities;
	
	public Country() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContinent() {
		return continent;
	}
	
	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public double getSurfaceArea() {
		return surfaceArea;
	}
	
	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
	
	public short getIndepYear() {
		return indepYear;
	}
	
	public void setIndepYear(short indepYear) {
		this.indepYear = indepYear;
	}
	
	public Integer getPopulation() {
		return population;
	}
	
	public void setPopulation(Integer population) {
		this.population = population;
	}
	
	public double getLifeExpectancy() {
		return lifeExpectancy;
	}
	
	public void setLifeExpectancy(double lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}
	
	public double getGnp() {
		return gnp;
	}
	
	public void setGnp(double gnp) {
		this.gnp = gnp;
	}
	
	public double getGnpOld() {
		return gnpOld;
	}
	
	public void setGnpOld(double gnpOld) {
		this.gnpOld = gnpOld;
	}
	
	public String getLocalName() {
		return localName;
	}
	
	public void setLocalName(String localName) {
		this.localName = localName;
	}
	
	public String getGovernmentForm() {
		return governmentForm;
	}
	
	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}
	
	public String getHeadOfState() {
		return headOfState;
	}
	
	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}
	
	public Integer getCapital() {
		return capital;
	}
	
	public void setCapital(Integer capital) {
		this.capital = capital;
	}
	
	public String getCode2() {
		return code2;
	}
	
	public void setCode2(String code2) {
		this.code2 = code2;
	} 
}