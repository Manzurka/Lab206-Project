package com.mcajayon.teamroster.models;
import java.util.*;

public class Player {
	private String first_name;
	private String last_name;
	private Integer age;
	
	public Player() {
	}
	public Player(String first_name, String last_name, Integer age) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
	}
	public String getFirstName() {
		return first_name;
	}
	public String getLastName() {
		return last_name;
	}
	public Integer getAge() {
		return age;
	}
}
