package homework_5;

public class HomeWorkApp {
	
	public static String printThreeWords(String str) {
		return str.join("\n", str.split(", "));
	}

	public static String checkSumSign() {
		int a = -1;
		int b = 2;
		
		if((a+b) >= 0) {
			return "Сума позитивна";
		}else {
			return "Сума негативна";
		}
	}
	
	public static void main(String[] args) {
		String str = "Orange, Banana, Apple";
		System.out.println(printThreeWords(str));
		System.out.println(checkSumSign());
	}

}
