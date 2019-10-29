class Node {
    public int data;
    public Node next;
    public Node prev;
    public Node(int data) {
        this.data = data;
    }
}

public class DoubleListed {
    public Node head;//头
    public Node last;//尾

    public DoubleListed() {
        this.head = null;
        this.last = null;
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        //1、判断是否是第一次插入
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            //2、不是第一次插入
            node.next = this.head;
            this.head.prev = node;//node.next.prev = node;
            this.head = node;
        }
    }

    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("index不合法");
        }
    }

    public boolean addIndex(int index, int data) {
        checkIndex(index);
        Node node = new Node(data);
        Node cur = this.head;
        if (index == 0) {
            addFirst(data);
        } else if (index == size()) {
            addLast(data);
        } else {
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            node.next = cur;
            node.prev = cur.prev;
            cur.prev = node;
            node.prev.next = node;
        }
        return false;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    public int size() {
        int count = 0;
        for (Node cur = this.head; cur != null; cur = cur.next) {
            count++;
        }
        return count;
    }

    public void display() {
        for (Node cur = this.head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }


    //删除第一次出现关键字为key的节点
    public int remove(int key){
        Node cur = this.head;
        int oldData = -1;
        while (cur != null) {
            if(cur.data == key) {
                oldData = cur.data;
                //删除的节点是头节点
                if(cur == this.head) {
                    this.head = cur.next;
                    this.head.prev = null;
                }else {
                    //不是头节点
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }else {
                        this.last = cur.prev;
                    }
                    cur.prev.next = cur.next;
                }
                return oldData;
            }
            cur = cur.next;
        }
        return oldData;
    }

    public void removeAll(int k) {
        Node cur = this.head;
        while (cur != null) {
            if(cur.data == k) {
                //删除的节点是头节点
                if(cur == this.head) {
                    this.head = cur.next;
                    this.head.prev = null;
                }else {
                    //不是头节点
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }else {
                        this.last = cur.prev;
                    }
                    cur.prev.next = cur.next;
                }
            }
            cur = cur.next;
        }
    }



}
