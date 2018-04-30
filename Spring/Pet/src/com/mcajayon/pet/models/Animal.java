package com.mcajayon.pet.models;

public class Animal {
	private String name;
	private String breed;
	private Integer weight;
	public Animal() {
	}
	public Animal(String name, String breed, Integer weight) {
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}
	public String getName() {
		return this.name;
	}
	public String getBreed() {
		return this.breed;
	}
	public Integer getWeight() {
		return this.weight;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
}