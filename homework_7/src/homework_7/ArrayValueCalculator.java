package homework_7;

import myExceptions.ArrayDataException;
import myExceptions.ArraySizeException;

public class ArrayValueCalculator {

	static int result = 0;
	
	public static void doCalc(String array [][]) throws ArraySizeException, ArrayDataException{
		int [][]arr = new int[4][4];
		int i = 0;
		for(String [] str: array) {
			i++;
			for(int j = 0; j < str.length; j++) {
				if(i >= 4 || j >= 4) {
					throw new ArraySizeException(j);
				}else {
					try {
						arr[i][j] = Integer.parseInt(str[j]);
						result += arr[i][j];
					}catch(NumberFormatException e) {
						throw new ArrayDataException("uncorrect data: " + str[j] + " = array[" + i + "][" + j + "]");	
					}
				}					
			}
		}
	}
	
	public static boolean isInt(String array) {
		boolean bool;
		try {
			Integer.parseInt(array);
			bool = true;
		}catch(NumberFormatException e1) {
			bool = false;			
		}
		return bool;
	}
	
	public static int getInt() {		
		return result;
	}
	
	public static void main(String[] args) {
		String [][] array = {{"1", "54", "-8"}, {"6", "grd", "-7", "f1"}, 
							 {"9", "fdssr", "@y", "4", "10"}, {"975", "!", "-6"}};
		
		String [][] array2 = {{"1", "54", "-8"}, {"6", "1", "-7", "11"}, 
				 {"9", "-52", "32", "4", "10"}, {"975", "75", "5", "-6"}};
		try {
			doCalc(array);
			System.out.println(getInt());
		}catch(ArrayDataException e) {
			System.out.println(e.getMessage());
			System.out.println(getInt());
		}catch(ArraySizeException e1) {
			System.out.println(e1.getMessage());
			System.out.println(getInt());
		}
		
		System.out.println("end");
	}

}
