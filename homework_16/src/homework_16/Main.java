package homework_16;

public class Main {

	public static void quickSort(int[] array, int low, int high) {
         if (low >= high) {
        	 return;
         }

         int middle = low + (high - low) / 2;
         int opora = array[middle];

         int i = low, j = high;
         while (i <= j) {
             while (array[i] < opora) {
                 i++;
             }

             while (array[j] > opora) {
                 j--;
             }

             if (i <= j) {
                swap(array, i, j);
                 i++;
                 j--;
             }
         }
         
         if (low < j) {
        	 quickSort(array, low, j);
         }
         
         if (high > i) {
    	 	quickSort(array, i, high);         
         }
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
	
	private static void swap(int [] array, int i, int j) {
		int buff = array[i];
		array[i] = array[j];
		array[j] = buff;
	}
	
	public static void main(String[] args) {
		int [] x = {3, 2, 6, -1, 9, 1, -6, 10, 5};
		
		for(int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.print("\nshake : ");
		
		shakerSort(x);
		for(int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.print("\nquick : ");
		quickSort(x, 0, x.length-1);
		for(int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
	}
}

