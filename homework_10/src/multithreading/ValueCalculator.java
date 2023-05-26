package multithreading;

public class ValueCalculator {
	
	public static void fullArray(float [] arr) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < arr.length; i++) {
			arr[i] = 1;
		}

	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		float[] arr = new float[1000];
		int half = arr.length / 2;
		
		fullArray(arr);
			 
		float [] a1 = new float[half];
		System.arraycopy(arr, 0, a1, 0, half);
			
		float [] a2 = new float[arr.length/2];
		System.arraycopy(arr, half, a2, 0, half);		
		
		MyRunnable runnable1 = new MyRunnable(a1);
        Thread thread1 = new Thread(runnable1);
        thread1.start();
        try {
			thread1.join();
		} catch (InterruptedException e) {
			System.out.println("exception");
		}
        a1 = runnable1.getArray();
                
        MyRunnable runnable2 = new MyRunnable(a2);
        Thread thread2 = new Thread(runnable2);
        thread2.start();
        try {
			thread2.join();
		} catch (InterruptedException e) {
			System.out.println("exception");
		}
        a2 = runnable2.getArray();        
        
        System.arraycopy(a1, 0, arr, 0, half);
        System.arraycopy(a2, 0, arr, half, half);
        
        long end = System.currentTimeMillis();
        System.out.println("Time : " + (end - start));
        
	}
	
	public static class MyRunnable implements Runnable{
		float [] array;
		
		public MyRunnable(float [] array) {
			this.array = array;
		}
		
		@Override
		public void run() {
			System.out.println("MyRunnable " + Thread.currentThread().getName());
			for(int i = 0; i < array.length; i++) {
				array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)); 
			}
		}
		
		public float[] getArray() {
			return array;
		}
	}


}
