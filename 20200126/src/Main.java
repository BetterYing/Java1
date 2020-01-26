class Node {
    public int data;
    public Node next;
    public Node(int data) {
        this.data = data;
    }
}

public class Main {
    public Node head;
    public Node merge (Node head1,Node head2) {
        Node newHead = new Node(0);
        Node tail = newHead;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                tail.next = head1;
                tail = tail.next;
                head1 = head1.next;
            } else {
                tail.next = head2;
                tail = tail.next;
                head2 = head2.next;
            }
        }
        if (head1 == null) {
            tail.next = head2;
        }
        if (head2 == null) {
            tail.next = head1;
        }
        return newHead.next;
    }
}
