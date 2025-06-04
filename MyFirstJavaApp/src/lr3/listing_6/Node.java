package lr3.listing_6;

public class Node {
    public int value;   // значение текущего узла
    public Node next;   // ссылка на следующий узел или null, если узел последний

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
