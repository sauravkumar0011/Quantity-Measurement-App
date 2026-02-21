package com.quantitymeasurement;

public class QuantityMeasurementApp {
		
		public static void main(String[] args) {
			Feet f1 = new Feet(10.5);
			Feet f2 = new Feet(10.5);
			Feet f3 = new Feet(12.0);

	        System.out.println("f1 equals f2 :  " + f1.equals(f2)); // true
	        System.out.println("f1 equals f3 :  " + f1.equals(f3)); // false
		}
}
