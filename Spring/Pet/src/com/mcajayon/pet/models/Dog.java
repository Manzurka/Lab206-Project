package com.mcajayon.pet.models;

public class Dog extends Animal implements Pet {
	public Dog() {
	}
	public Dog(String name, String breed, Integer weight) {
		super(name, breed, weight);
	}
	public String showAffection() {
		return(getName() + " hopped into your lap and cuddled you!");
	}
}

