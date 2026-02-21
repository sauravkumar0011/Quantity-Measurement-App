package com.quantitymeasurement;

public class QuantityMeasurementApp {

	public static void demonstrateFeetEquality() {
		Feet f1 = new Feet(10.5);
		Feet f2 = new Feet(10.5);
		Feet f3 = new Feet(12.0);

		System.out.println("10.5 ft and 10.5 ft :  " + f1.equals(f2)); // true
		System.out.println("10.5 ft and 12.0 ft :  " + f1.equals(f3)); // false
	}
	
	public static void demonstrateInchesEquality() {
		Inches f1 = new Inches(10.5);
		Inches f2 = new Inches(10.5);
		Inches f3 = new Inches(12.0);

		System.out.println("10.5 inch and 10.5 inch :  " + f1.equals(f2)); // true
		System.out.println("10.5 inch and 12.0 inch:  " + f1.equals(f3)); // false 
	}
	public static void main(String[] args) {
		demonstrateFeetEquality();
		demonstrateInchesEquality();
	}
}
