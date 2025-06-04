package lr3.listing_6;

public class listing_6_2 {
    public static void main(String[] args) {
        // начальный список пуст
        Node head = null;

        // создаём узлы от 9 до 0, каждый раз вставляя в голову
        for (int i = 9; i >= 0; i--) {
            head = new Node(i, head);
        }

        // проходим по списку и печатаем значения
        Node ref = head;
        while (ref != null) {
            System.out.println("Node value = " + ref.value);
            ref = ref.next;
        }
    }
}
