package com.quantitymeasurement;

public interface IMeasurable {

	public double getConversionFactor();

	public double convertToBaseUnit(double value);

	public double convertFromBaseUnit(double baseValue);

	public String getUnitName();
	
	SupportsArithmetic supportsArithmetic = () -> true;

	default boolean supportsArithmetic() {
		return supportsArithmetic.isSupported();
	}

	default void validateOperationSupport(String operation) {
	}
}
