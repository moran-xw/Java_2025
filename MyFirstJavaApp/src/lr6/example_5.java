package lr6;


import java.util.Arrays;
import java.util.Random;

public class example_5 {

    public static void main(String[] args) {
        int[] array = generateRandomArray(100_000_000);

        int maxMultiThread = findMaxMultiThread(array);
        System.out.println("Максимальный элемент: " + maxMultiThread);
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    private static int findMaxMultiThread(int[] array) {
        int numThreads = 4;

        final int[] threadResults = new int[numThreads];
        Arrays.fill(threadResults, Integer.MIN_VALUE);

        Thread[] threads = new Thread[numThreads];
        int chunkSize = array.length / numThreads;

        for (int i = 0; i < numThreads; i++) {
            final int threadIndex = i;
            final int startIndex = i * chunkSize;
            final int endIndex = (i == numThreads - 1) ? array.length : (i + 1) * chunkSize;

            threads[i] = new Thread(() -> {
                int max = Integer.MIN_VALUE;
                for (int j = startIndex; j < endIndex; j++) {
                    if (array[j] > max) {
                        max = array[j];
                    }
                }
                threadResults[threadIndex] = max;
            });

            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int overallMax = Integer.MIN_VALUE;
        for (int result : threadResults) {
            if (result > overallMax) {
                overallMax = result;
            }
        }

        return overallMax;
    }
}