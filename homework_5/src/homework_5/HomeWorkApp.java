package homework_5;

public class HomeWorkApp {
	
	public static String printThreeWords(String str) {
		return str.join("\n", str.split(", "));
	}

	public static void main(String[] args) {
		String str = "Orange, Banana, Apple";
		System.out.println(printThreeWords(str));
	}

}
