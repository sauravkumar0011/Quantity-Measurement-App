package com.quantitymeasurement;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class InchesTest {

	@Test
	public void testEquality_SameValue() {
		Inches I1= new Inches(10.0);
		Inches I2 = new Inches(10.0);

		assertTrue(I1.equals(I2));
	}

	@Test
	public void estEquality_DifferentValue() {
		Inches I1 = new Inches(1.0);
		Inches I2 = new Inches(2.0);

		assertFalse(I1.equals(I2));

	}

	@Test
	public void testEquality_NullComparison() {
		Inches I1 = new Inches(1.2);

		assertFalse(I1.equals(null));
	}

	@Test
	void testEquality_NonNumericInput() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Inches(Double.NaN);
		});
	}

	@Test
	public void testEquality_SameReference() {
		Inches I1 = new Inches(2.6);

		assertTrue(I1.equals(I1));
	}
}
