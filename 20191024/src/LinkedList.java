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

    public void addLast(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
        } else {
            Node cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public void display(){
        Node cur = head;
        while(cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }



    public Node deleteDuplication() {
        Node newHead = new Node(-1);
        Node tmp = newHead;
        Node cur = this.head;
        while (cur != null) {
            if (cur.next != null && cur.data == cur.next.data) {
                while (cur.next != null && cur.data == cur.next.data) {
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

    /**
     * 1、定义两个引用，目的：找到单链表的中间位置
     * 2、进行翻转，翻转的是后半部分
     * 3、一个head从头开始走，slow从尾巴开始走
     * 4、只要发现对应的data不相同，那么就不是回文
     * @return
     */

    public boolean chkPalindrome(){
        if (this.head == null) {
            return false;
        }
        if (this.head.next == null){
            return true;
        }
        Node slow = this.head;
        Node fast = this.head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow走完后已经在中间。

        //翻转
        Node p = slow.next;
        while(p != null) {
            Node pNext = p.next;
            p.next = slow;
            slow = p;
            p = pNext;
            if (p != null) {
                pNext = p.next;
            }
        }

        //进行判断
        while (this.head != slow) {
            if (this.head.data != slow.data) {
                return false;
            }
            if (this.head.next == slow){
                return true;
            }
            this.head = this.head.next;
            slow = slow.next;
        }
        return true;
    }



}
