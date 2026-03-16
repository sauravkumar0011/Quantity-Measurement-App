package com.app.quantitymeasurement.units;

import com.app.quantitymeasurement.interfaces.IMeasurable;
import com.app.quantitymeasurement.interfaces.SupportsArithmetic;

public enum LengthUnit implements IMeasurable, SupportsArithmetic {

	FEET(12.0),
	INCHES(1.0),
	YARDS(36.0),
	CENTIMETERS(1 / 2.54);

	/**
	 * Conversion factor used to convert the unit value
	 * to the base unit of the measurement category.
	 */
	private final double conversionFactor;

	/**
	 * Constructor for LengthUnit enum constants.
	 *
	 * Each enum constant is initialized with a conversion
	 * factor that defines how the unit converts to the
	 * base unit of the length measurement category.
	 *
	 * @param conversionFactor the multiplier used to convert
	 *                         the unit value to the base unit
	 */
	LengthUnit(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	/**
	 * Converts the given unit value to the base unit.
	 *
	 * The conversion process multiplies the given value
	 * with the conversion factor associated with the
	 * specific unit.
	 *
	 * The result is rounded to 6 decimal places to ensure
	 * consistent precision during conversion operations.
	 *
	 * @param value the value in the current unit
	 * @return the converted value in the base unit
	 */
	@Override
	public double convertToBaseUnit(double value) {
        double result = value * conversionFactor;
        return Math.round(result * 1_000_000.0) / 1_000_000.0;
    }
	
	/**
	 * Converts a value from the base unit to the current unit.
	 *
	 * This method performs the reverse conversion by dividing
	 * the base unit value with the conversion factor associated
	 * with the unit.
	 *
	 * The result is rounded to 6 decimal places to maintain
	 * numerical precision and consistency across conversions.
	 *
	 * @param baseValue the value in the base unit
	 * @return the converted value in the current unit
	 */
	@Override
	public double convertFromBaseUnit(double baseValue) {
        double result = baseValue / conversionFactor;
        return Math.round(result * 1_000_000.0) / 1_000_000.0;
    }
	
	/**
	 * Returns the name of the unit.
	 *
	 * This method returns the enum constant name which
	 * represents the unit name used throughout the
	 * Quantity Measurement application.
	 *
	 * @return the unit name as a String
	 */
	@Override
	public String getUnitName() {
	    return name();
	}

	/**
	 * Returns the measurement type associated with this unit.
	 *
	 * This method returns the simple name of the enum class,
	 * which identifies the measurement category for the unit.
	 *
	 * For example:
	 * LengthUnit -> "LengthUnit"
	 *
	 * @return the measurement type name
	 */
	@Override
	public String getMeasurementType() {
		return this.getClass().getSimpleName();
	}

	/**
	 * Retrieves the unit instance corresponding to the given unit name.
	 *
	 * This method searches through all available enum constants
	 * of {@code LengthUnit} and returns the matching unit instance.
	 *
	 * The comparison is case-insensitive to improve usability.
	 *
	 * If the provided unit name does not match any defined
	 * length unit, an {@link IllegalArgumentException} is thrown.
	 *
	 * @param unitName the name of the unit to retrieve
	 * @return the corresponding {@link IMeasurableTest} unit instance
	 * @throws IllegalArgumentException if the unit name is invalid
	 */
	@Override
	public IMeasurable getUnitInstance(String unitName) {
		for(LengthUnit unit : LengthUnit.values()) {			
			if(unit.getUnitName().equalsIgnoreCase(unitName)) {				
				return unit;
			}
		}
		
		throw new IllegalArgumentException(
			"Invalid length unit: " + unitName
		);
	}
}
