package edu.nelson.javabean;

public class CarInstance1 {
	
	public static void main(String[] args) {
		
		Car car = new Car();
		
		/*Setting all attributes individually*/
		car.setMake("Toyota");
		car.setModel("Tundra");
		car.setColor("Grey");
		car.setYear(2005);
		
		System.out.println(car.toString());
		
		/*Setting attributes at one time.  Must be done in order.*/
		Car car2 = new Car("Toyota","4Runner","Silver",2012);
		
		/*Accessing specific attribute*/
		System.out.println(car2.getModel());
		
	}

}
