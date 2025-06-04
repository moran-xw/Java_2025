public class InsertionAtTailNoTailVar {
    public static void main(String[] args) {
        Node head = null;
        int[] valuesToAdd = {10, 20, 30, 40, 50};

        // Точка останова #1: перед началом вставок, head == null
        for (int value : valuesToAdd) {
            Node newNode = new Node(value, null);
            if (head == null) {
                head = newNode;
            } else {
                // Ищем текущий «хвост» (последний узел)
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                // temp — последний узел, приписываем новый
                temp.next = newNode;
            }
            // Точка останова #2: после вставки узла, можно проверить, как изменился «хвост»
            System.out.println("Вставили в хвост (без tail): " + value);
        }

        // Точка останова #3: весь список построен
        System.out.println("\nСодержимое списка (с головы к хвосту):");
        Node current = head;
        while (current != null) {
            // Точка останова #4: при каждой итерации вывода текущего узла
            System.out.println(current.value);
            current = current.next;
        }

        // Точка останова #5: после завершения обхода
        System.out.println("Обход списка завершён.");
    }
}
