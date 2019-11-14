//用单链表实现，采用尾入头出
//不用数组实现的原因：有移动元素存在

class Node {
    public int data;
    public Node next;
    public Node (int data) {
        this.data = data;
    }
}

public class MyQueue {
    public Node head;
    public Node tail;
    public int usedSize;

    //入队
    public void offer(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            this.tail = this.head;
        } else {
            this.tail.next = node;
            this.tail = this.tail.next;
        }
        this.usedSize++;
    }

    //出队
    public int poll() {
        if (this.head == null) {
            return -1;
        }
        int oldData = this.head.data;
        this.head = this.head.next;
        this.usedSize--;
        return oldData;
    }

    //得到队头元素，不删除
    public int peek() {
        if (this.head == null) {
            return -1;
        }
        return this.head.data;
    }

    //得到size
    public int size () {
        return this.usedSize;
    }

    public void display () {
        for (Node cur = this.head;cur != null;cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }

}
