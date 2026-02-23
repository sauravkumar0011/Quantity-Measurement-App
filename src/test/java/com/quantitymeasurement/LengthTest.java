package com.quantitymeasurement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.quantitymeasurement.Length.LengthUnit;

public class LengthTest {
	@Test
	void testEquality_FeetToFeet_SameValue() {
		Length q1 = new Length(1.0, LengthUnit.FEET);
		Length q2 = new Length(1.0, LengthUnit.FEET);
		assertEquals(q1, q2);
	}

	@Test
	void testEquality_InchToInch_SameValue() {
		Length q1 = new Length(1.0, LengthUnit.INCHES);
		Length q2 = new Length(1.0, LengthUnit.INCHES);
		assertEquals(q1, q2);
	}

	@Test
	void testEquality_FeetToInch_EquivalentValue() {
		Length q1 = new Length(1.0, LengthUnit.FEET);
		Length q2 = new Length(12.0, LengthUnit.INCHES);
		assertEquals(q1, q2);
	}

	@Test
	void testEquality_InchToFeet_EquivalentValue() {
		Length q1 = new Length(12.0, LengthUnit.INCHES);
		Length q2 = new Length(1.0, LengthUnit.FEET);
		assertEquals(q1, q2);
	}

	@Test
	void testEquality_FeetToFeet_DifferentValue() {
		Length q1 = new Length(1.0, LengthUnit.FEET);
		Length q2 = new Length(2.0, LengthUnit.FEET);
		assertNotEquals(q1, q2);
	}

	@Test
	void testEquality_InchToInch_DifferentValue() {
		Length q1 = new Length(1.0, LengthUnit.INCHES);
		Length q2 = new Length(2.0, LengthUnit.INCHES);
		assertNotEquals(q1, q2);
	}

	@Test
	void testEquality_NullComparison() {
		Length q1 = new Length(1.0, LengthUnit.FEET);
		assertNotEquals(q1, null);
	}

	@Test
	void testEquality_SameReference() {
		Length q1 = new Length(1.0, LengthUnit.FEET);
		assertEquals(q1, q1);
	}

	@Test
	void testEquality_InvalidUnit() {
		assertThrows(IllegalArgumentException.class, () -> new Length(1.0, null));
	}
}
