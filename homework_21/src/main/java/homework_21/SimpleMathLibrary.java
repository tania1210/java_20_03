package homework_21;

public class SimpleMathLibrary {
    public double add(double a, double b) {
        return a + b;
    }

    public double minus(double a, double b) {
        return a - b;
    }
    
    public int[] extractNumbersAfterLastFour(int[] inputArray) {
    	int index = -1;
    	
    	for(int i = 0; i< inputArray.length; i++) {
    		if(inputArray[i] == 4) {
    			index = i;
    		}
    	}
    	index++;
    	System.out.println("index = " + index);
    	int[] result = new int[inputArray.length - index];
    	
    	for(int i = index, j = 0; i < inputArray.length; i++, j++) {
    		result[j] = inputArray[i];
    	}
    	for(int i: result) {
    		System.out.print(i);
    	}
    	
    	return result;
    }
    
    public boolean containsOneAndFour(int [] array) {
    	boolean containsOne = false;
    	boolean containsFour = false;
    	
    	for(int number: array) {
    		if(number == 1) {
    			containsOne = true;
    		}else if(number == 4) {
    			containsFour = true;
    		}
    	}
    	return containsOne && containsFour;
    }
}
