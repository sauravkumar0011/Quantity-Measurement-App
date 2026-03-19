package com.app.quantitymeasurement.units;

public enum LengthUnit implements IMeasurable, SupportsArithmetic {

    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(1 / 2.54);

    /**
     * Conversion factor used to convert the unit value to the base unit
     * (INCHES) of the length measurement category.
     */
    private final double conversionFactor;

    /**
     * Constructor for LengthUnit enum constants.
     *
     * Each enum constant is initialized with a conversion factor that defines
     * how the unit converts to the base unit (INCHES).
     *
     * @param conversionFactor the multiplier used to convert the unit value to base unit
     */
    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    /**
     * Converts the given unit value to the base unit (INCHES).
     *
     * The conversion multiplies the given value with the conversion factor.
     * Result is rounded to 6 decimal places for consistent precision.
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
     * Converts a value from the base unit (INCHES) to the current unit.
     *
     * Performs the reverse conversion by dividing the base unit value with
     * the conversion factor. Result is rounded to 6 decimal places.
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
     * Returns the name of the unit (enum constant name).
     *
     * @return unit name
     */
    @Override
    public String getUnitName() {
        return name();
    }

    /**
     * Returns the measurement type associated with this unit.
     * Returns "LengthUnit" to identify the measurement category.
     *
     * @return measurement type name
     */
    @Override
    public String getMeasurementType() {
        return this.getClass().getSimpleName();
    }

    /**
     * Retrieves the unit instance corresponding to the given unit name.
     *
     * Searches through all LengthUnit constants using case-insensitive comparison.
     * Throws IllegalArgumentException if the unit name is not found.
     *
     * @param unitName the name of the unit to retrieve
     * @return the corresponding IMeasurable unit instance
     * @throws IllegalArgumentException if the unit name is invalid
     */
    @Override
    public IMeasurable getUnitInstance(String unitName) {
        for (LengthUnit unit : LengthUnit.values()) {
            if (unit.getUnitName().equalsIgnoreCase(unitName)) {
                return unit;
            }
        }
        throw new IllegalArgumentException("Invalid length unit: " + unitName);
    }
}