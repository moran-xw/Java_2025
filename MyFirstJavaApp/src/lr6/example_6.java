package lr6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class example_6 {
    public static long parallelSum(int[] array) throws InterruptedException, ExecutionException {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        List<Future<Long>> futures = new ArrayList<>();
        int chunk = (array.length + cores - 1) / cores;
        for (int i = 0; i < cores; i++) {
            int start = i * chunk;
            int end = Math.min(array.length, start + chunk);
            if (start >= end) break;
            futures.add(executor.submit(() -> {
                long sum = 0;
                for (int j = start; j < end; j++) {
                    sum += array[j];
                }
                return sum;
            }));
        }
        executor.shutdown();
        long total = 0;
        for (Future<Long> f : futures) {
            total += f.get();
        }
        return total;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int n = 1_000_000;
        int[] data = new Random().ints(n, 0, 100).toArray();
        System.out.println("Сумма элементов в массиве: " + parallelSum(data));
    }
}

