package homework_21;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleMathLibraryTest {
	SimpleMathLibrary mathLibrary = new SimpleMathLibrary();
	
    @Test
    public void testAdd() {
        double result = mathLibrary.add(2.0, 3.0);
        Assertions.assertEquals(5.0, result);
    }

    @Test
    public void testMinus() {
        double result = mathLibrary.minus(5.0, 3.0);
        Assertions.assertEquals(2.0, result);
    }
    
    @Test
    public void testValidInput1() {
        int[] inputArray = {6, 9, 1, 1, 4, 8, 5, 4, 0, 1, 3};
        int[] expected = {0, 1, 3};
        int[] result = mathLibrary.extractNumbersAfterLastFour(inputArray);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testValidInput2() {
        int[] inputArray = {1, 2, 3, 5, 6, 4, 5, 4, 1, 9};
        int[] expected = {1, 9};
        int[] result = mathLibrary.extractNumbersAfterLastFour(inputArray);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testValidInput3() {
    	int[] inputArray = {1, 2, 3, 5, 6, 4, 5, 4};
        int[] expected = {};
        int[] result = mathLibrary.extractNumbersAfterLastFour(inputArray);
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testArrayWithOneAndFour() {
    	int[] array = {1, 2, 3, 4};
    	assertTrue(mathLibrary.containsOneAndFour(array));
    }
    
    @Test
    public void testArrayWithoutOneAndFour() {
    	int[] array = {0, 2, 3, 6};
    	assertFalse(mathLibrary.containsOneAndFour(array));
    }
    
    @Test
    public void testArrayWithOnlyOne() {
    	int[] array = {1, 2, 3, 8};
    	assertFalse(mathLibrary.containsOneAndFour(array));
    }
    
    @Test
    public void testArrayWithOnlyFour() {
    	int[] array = {4, 2, 3, 4};
    	assertFalse(mathLibrary.containsOneAndFour(array));
    }
}

