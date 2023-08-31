package mainTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import mainPackage.SimpleMathLibrary;

public class SimpleMathLibraryTest {

	@Test
	public void testAdd() {
		Assertions.assertEquals(3, SimpleMathLibrary.add(2, 1));
	}
	
	@Test
	public void testMinus() {
		Assertions.assertEquals(-1.0, SimpleMathLibrary.minus(2, 3));
	}
	
	@Test
	public void testMultiplication() {
		Assertions.assertEquals(6.0, SimpleMathLibrary.multiplication(2, 3));
	}
	
	@Test
	public void testDivision() {
		Assertions.assertEquals(2.0, SimpleMathLibrary.division(4, 2));
		try {
			SimpleMathLibrary.division(0, 0);
			
		} catch(ArithmeticException e) {
			fail("Should have thrown an exception");
		}
	}
}
