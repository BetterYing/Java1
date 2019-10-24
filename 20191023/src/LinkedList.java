class Node {
    public int data;
    public Node next;
    //？？？？
    public Node() {

    }
    public Node(int data) {
        this.data = data;
    }
}

class LinkedList {
    public Node head;

    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        if(this.head == null) {
            //如果链表为空
            this.head = node;
            //return;
        } else {
            //链表不为空
            node.next = this.head;
            this.head = node;
            //return;
        }
    }

    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        Node cur = this.head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }

    private Node searchIndex(int index) {
        int count = 0;
        Node cur = this.head;
        while (count < index-1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    public boolean addIndex(int index,int data){
        Node node = new Node(data);
        if(index == 0) {
            addFirst(data);
            return true;
        }
        //1、找到index位置的前驱
        Node cur = searchIndex(index);
        //2、插入
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    private Node searchPrev(int key) {
        Node prev = this.head;
        while (prev.next != null){
            if (prev.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        //1、删除的节点是头节点
        if(this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        //2、不是头节点
        Node prev = searchIndex(key);
        if (prev == null) {
            return;
        }
        Node cur = prev.next;
        while (cur != null){
            prev.next = cur.next;
        }

    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node prev = this.head;//cur的前驱
        Node cur = this.head.next;//要删除的节点
        while (cur != null) {
            if (prev.next.data == key) {
                prev.next = cur.next;
                cur = prev.next;
            } else {
                cur = cur.next;
                prev = cur;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }


    public void display() {
        for (Node cur = this.head;cur != null;cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }

    public boolean contains(int toFind){
        Node cur = new Node();
        while(cur != null) {
            if (cur.data == toFind){
                return true;
            }
            cur = cur.next;
        }
        return  false;
    }

    public int getLength() {
        Node cur = head;
        int count = 0;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }


    public Node reverseList() {
        if (head == null) {
            return null;
        }
        Node prev = null;
        Node cur = head;
        Node newHead = null;
        while (cur != null) {
            Node curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public void display2(Node newHead){
        for (Node cur = newHead;cur != null;cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }

    public Node middleNode() {
        Node cur = head;
        int mid = getLength() / 2;
        for(int i = 0;i < mid;i++){
            cur = cur.next;
        }
        return cur;
    }

    public Node middleNode2(){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node findKthTail1(int k) {
        if (k < 0 || k > getLength()){
            return null;
        }
        Node fast = head;
        Node slow = head;
        int step = getLength() - k;
        for (int i = 0;i < step;i++){
            fast = fast.next;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node findKthTail(int k) {
        if (k < 0 || k > getLength()) {
            return null;
        }
        Node slow = head;
        int step = getLength() - k;
        for (int i = 0; i < step; i++) {
            slow = slow.next;
        }
        return slow;

    }

    public Node partition(int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node cur = this.head;
        while (cur != null) {
            if(cur.data < x) {
                //第一次插入到beforeStart
                if(beforeStart == null) {
                    beforeStart = cur;
                    beforeEnd = cur;
                }else {
                    beforeEnd.next = cur;
                    beforeEnd = beforeEnd.next;
                }
            } else {
                //cur.data >= x
                if (afterStart == null) {
                    afterStart = cur;
                    afterEnd = cur;
                } else {
                    afterEnd.next = cur;
                    afterEnd = afterEnd.next;
                }
            }
            cur = cur.next;
        }
        if (beforeStart == null){
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }
}
