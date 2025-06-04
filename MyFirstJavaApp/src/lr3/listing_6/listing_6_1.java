package lr3.listing_6;

public class listing_6_1 {
    public static void main(String[] args) {
        // создаём четыре узла
        Node node0 = new Node(0, null);
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);

        // устанавливаем связи: node0 → node1 → node2 → node3
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        // проходим по списку и печатаем значения
        Node ref = node0;
        while (ref != null) {
            System.out.println("Node value = " + ref.value);
            ref = ref.next;
        }
    }
}
