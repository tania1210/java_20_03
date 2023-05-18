package homework_12;

import java.util.ArrayList;
import java.util.Hashtable;

public class Main {
	static int sizeH;

	public static void main(String[] args) {
		String[] array = {"orange", "clever", "pen", "java", "green", "clever", "java", "program", "pen", "java", "clever"};
		int [] arrayInt = {1, 54, 91, 91, 103, 0, 2, 49, 2, 8, 842, 0, 921, 60, 60, 21, 5};
		ArrayList <String> list = new ArrayList();
		list = toListString(array);
		//method 1
		System.out.println(countOccurance(array, "pen"));
		
		//method 2
		System.out.println(toList(arrayInt));
		
		//method 3
		System.out.println(findUnique(arrayInt));
		
		//method 4
		System.out.println(calcOccurance(list));

		
		
		//method 5
		System.out.println(findOccurance(list));
		
		
	}
	
	public static int countOccurance(String [] array, String str) {
		int count = 0;
		for(String word: array) {
			if(word.equals(str)) {
				count++;		
			}
		}
		return count;
	}
	
	public static ArrayList toList(int [] numbers) {
		ArrayList <Integer> list = new ArrayList<>();
		for(int number: numbers) {
			list.add(number);
		}
		return list;
	}
	
	public static ArrayList toListString(String [] words) {
		ArrayList <String> list = new ArrayList<>();
		for(String word: words) {
			list.add(word);
		}
		return list;
	}
	
	public static ArrayList findUnique(int [] numbers) {
		
		ArrayList <Integer> list = new ArrayList();
		for(int j = 0; j < numbers.length; j++) {
			boolean bool = false;
			for(int i = 0; i < numbers.length; i++) {
				if(numbers[j] == numbers[i] && j != i) {
					bool = false;
					break;
				}else {
					bool = true;
				}				
			}
			if(bool) {
				list.add(numbers[j]);
			}
		}	
		return list;	
	}
	
	public static String calcOccurance(ArrayList list) {
		String result = "";
		for(int j = 0; j < list.size(); j++) {
			int count = 1;
			boolean bool = true;
			for(int i = 0; i < list.size(); i++) {
				if(list.get(j) == list.get(i) && j != i) {
					count++;
				}				
			}		
			for(int k = j; k > 0; k--) {
				if(list.get(j) == list.get(k) && k != j) {
					bool = false;
				}
			}
			if(bool) {
				result += list.get(j) + ": " + Integer.toString(count) + "\n";
			}else {
				continue;
			}
		}
		return result;
	}
	
	public static Hashtable<String, Integer> findOccurance(ArrayList list) {
		Hashtable<String, Integer> dictionary = new Hashtable(20);	
		sizeH = 0;
		for(int j = 0; j < list.size(); j++) {
			int count = 1;
			for(int i = 0; i < list.size(); i++) {
				if(list.get(j) == list.get(i) && j != i) {
					count++;
				}				
			}
			dictionary.put((String) ("\n"+list.get(j)), count);
			sizeH++;
		}
		return dictionary;
	}
	
	
}

