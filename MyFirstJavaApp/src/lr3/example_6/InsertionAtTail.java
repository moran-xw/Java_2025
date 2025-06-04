public class InsertionAtTail {
    public static void main(String[] args) {
        Node head = null;  // первая голова списка
        Node tail = null;  // указатель на текущий хвост (последний узел)

        int[] valuesToAdd = {10, 20, 30, 40, 50};

        // Точка останова #1: перед началом вставок, head == null, tail == null
        for (int value : valuesToAdd) {
            // Создаём новый узел (value, null) — будет хвостом
            Node newNode = new Node(value, null);

            if (head == null) {
                // Если список пуст, инициализируем и head, и tail одним узлом
                head = newNode;
                tail = newNode;
            } else {
                // Иначе приписываем новый узел к tail.next, затем обновляем tail
                tail.next = newNode;
                tail = newNode;
            }

            // Точка останова #2: после каждой вставки нового «хвоста».
            System.out.println("Вставили в хвост: " + value);
        }

        // Точка останова #3: весь список построен, head указывает на 10, tail — на 50
        System.out.println("\nСодержимое списка (с головы к хвосту):");
        Node current = head;
        while (current != null) {
            // Точка останова #4: внутри обхода списка, current.value меняется от 10 до 50
            System.out.println(current.value);
            current = current.next;
        }

        // Точка останова #5: после завершения обхода, current == null
        System.out.println("Обход списка завершён.");
    }
}
