package lr3.comparing_collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.TreeSet;

public class GetBenchmark {
    private static final int N = 100_000;

    public static void main(String[] args) {
        // 1) Подготовка: заполняем все коллекции N элементами [0..N-1].
        ArrayDeque<Integer> deque = new ArrayDeque<>(N);
        ArrayList<Integer> arrayList = new ArrayList<>(N);
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            deque.addLast(i);
            arrayList.add(i);
            treeSet.add(i);
        }

        // 2) Получение по индексу (позиция N/2)
        int mid = N / 2;
        long start = System.nanoTime();
        arrayList.get(mid);
        long timeArrayGetMid = System.nanoTime() - start;

        // Для ArrayDeque: contains
        start = System.nanoTime();
        deque.contains(mid);
        long timeDequeGet = System.nanoTime() - start;

        // Для TreeSet: contains (O(log n))
        start = System.nanoTime();
        treeSet.contains(mid);
        long timeTreeGet = System.nanoTime() - start;

        // 3) Вывод результатов
        System.out.println("=== GetBenchmark (N = " + N + ") ===\n");
        System.out.printf("ArrayDeque.contains(%d): %d ns%n", mid, timeDequeGet);
        System.out.printf("ArrayList.get(%d):       %d ns%n", mid, timeArrayGetMid);
        System.out.printf("TreeSet.contains(%d):    %d ns%n", mid, timeTreeGet);
    }
}
