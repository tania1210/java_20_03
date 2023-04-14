package homework_6;

import java.util.Random;
import java.util.Scanner;

/* 1. рандомний вибір слова з масиву
 * 2. сканер на стрінг
 * 3. порівняння слів по символах:
 * якщо співпало відобразити букву/ інакше #
 * у результаті якщо не вгадано слово вивести 15 символів
 * 
 * */
public class taskSix {
	
	private String words [] = {"apple", "orange", "lemon", "banana", "apricot",
			"avocado", "broccoli", "carrot", "cherry", "garlic",
			"grape", "melon", "leak", "kiwi", "mango","mushroom", 
			"nut", "olive", " pea", "peanut", "pear", 
			"pepper", "pineapple", "pumpkin", "potato"};
	private String result = "";
	
	/*метод рандому
	 * метод сканер
	 * метод порівняння
	 * метод виводу*/
	private String input() {
		Scanner s = new Scanner(System.in);
		return s.next();
	}
	
	private String random() {
		Random rand = new Random();
		return words[rand.nextInt(words.length)];
	}
	
	public void verification() {
		taskSix obj = new taskSix();
		String random = obj.random();
		String input = obj.input();
		
		int length = 0;
		if(random.length() <= input.length()) {
			length = random.length();
		}else {
			length = input.length();
		}

		for(byte i = 0; i <= length; i++) {
			if(random.length() <= i | input.length() <= i) {
				if(random.equals(result)) {
					System.out.println("you win! the word was " + random);
				}else {
					for(int j = result.length(); j < 15; j++) {
						result += "#";
					}
				}
			}else {
				if(random.charAt(i) == input.charAt(i)) {
					
					result += random.charAt(i);
				}else {
					result += "#";
				}
			}
		}	
	}
	
	public String output() {
		return result;
	}
}
