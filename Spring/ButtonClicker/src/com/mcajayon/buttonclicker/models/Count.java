package com.mcajayon.buttonclicker.models;

public class Count {
	public static Integer buttonClicks = 0;
	public static Integer getButtonClicks() {
		return buttonClicks;
	}
	public static void addOne() {
		buttonClicks++;
	}
}