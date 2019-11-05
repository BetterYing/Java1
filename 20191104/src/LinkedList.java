class Node {
    public int data;
    public Node next;
    public Node() {

    }
    public Node(int data) {
        this.data = data;
    }
}

public class LinkedList {
    public Node head;
    public Node findKthToTail (int k) {
        if (k < 0 || k > size()) {
            return null;
        }
        int len = size() - k;
        Node fast = this.head;
        Node slow = this.head;
        for (int i = 0;i < len;i++) {
            fast = fast.next;
        }
        while (fast != null ) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }



    public int size() {
        int count = 0;
        for (Node cur = head;cur != null;cur = cur.next) {
            count++;
        }
        return count;
    }

    public Node mergeTwoLists1(Node headA, Node headB) {
        if (headA == null) {
            return headB;
        }
        if (headB == null) {
            return  headA;
        }
        Node newHead = new Node(-1);
        Node tail = newHead;
        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
                tail.next = headA;
                headA = headA.next;
                tail = tail.next;
            } else {
                tail.next = headB;
                headB = headB.next;
                tail = tail.next;
            }
        }
        if (headA == null) {
            tail.next = headB;
        }
        if (headB == null) {
            tail.next = headA;
        }
        return newHead.next;
    }

    public Node mergeTwoLists(Node headA, Node headB) {
        Node newHead = new Node(-1);
        Node tail = newHead;
        while(headA != null && headB != null) {
            if (headA.data < headB.data) {
                tail.next = headA;
                headA = headA.next;
                tail = tail.next;
            } else {
                tail.next = headB;
                headB = headB.next;
                tail = tail.next;
            }
        }
        if (headA != null) {
            tail.next = headA;
        }
        if (headB != null) {
            tail.next = headB;
        }
        return newHead.next;
    }

    public Node reverseList(Node head) {
        Node newHead = null;
        Node cur = head;
        Node prev = null;
        while (cur != null) {
            Node next = cur.next;
            if (next == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return newHead;
    }

}
