public class InsertionAtHead {
    public static void main(String[] args) {
        // Сначала список пуст: head = null
        Node head = null;

        // Создадим массив значений, которые хочется добавить в список:
        int[] valuesToAdd = {10, 20, 30, 40, 50};

        // Точка останова #1: перед началом вставок. Здесь head == null.
        // Установка break-point: поставьте «breakpoint» на следующей строке if вы отлаживаете.
        // Например, в IDE кликните слева от строки «for (int value : valuesToAdd)» и запустите Debug.
        for (int value : valuesToAdd) {
            // На каждой итерации создаём новый узел (value, head) и делаем его новой головой:
            head = new Node(value, head);

            // Точка останова #2: здесь после создания нового узла.
            // На каждой итерации head указывает на узел со значением «value», next указывает на предыдущую голову.
            System.out.println("Вставили в голову: " + value);
        }

        // Точка останова #3: построение списка завершено. head указывает на узел со значением 50.
        // Теперь проходим по всему списку и печатаем значение каждого узла.
        System.out.println("\nСодержимое списка (с головы к хвосту):");
        Node current = head;
        while (current != null) {
            // Точка останова #4: внутри цикла while. current.value — текущее значение узла.
            System.out.println(current.value);
            current = current.next;
        }

        // Точка останова #5: здесь конец обхода (current == null).
        System.out.println("Обход списка завершён.");
    }
}

