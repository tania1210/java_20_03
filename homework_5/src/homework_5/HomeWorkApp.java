package homework_5;

import java.util.Scanner;

public class HomeWorkApp {
	
	public static String printThreeWords(String str) {
		return str.join("\n", str.split(", "));
	}

	public static String checkSumSign() {		
		int a = 0;
		int b = -4;
		if((a+b) >= 0) {
			return "Сума позитивна";
		}else {
			return "Сума негативна";
		}
	}
	
	public static String printColor() {
		int value = 105;
		if(value < 1) {
			return "Червоний";
		}else if(value > 0 && value < 101) {
			return "Жовтий";
		}else {
			return "Зелений";
		}
	}
	
	public static String compareNumbers() {
		int a = 53;
		int b = -1;
		if(a >= b) {
			return "a >= b";
		}else {
			return "a < b";
		}
	}
	
	public static boolean sumNumbers(int a, int c) {
		if(a+c > 9 && a+c < 21) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String positiveOrNegative(int b) {
		if(b >= 0) {
			return "number is positive";
		}else {
			return "number is negative";
		}
	}
	
	public static boolean positiveOrNegativeReverse(int a) {
		if(a < 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void print(String str, int i) {
		for(int j = 0; j < i; j++) {
			System.out.println(str);
		}
	}
	
	public static boolean checkLeapYear(int year) {
		if(year % 4 == 0 & year % 100 != 0) {
			return true;
		}else if(year % 400 == 0) {
			return true;
		}else {
			return false;
		}
	}

	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		int year = s.nextInt();
		
		String str = "Orange, Banana, Apple";
		String str2 = "It is a ninth task";
		
		System.out.println(printThreeWords(str));
		System.out.println(checkSumSign());
		System.out.println(printColor());
		System.out.println(compareNumbers());
		System.out.println(sumNumbers(a, c));
		System.out.println(positiveOrNegative(b));
		System.out.println(positiveOrNegativeReverse(a));
		print(str2, c);
		System.out.println(checkLeapYear(year));
	}

}
