package homework_16;

public class Main {

	public void quickSort() {
		
	}
	
	public static int[] shakerSort(int [] values) {
		int left = 1;
		int right = values.length -1;
		int x = 0;
		while(left <= right) {
			for(int i = right; i > left-1; --i) {
				if(values[i-1] > values[i]) {
					x = values[i];
					values[i] = values[i-1];
					values[i-1] = x;
				}
			}			
			left++;

			for(int i = left; i < right; ++i) {
				if(values[i+1] > values[i]) {
					x = values[i-1];
					values[i-1] = values[i];
					values[i] = x;
				}
			}
			right--;
		}
		return values;
	}
	
	public static void main(String[] args) {
		int [] x = {3, 2, 6, -1, 9, 1, -6, 10, 5};
		for(int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.println();
		x = shakerSort(x);
		for(int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
	}

}
