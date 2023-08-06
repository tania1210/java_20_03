package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ValueCalculator {
    public static void fullArray(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        float[] arr = new float[1_000_000];
        int half = arr.length / 2;

        fullArray(arr);

        float[] a1 = new float[half];
        System.arraycopy(arr, 0, a1, 0, half);

        float[] a2 = new float[arr.length - half];
        System.arraycopy(arr, half, a2, 0, a2.length);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable runnable1 = new MyRunnable(a1);
        Runnable runnable2 = new MyRunnable(a2);
        
        executor.submit(runnable1);
        executor.submit(runnable2);

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Чекаємо завершення всіх потоків
        }

        System.arraycopy(a1, 0, arr, 0, half);
        System.arraycopy(a2, 0, arr, half, a2.length);

        long end = System.currentTimeMillis();
        System.out.println("Time : " + (end - start));
    }

    public static void processArray(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
    
    public static class MyRunnable implements Runnable {
        float[] array;

        public MyRunnable(float[] array) {
            this.array = array;
        }

        @Override
        public void run() {
            System.out.println("MyRunnable " + Thread.currentThread().getName());
            processArray(array);
        }
    }
}
