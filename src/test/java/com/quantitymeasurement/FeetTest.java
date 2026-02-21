package com.quantitymeasurement;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class FeetTest {

	
	@Test
    public void testEquality_SameValue() {
		Feet f2 = new Feet(10.0);
		Feet f3 = new Feet(10.0);
		
        assertTrue(f2.equals(f3));
    }
	
	@Test
	public void estEquality_DifferentValue() {
		Feet f2 = new Feet(1.0);
		Feet f3 = new Feet(2.0);
		
        assertFalse(f2.equals(f3));

	}
	
	@Test
	public void testEquality_NullComparison() {
		Feet f1 = new Feet(1.2);
		
		assertFalse(f1.equals(null));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testEquality_NonNumerical() {
		Feet f1 = new Feet(1.2);
		
		assertFalse(f1.equals("5"));
	}
	
	@Test
	public void testEquality_SameReference() {
		Feet f = new Feet(2.6);
		
		assertTrue(f.equals(f));
	}
}
