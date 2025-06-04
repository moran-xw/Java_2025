package lr3;

import java.util.Scanner;

public class example_8 {

    static class Node {
        int value;    // хранимое значение
        Node next;    // ссылка на следующий узел (или null)

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    //  ─────────────────────────────────────────────────────────────────────────
    //  Раздел A: методы с использованием цикла (итеративные)
    //  ─────────────────────────────────────────────────────────────────────────

    public static Node createHead(int[] arr) {
        Node head = null;
        for (int value : arr) {
            head = new Node(value, head);
        }
        return head;
    }
    public static Node createTail(int[] arr) {
        Node head = null;
        Node tail = null;
        for (int value : arr) {
            Node newNode = new Node(value, null);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    /**
     * Возвращает строковое представление списка, сформированного из узлов, итеративно.
     *
     * @param head head списка, который нужно превратить в строку
     * @return строка вида "[val1, val2, val3, …]"
     */
    public static String toString(Node head) {
        if (head == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node cur = head;
        while (cur != null) {
            sb.append(cur.value);
            if (cur.next != null) {
                sb.append(", ");
            }
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Добавляет элемент в начало списка (голова), итеративно.
     *
     * @param head  текущий head списка (может быть null)
     * @param value значение, которое нужно положить в новый первый узел
     * @return новый head списка
     */
    public static Node addFirst(Node head, int value) {
        return new Node(value, head);
    }

    /**
     * Добавляет элемент в конец списка (хвост), итеративно.
     *
     * @param head  текущий head списка (может быть null)
     * @param value значение для нового узла
     * @return head списка (новый, если список был пуст, иначе тот же head)
     */
    public static Node addLast(Node head, int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            return newNode;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        return head;
    }

    /**
     * Вставляет элемент value в позицию index (0-based).
     * Если index = 0, эквивалент addFirst.
     * Если index >= длины списка, добавляет в хвост.
     *
     * @param head  текущий head списка (может быть null)
     * @param index позиция вставки (0-based)
     * @param value значение узла
     * @return новый head списка
     */
    public static Node insert(Node head, int index, int value) {
        if (index <= 0 || head == null) {
            return new Node(value, head);
        }
        Node cur = head;
        int i = 0;
        // Находим узел перед точкой вставки (index - 1) или последний
        while (i < index - 1 && cur.next != null) {
            cur = cur.next;
            i++;
        }
        // Вставляем новый узел после cur
        cur.next = new Node(value, cur.next);
        return head;
    }

    /**
     * Удаляет первый узел списка, итеративно.
     *
     * @param head текущий head списка (может быть null)
     * @return новый head списка (head.next) или null, если список пуст или был из одного узла
     */
    public static Node removeFirst(Node head) {
        if (head == null) {
            return null;
        }
        return head.next;
    }

    /**
     * Удаляет последний узел списка, итеративно.
     *
     * @param head текущий head списка (может быть null)
     * @return head списка после удаления последнего узла
     */
    public static Node removeLast(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            // Если в списке был один элемент, удаляем его => список пуст
            return null;
        }
        Node cur = head;
        // Ищем предпоследний узел
        while (cur.next.next != null) {
            cur = cur.next;
        }
        // Теперь cur.next — это последний узел, удаляем его
        cur.next = null;
        return head;
    }

    /**
     * Удаляет узел на позиции index (0-based), итеративно.
     * Если index = 0, эквивалент removeFirst.
     * Если index >= длины-1, эквивалент removeLast.
     *
     * @param head  текущий head списка (может быть null)
     * @param index индекс узла для удаления (0-based)
     * @return новый head списка
     */
    public static Node remove(Node head, int index) {
        if (head == null) {
            return null;
        }
        if (index <= 0) {
            return head.next;
        }
        Node cur = head;
        int i = 0;
        // Ищем узел перед тем, что хотим удалить (index - 1) или предпоследний
        while (i < index - 1 && cur.next != null && cur.next.next != null) {
            cur = cur.next;
            i++;
        }
        // Если cur.next == null — список короче, нечего удалять
        if (cur.next == null) {
            return head;
        }
        // Иначе удаляем cur.next
        cur.next = cur.next.next;
        return head;
    }

    //  ─────────────────────────────────────────────────────────────────────────
    //  Раздел Б: методы с использованием рекурсии
    //  ─────────────────────────────────────────────────────────────────────────

    /**
     * Рекурсивно создает список, вставляя элементы arr[0], arr[1], … с головы:
     * list = new Node(arr[i], listOfRest)
     *
     * @param arr   массив значений
     * @param index текущий индекс (вызывать с 0)
     * @return head рекурсивно сформированного списка
     */
    public static Node createHeadRec(int[] arr, int index) {
        if (index >= arr.length) {
            return null;
        }
        // Сначала делаем рекурсивный вызов на остатке массива
        Node rest = createHeadRec(arr, index + 1);
        // Затем создаём узел для текущего arr[index], следующий — rest
        return new Node(arr[index], rest);
    }

    /**
     * Рекурсивно создает список, вставляя элементы arr[i] "в хвост" результата createTailRec(arr, i+1).
     *
     * @param arr   массив значений
     * @param index текущий индекс (вызывать с 0)
     * @return head рекурсивно сформированного списка
     */
    public static Node createTailRec(int[] arr, int index) {
        if (index >= arr.length) {
            return null;
        }
        // Создаём новый узел для текущего arr[index]
        Node node = new Node(arr[index], null);
        // Рекурсивно формируем хвост начиная с (index+1)
        node.next = createTailRec(arr, index + 1);
        return node;
    }

    /**
     * Рекурсивно строит строковое представление списка.
     *
     * @param head head списка
     * @return строка вида "[v1, v2, …]"
     */
    public static String toStringRec(Node head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        toStringRecHelper(head, sb);
        sb.append("]");
        return sb.toString();
    }

    // Вспомогательная рекурсивная функция, которая обходит список и дописывает в StringBuilder.
    private static void toStringRecHelper(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.value);
        if (node.next != null) {
            sb.append(", ");
            toStringRecHelper(node.next, sb);
        }
    }

    /**
     * Рекурсивное добавление элемента в начало списка (эквивалент addFirst).
     *
     * @param head  head исходного списка
     * @param value значение для вставки
     * @return новый head списка
     */
    public static Node addFirstRec(Node head, int value) {
        return new Node(value, head);
    }

    /**
     * Рекурсивное добавление элемента в конец списка (эквивалент addLast).
     *
     * @param head  head исходного списка (может быть null)
     * @param value значение для вставки
     * @return head списка после добавления
     */
    public static Node addLastRec(Node head, int value) {
        if (head == null) {
            return new Node(value, null);
        }
        // Рекурсивно идём до последнего узла
        head.next = addLastRec(head.next, value);
        return head;
    }

    /**
     * Рекурсивная вставка value на позицию index (0-based).
     * Если index <= 0, создаём новый head. Если head == null и index > 0, добавляем как новый узел.
     *
     * @param head  head исходного списка
     * @param index позиция для вставки (0-based)
     * @param value значение для вставки
     * @return новый head списка
     */
    public static Node insertRec(Node head, int index, int value) {
        if (index <= 0 || head == null) {
            return new Node(value, head);
        }
        head.next = insertRec(head.next, index - 1, value);
        return head;
    }

    /**
     * Рекурсивное удаление первого узла (эквивалент removeFirst).
     *
     * @param head head исходного списка
     * @return новый head (head.next) или null
     */
    public static Node removeFirstRec(Node head) {
        if (head == null) {
            return null;
        }
        return head.next;
    }

    /**
     * Рекурсивное удаление последнего узла (эквивалент removeLast).
     *
     * @param head head исходного списка
     * @return head после удаления хвостового узла
     */
    public static Node removeLastRec(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        // Рекурсивно обходим до предпоследнего узла
        head.next = removeLastRec(head.next);
        return head;
    }

    /**
     * Рекурсивное удаление узла на позиции index (0-based). Если index <= 0, эквивалент removeFirst.
     * Если head == null, просто возвращаем null.
     *
     * @param head  head исходного списка
     * @param index позиция узла для удаления
     * @return head списка после удаления
     */
    public static Node removeRec(Node head, int index) {
        if (head == null) {
            return null;
        }
        if (index <= 0) {
            return head.next;
        }
        head.next = removeRec(head.next, index - 1);
        return head;
    }

    //  ─────────────────────────────────────────────────────────────────────────
    //  Демонстрационный метод main для проверки всех функций
    //  ─────────────────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1) Ввод количества элементов
        System.out.print("Сколько элементов добавить в список? ");
        int n = scanner.nextInt();

        // 2) Ввод значений для списка
        int[] values = new int[n];
        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            System.out.print("  values[" + i + "] = ");
            values[i] = scanner.nextInt();
        }

        System.out.println("\n── Итеративный режим ─────────────────────────────────────────");
        // 3) Формируем список итеративно "с головы"
        Node headIterHead = createHead(values);
        System.out.println("Список (createHead): " + toString(headIterHead));

        // 4) Формируем список итеративно "с хвоста"
        Node headIterTail = createTail(values);
        System.out.println("Список (createTail): " + toString(headIterTail));

        // 5) Добавляем элемент в начало и конец, вставляем в середину
        headIterTail = addFirst(headIterTail, 999);
        headIterTail = addLast(headIterTail, 777);
        headIterTail = insert(headIterTail, n / 2, 555); // вставляем 555 на позицию n/2
        System.out.println("После addFirst(999), addLast(777), insert(позиция=" + (n / 2) + ", 555):");
        System.out.println("  " + toString(headIterTail));

        // 6) Удаляем первый, последний и узел по индексу 2
        headIterTail = removeFirst(headIterTail);
        headIterTail = removeLast(headIterTail);
        headIterTail = remove(headIterTail, 2);
        System.out.println("После removeFirst(), removeLast(), remove(2):");
        System.out.println("  " + toString(headIterTail));

        System.out.println("\n── Рекурсивный режим ────────────────────────────────────────");
        // 7) Формируем список рекурсивно "с головы"
        Node headRecHead = createHeadRec(values, 0);
        System.out.println("Список (createHeadRec): " + toStringRec(headRecHead));

        // 8) Формируем список рекурсивно "с хвоста"
        Node headRecTail = createTailRec(values, 0);
        System.out.println("Список (createTailRec): " + toStringRec(headRecTail));

        // 9) Добавляем рекурсивно элемент в начало, конец, вставляем в позицию n/2
        headRecTail = addFirstRec(headRecTail, 888);
        headRecTail = addLastRec(headRecTail, 666);
        headRecTail = insertRec(headRecTail, n / 2, 444);
        System.out.println("После addFirstRec(888), addLastRec(666), insertRec(позиция=" + (n / 2) + ", 444):");
        System.out.println("  " + toStringRec(headRecTail));

        // 10) Удаляем рекурсивно первый, последний и узел по индексу 2
        headRecTail = removeFirstRec(headRecTail);
        headRecTail = removeLastRec(headRecTail);
        headRecTail = removeRec(headRecTail, 2);
        System.out.println("После removeFirstRec(), removeLastRec(), removeRec(2):");
        System.out.println("  " + toStringRec(headRecTail));

        scanner.close();
    }
}
