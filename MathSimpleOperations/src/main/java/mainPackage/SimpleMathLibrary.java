package mainPackage;

import java.util.Scanner;

public class SimpleMathLibrary {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the numbers: ");
		
		int a = s.nextInt();
		int b = s.nextInt();
		
		while(true) {
			System.out.println("Switch the action: +, -, *, / or end");

			String action = s.next();
			
			if(action.equals("+")) {
				System.out.println("result: " + add(a, b));
			}else if(action.equals("-")) {
				System.out.println("result: " + minus(a, b));
			}else if(action.equals("*")) {
				System.out.println("result: " + multiplication(a, b));
			}else if(action.equals("/")) {
				System.out.println("result: " + division(a, b));
			}else {
				break;
			}
		}

	}
	
	public static double add(int a, int b) {
		return a+b;
	}
	
	public static double minus(int a, int b) {
		return a-b;
	}
	
	public static double multiplication(int a, int b) {
		return a*b;
	}
	
	public static double division(int a, int b) {
		try {
			return a/b;
		}catch(ArithmeticException e) {
			System.out.println("you trying to divide by zero");
		}
		return 0;
	}
}
