package homework_5;

import java.util.Scanner;

public class HomeWorkApp {
	
	public static String printThreeWords(String str) {
		return str.join("\n", str.split(", "));
	}

	public static String checkSumSign(int a, int b) {		
		if((a+b) >= 0) {
			return "Сума позитивна";
		}else {
			return "Сума негативна";
		}
	}
	
	public static String printColor(int value) {
		if(value < 1) {
			return "Червоний";
		}else if(value > 0 && value < 101) {
			return "Жовтий";
		}else {
			return "Зелений";
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int value = s.nextInt();
		
		String str = "Orange, Banana, Apple";
		
		
		System.out.println(printThreeWords(str));
		System.out.println(checkSumSign(a, b));
		System.out.println(printColor(value));
	}

}
