package edu.nelson.javabean;
import java.io.Serializable;

/* A Java Bean is a standard for a Java class
 * Public constructor with no arguments
 * Private properties
 * Getters and Setters
 * Serializable */

public class Car implements Serializable{

	/* Properties */
	private String make;
	private String model;
	private String color;
	private int year;
	
	public Car() {
		
	}
	public Car(String make, String model, String color, int year) {
		super();
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
	}
	
	/* Getters & Setters */
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
}
