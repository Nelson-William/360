package edu.nelson.mvc;

import java.time.Period;

public class AgeModel {
	
	/*The purpose of the Model is to house the functions needed to use the data.*/
	
	private int currentAge;
	
	public void calculateCurrentAge(LocalDate birthDate, LocalDate currentDate) {
		currentAge = Period.between(birthDate,  currentDate).getYears();
	}

}
