package com.app.quantitymeasurement.units;

import java.util.function.Function;

import com.app.quantitymeasurement.interfaces.IMeasurable;

public enum TemperatureUnit implements IMeasurable {

	CELSIUS(
		v -> v, 
		v -> v 
	), 
	FAHRENHEIT(
		v -> (v - 32.0) * 5.0 / 9.0,
		v -> v * 9.0 / 5.0 + 32.0
	),
	KELVIN(
		v -> v - 273.15,
		v -> v + 273.15
	);

	/**
	 * Function used to convert a value from the current
	 * temperature unit to the base unit (Celsius).
	 */
	private final Function<Double, Double> toBase;

	/**
	 * Function used to convert a value from the base unit
	 * (Celsius) to the current temperature unit.
	 */
	private final Function<Double, Double> fromBase;

	/**
	 * Constructor for TemperatureUnit enum constants.
	 *
	 * Each temperature unit defines two conversion functions:
	 * 1. A function to convert a value to the base unit.
	 * 2. A function to convert the base unit value back to the unit.
	 *
	 * @param toBase function to convert the value to the base unit
	 * @param fromBase function to convert the base unit value to this unit
	 */
	TemperatureUnit(Function<Double, Double> toBase, Function<Double, Double> fromBase) {
		this.toBase = toBase;
		this.fromBase = fromBase;
	}

	/**
	 * Returns the name of the temperature unit.
	 *
	 * The enum constant name is used as the
	 * unit identifier throughout the system.
	 *
	 * @return the name of the unit
	 */
	@Override
	public String getUnitName() {
		return this.name();
	}

	/**
	 * Converts the given temperature value to the base unit.
	 *
	 * The base unit used in the temperature measurement
	 * category is Celsius. The conversion logic is defined
	 * using the {@code toBase} functional strategy associated
	 * with each enum constant.
	 *
	 * @param value the value in the current temperature unit
	 * @return the value converted to the base unit (Celsius)
	 */
	@Override
	public double convertToBaseUnit(double value) {
		return toBase.apply(value);
	}

	/**
	 * Converts the given base unit value to the current unit.
	 *
	 * The conversion logic is defined using the {@code fromBase}
	 * functional strategy associated with each enum constant.
	 *
	 * @param baseValue the value in the base unit (Celsius)
	 * @return the converted value in the current temperature unit
	 */
	@Override
	public double convertFromBaseUnit(double baseValue) {
		return fromBase.apply(baseValue);
	}

	/**
	 * Converts a temperature value from the current unit
	 * to a specified target temperature unit.
	 *
	 * The conversion follows these steps:
	 * 1. Convert the given value to the base unit (Celsius).
	 * 2. Convert the base unit value to the target unit.
	 *
	 * @param value the temperature value in the current unit
	 * @param target the target temperature unit
	 * @return the converted temperature value in the target unit
	 */
	public double convertTo(double value, TemperatureUnit target) {
		double base = convertToBaseUnit(value);
		return target.convertFromBaseUnit(base);
	}
	
	/**
	 * Returns the measurement type associated with this unit.
	 *
	 * The measurement type corresponds to the simple
	 * name of the enum class, which identifies the
	 * measurement category.
	 *
	 * Example:
	 * TemperatureUnit -> "TemperatureUnit"
	 *
	 * @return the measurement type name
	 */
	@Override
	public String getMeasurementType() {
		return this.getClass().getSimpleName();
	}

	/**
	 * Retrieves the unit instance corresponding to the
	 * given temperature unit name.
	 *
	 * This method searches through all available enum
	 * constants of {@code TemperatureUnit} and returns
	 * the matching instance.
	 *
	 * The comparison is case-insensitive.
	 *
	 * If the provided unit name does not match any
	 * supported temperature unit, an
	 * {@link IllegalArgumentException} is thrown.
	 *
	 * @param unitName the name of the temperature unit
	 * @return the corresponding {@link IMeasurable} unit instance
	 * @throws IllegalArgumentException if the unit name is invalid
	 */
	@Override
	public IMeasurable getUnitInstance(String unitName) {
		for(TemperatureUnit unit : TemperatureUnit.values()) {			
			if(unit.getUnitName().equalsIgnoreCase(unitName)) {				
				return unit;
			}
		}
		
		throw new IllegalArgumentException(
			"Invalid temperature unit: " + unitName
		);
	}
}