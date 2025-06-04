package lr3.comparing_collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.TreeSet;

public class RemoveBenchmark {
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

        // 2) Удаление из начала коллекции
        long start = System.nanoTime();
        deque.removeFirst();
        long timeDequeRemoveFirst = System.nanoTime() - start;

        start = System.nanoTime();
        arrayList.remove(0);
        long timeArrayRemoveFirst = System.nanoTime() - start;

        start = System.nanoTime();
        treeSet.pollFirst();
        long timeTreeRemoveFirst = System.nanoTime() - start;

        // 3) Удаление из середины коллекции (индекс N/2, эмуляция для deque: remove(Object))
        int mid = N / 2;
        start = System.nanoTime();
        deque.remove(mid);
        long timeDequeRemoveMid = System.nanoTime() - start;

        start = System.nanoTime();
        arrayList.remove(mid);
        long timeArrayRemoveMid = System.nanoTime() - start;

        start = System.nanoTime();
        treeSet.remove(mid);
        long timeTreeRemoveMid = System.nanoTime() - start;

        // 4) Удаление из конца коллекции
        start = System.nanoTime();
        deque.removeLast();
        long timeDequeRemoveLast = System.nanoTime() - start;

        start = System.nanoTime();
        arrayList.remove(arrayList.size() - 1);
        long timeArrayRemoveLast = System.nanoTime() - start;

        start = System.nanoTime();
        treeSet.pollLast();
        long timeTreeRemoveLast = System.nanoTime() - start;

        // 5) Вывод результатов
        System.out.println("=== RemoveBenchmark (N = " + N + ") ===\n");
        System.out.println("Удаление из начала:");
        System.out.printf("  ArrayDeque:  %d ns%n", timeDequeRemoveFirst);
        System.out.printf("  ArrayList :  %d ns%n", timeArrayRemoveFirst);
        System.out.printf("  TreeSet   :  %d ns%n%n", timeTreeRemoveFirst);

        System.out.println("Удаление из середины:");
        System.out.printf("  ArrayDeque:  %d ns (эмуляция remove(Object))%n", timeDequeRemoveMid);
        System.out.printf("  ArrayList :  %d ns%n", timeArrayRemoveMid);
        System.out.printf("  TreeSet   :  %d ns%n%n", timeTreeRemoveMid);

        System.out.println("Удаление из конца:");
        System.out.printf("  ArrayDeque:  %d ns%n", timeDequeRemoveLast);
        System.out.printf("  ArrayList :  %d ns%n", timeArrayRemoveLast);
        System.out.printf("  TreeSet   :  %d ns%n", timeTreeRemoveLast);
    }
}
