package lr3.comparing_collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.TreeSet;

public class AddBenchmark {
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

        // 2) Добавление в начало коллекции
        long start = System.nanoTime();
        deque.addFirst(-1);
        long timeDequeAddFirst = System.nanoTime() - start;

        start = System.nanoTime();
        arrayList.add(0, -1);
        long timeArrayAddFirst = System.nanoTime() - start;

        start = System.nanoTime();
        treeSet.add(-1);
        long timeTreeAddFirst = System.nanoTime() - start;

        // 3) Добавление в середину коллекции (позиция N/2, эмуляция для deque: просто addLast)
        int mid = N / 2;
        start = System.nanoTime();
        deque.addLast(-2); // ArrayDeque не умеет вставлять в середину напрямую
        long timeDequeAddMid = System.nanoTime() - start;

        start = System.nanoTime();
        arrayList.add(mid, -2);
        long timeArrayAddMid = System.nanoTime() - start;

        start = System.nanoTime();
        treeSet.add(mid); // добавление числа, сравниваемого со всеми остальными, O(log n)
        long timeTreeAddMid = System.nanoTime() - start;

        // 4) Добавление в конец коллекции
        start = System.nanoTime();
        deque.addLast(N);
        long timeDequeAddLast = System.nanoTime() - start;

        start = System.nanoTime();
        arrayList.add(N);
        long timeArrayAddLast = System.nanoTime() - start;

        start = System.nanoTime();
        treeSet.add(N);
        long timeTreeAddLast = System.nanoTime() - start;

        // 5) Вывод результатов
        System.out.println("=== AddBenchmark (N = " + N + ") ===\n");
        System.out.println("Добавление в начало:");
        System.out.printf("  ArrayDeque:  %d ns%n", timeDequeAddFirst);
        System.out.printf("  ArrayList :  %d ns%n", timeArrayAddFirst);
        System.out.printf("  TreeSet   :  %d ns%n%n", timeTreeAddFirst);

        System.out.println("Добавление в середину:");
        System.out.printf("  ArrayDeque:  %d ns (эмуляция addLast)%n", timeDequeAddMid);
        System.out.printf("  ArrayList :  %d ns%n", timeArrayAddMid);
        System.out.printf("  TreeSet   :  %d ns%n%n", timeTreeAddMid);

        System.out.println("Добавление в конец:");
        System.out.printf("  ArrayDeque:  %d ns%n", timeDequeAddLast);
        System.out.printf("  ArrayList :  %d ns%n", timeArrayAddLast);
        System.out.printf("  TreeSet   :  %d ns%n", timeTreeAddLast);
    }
}
