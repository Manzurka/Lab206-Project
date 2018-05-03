package com.mcajayon.teamroster.models;

public class Player {
	
	protected String first_name, last_name;
	protected int age;
	
	public Player(String first_name, String last_name, int age) {
		first_name = first_name;
		last_name = last_name;
		this.age = age;
	}
	
	public String getFirstName() {
		return first_name;
	}
	
	public void setFirstName() {
		this.first_name = first_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public void setLastName() {
		this.last_name = last_name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
