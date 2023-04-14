package homework_6;

public class Main {
	
	public static int findSymbolOccurance(String str, char s) {
		char strArray [] = str.toCharArray();
		int count = 0;
		for(char array: strArray) {
			if(array == s) {
				count++;
			}else {
				continue;
			}
		}
		return count;
	}
	
	public static int findWordPosition(String source, String target) {
		int i = 0;
		if(source.contains(target)) {
			return source.indexOf(target);
		}else {
			return -1;
		}
	}
	
	public static String stringReverse(String str) {
		return new StringBuilder(str).reverse().toString();
		
	}
	
	public static boolean isPalindrome(String palindrome) {
		String palindromeReverse = new StringBuilder(palindrome).reverse().toString();
		if(palindrome.equals(palindromeReverse)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	public static void main(String[] args) {
		String str = "HFIEfwefh<, jf p3efas!";
		char s = 'f';
		String source = "Apollo";
		String target = "llo";
		String palindrome = "deed";
		
		
		System.out.println("task 2:\n" + findSymbolOccurance(str, s));
		System.out.println("\ntask 3:\n" + findWordPosition(source, target));
		System.out.println("\ntask 4:\n" + stringReverse(source));
		System.out.println("\ntask 5:\n" + isPalindrome(palindrome));
		System.out.println("\ntask 6:");
		taskSix object = new taskSix();
		object.verification();
		System.out.println(object.output());
	}

}
