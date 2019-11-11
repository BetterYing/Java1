class Node {
    public int data;
    public Node next;
    public Node() {

    }
    public Node(int data) {
        this.data = data;
    }
}

public class Test{
    public Node head;
    public boolean hasCycle () {
        if (head == null || head.next == null) {
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

    public Node detectCycle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null && fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node partition (Node head, int x) {
        Node smallHead = new Node(-1);
        Node smallTail = smallHead;
        Node bigHead = new Node(-1);
        Node bigTail = bigHead;
        Node cur = head;
        while(cur != null) {
            Node next = cur.next;
            cur.next = null;
            if (cur.data < x) {
                smallTail = cur;
                cur = next;
                smallTail = smallTail.next;
            } else {
                bigTail = cur;
                cur = next;
                bigTail = bigTail.next;
            }
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

    //反转链表
    public Node reverseList(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node prev = null;
        Node cur = head;
        Node newHead = null;
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

    //移除链表元素
    public Node removeElements(Node head, int val) {
        Node cur = head.next;
        Node prev = head;
        while (cur != null) {
            if (cur.data == val) {
                prev.next = cur.next;
                cur = cur.next;
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

    //合并两个有序链表
    public Node mergeTwoLists(Node l1, Node l2) {
        Node newHead = new Node(-1);
        Node tmp = newHead;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                tmp.next = l1;
                l1 = l1.next;
                tmp = tmp.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
                tmp = tmp.next;
            }
        }
        if (l1 != null) {
            tmp.next = l1;
        }
        if (l2 != null) {
            tmp.next = l2;
        }
        return newHead.next;
    }

    //删除链表中的节点
    public Node deleteDuplication(Node head){
        if (head == null) {
            return null;
        }
        Node newHead = new Node(-1);
        Node tmp = newHead;
        Node cur = head;
        while (cur != null) {
            if (cur.next != null && cur.data == cur.next.data) {
                while (cur.next != null && cur.data == cur.next.data){
                    cur = cur.next;
                }
                cur = cur.next;
                tmp.next = cur;
            } else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    //回文链表
    public boolean isPalindrome(Node head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return  true;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node p = slow.next;
        while (p != null) {
            Node next = p.next;
            p.next = slow;
            slow = p;
            p = next;
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

    //相交链表
    public Node getIntersectionNode(Node headA, Node headB) {



        return null;
    }

    //链表的中间节点
    public Node middleNode() {
        if (head == null) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node middleNode1() {
        int len = size(head) / 2;
        Node cur = head;
        for (int i = 0;i < len; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //链表中倒数第k个节点
    public Node FindKthToTail(Node head,int k) {
        int len = size(head);
        if (head == null || k < 0 || k > len) {
            return null;
        }
        int offset = len - k;
        Node fast = head;
        Node slow = head;
        for (int i = 0;i < offset;i++) {
            fast = fast.next;
        }
        while (fast != null && slow != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public int size(Node head) {
        int count = 0;
        for (Node cur = head;cur != null;cur = cur.next) {
            count++;
        }
        return count;
    }

}
