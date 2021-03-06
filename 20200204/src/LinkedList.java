class Node {
    public int data;
    public Node next;
    public Node(int data) {
        this.data = data;
    }
}

public class LinkedList {
    public Node head;

    //尾插
    public void addLast (int elem) {
        Node node = new Node(elem);
        Node tail = head;
        if (head == null) {
            head = node;
            return;
        }
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    //打印
    public void display() {
        // 打印链表中的所有元素
        System.out.print("[");
        for (Node node = this.head;
             node != null; node = node.next) {
            System.out.print(node.data);
            if (node.next != null) {
                // 如果不是最后一个元素就加上 , 否则不加
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }



    //合并两个单链表
    public Node merge (Node h1,Node h2) {
        Node newHead = new Node(-1);
        Node tail = newHead;
        while (h1 != null && h2 != null) {
            if (h1.data < h2.data) {
                tail.next = h1;
                tail = tail.next;
                h1 = h1.next;
            } else {
                tail.next = h2;
                tail = tail.next;
                h2 = h2.next;
            }
        }
        if (h1 != null) {
            tail.next = h1;
        }
        if (h2 != null) {
            tail.next = h2;
        }
        return newHead.next;
    }

    //判断是否有环
    public boolean isCycle (Node head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //分割链表
    public Node partition (Node head,int x) {
        if (head == null) {
            return null;
        }
        Node smallHead = new Node(-1);
        Node smallTail = smallHead;
        Node bigHead = new Node(-1);
        Node bigTail = bigHead;
        while (head != null) {
            Node next = head.next;
            head.next = null;
            if (head.data < x) {
                smallTail.next = head;
                smallTail = smallTail.next;
                head = next;
            } else {
                bigTail.next = head;
                bigTail = bigHead.next;
                head = next;
            }
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

    //移除链表元素
    public Node remove (Node head,int val) {
        if (head == null) {
            return null;
        }
        //先处理非头节点
        Node prev = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.data == val) {
                prev.next = cur.next;
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (head.data == val) {
            head = head.next;
        }
        return head;
    }

    //回文链表
    public boolean chkPalindrome(Node head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node p = slow.next;
        while (p != null) {
            Node pNext = p.next;
            p.next = slow;
            slow = p;
            p = pNext;
            if (p != null) {
                pNext = p.next;
            }
        }
        while (head != slow) {
            if (head.data != slow.data) {
                return false;
            }
            if (head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    //链表的中间节点
    public Node middleNode (Node head) {
        if (head == null) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
