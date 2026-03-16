package com.app.quantitymeasurement.exception;

public class QuantityMeasurementException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new QuantityMeasurementException with
	 * the specified error message.
	 *
	 * @param message detailed error description
	 */
	public QuantityMeasurementException(String message) {
		super(message);
	}

	/**
	 * Constructs a new QuantityMeasurementException with
	 * the specified error message and underlying cause.
	 *
	 * This constructor is useful when wrapping lower-level
	 * exceptions to provide additional context.
	 *
	 * @param message detailed error description
	 * @param cause underlying exception cause
	 */
	public QuantityMeasurementException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Main method for simple testing of the custom exception.
	 *
	 * Demonstrates how the QuantityMeasurementException
	 * can be thrown and caught within the application.
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		try {
			throw new QuantityMeasurementException(
				"This is a test exception for quantity measurement."
			);
		} catch(QuantityMeasurementException ex) {
			System.out.println("Caught QuantityMeasurementException: " + 
								ex.getMessage());
		} 
	}
}
