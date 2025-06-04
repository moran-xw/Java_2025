package lr3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class example_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество человек N: ");
        int N = scanner.nextInt();
        scanner.close();

        // Моделируем задачу «Иосифа» с помощью ArrayList
        long startArray = System.nanoTime();
        int survivorArray = josephusWithArrayList(N);
        long endArray = System.nanoTime();
        long timeArray = endArray - startArray;

        // Моделируем задачу «Иосифа» с помощью LinkedList
        long startLinked = System.nanoTime();
        int survivorLinked = josephusWithLinkedList(N);
        long endLinked = System.nanoTime();
        long timeLinked = endLinked - startLinked;

        System.out.println("\nРезультаты моделирования:");
        System.out.printf("  Оставшийся человек (ArrayList)  = %d, время = %d μс%n",
                survivorArray, timeArray / 1_000);
        System.out.printf("  Оставшийся человек (LinkedList) = %d, время = %d μс%n",
                survivorLinked, timeLinked / 1_000);

        System.out.println("\nВывод:");
        if (timeArray < timeLinked) {
            System.out.println("  ArrayList показал лучшую производительность.");
        } else if (timeLinked < timeArray) {
            System.out.println("  LinkedList показал лучшую производительность.");
        } else {
            System.out.println("  Время работы примерно одинаковое.");
        }
        System.out.println("  Причина: у ArrayList удаление по индексу (сдвиг оставшихся элементов) при большом N становится дорогостоящим,");
        System.out.println("  тогда как у LinkedList при обходе с Iterator удаление происходит за O(1) при текущей позиции. Однако сам перебор по связному списку");
        System.out.println("  тоже может быть менее эффективен из-за кеш-промахов при последовательном доступе. Реальная разница зависит от N и от конкретной JVM.");
    }

    /**
     * Решение задачи «Иосифа» (каждый второй вычеркивается) с помощью ArrayList.
     * @param N количество человек
     * @return номер оставшегося человека (1..N)
     */
    private static int josephusWithArrayList(int N) {
        // Заполняем список значениями 1..N
        List<Integer> circle = new ArrayList<>(N);
        for (int i = 1; i <= N; i++) {
            circle.add(i);
        }

        int index = 0;
        // Пока не останется один элемент, удаляем каждый второй
        while (circle.size() > 1) {
            // Вычисляем индекс второго человека: (index + 1) % size
            index = (index + 1) % circle.size();
            circle.remove(index);
            // После удаления следующий «новый» текущий — тот, что стоит на месте index (он сместился),
            // и потому следующий «прыжок» будет опять +1 от этого индекса.
        }

        return circle.get(0);
    }

    private static int josephusWithLinkedList(int N) {
        LinkedList<Integer> circle = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            circle.add(i);
        }

        Iterator<Integer> it = circle.iterator();
        // Пока список не сократится до одного элемента
        while (circle.size() > 1) {
            // Если итератор закончился, создаём новый для начала списка
            if (!it.hasNext()) {
                it = circle.iterator();
            }
            // Пропускаем одного человека
            it.next();

            // Если после пропуска нет следующего (то есть мы на последнем),
            // то начинаем итератор заново, чтобы «удалить» первого
            if (!it.hasNext()) {
                it = circle.iterator();
            }
            // Тот, на ком сейчас стоит итератор, — второй человек, его удаляем
            it.next();
            it.remove();
        }

        // В списке остался один элемент
        return circle.getFirst();
    }
}
