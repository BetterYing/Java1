class Node{
    public int data;
    public Node next;
    public Node() {

    }
        public Node(int data){
        this.data = data;
    }
}

class LinkedList {
    public Node head;
    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else{
            node.next = this.head;
            this.head = node;
        }
    }
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Node cur = head;
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public void addIndex(int index,int data){
        checkIndex(index);
        Node node = new Node(data);
        Node cur = searchIndex(index);
        if (index == 0){
            addFirst(data);
        } else {
            node.next = cur.next;
            cur.next = node;
        }
    }

    private Node searchIndex(int index) {
        int count = 0;
        Node cur = this.head;
        while (count < index - 1){
            cur = cur.next;
            count++;
        }
        return cur;
    }
    private void checkIndex(int index) {
        if (index < 0 || index > getLength()) {
            throw new IndexOutOfBoundsException("下标不合法");
        }
    }

    public int getLength(){
        int count = 0;
        Node cur = this.head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public boolean contains(int key) {
        Node cur = this.head;
        while(cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void remove(int key) {
        //删除的节点是头节点
        if (this.head.data == key){
            this.head = this.head.next;
        }

        Node prev = searchPrev(key);
        if (prev == null) {
            return;
        }
        Node del = prev.next;
        prev.next = del.next;
    }
    private Node searchPrev(int key){
        Node prev = this.head;
        while(prev.next != null){
            if(prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    public void removeAllKey(int key) {
        Node prev = this.head;//cur的前驱
        Node cur = this.head.next;//要删除的节点
        while(cur != null){
            if (prev.next.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }

    public void clear(){
        this.head = null;
    }

    public void display(){
        //打印链表中的所有元素
        System.out.print("[");
        for (Node cur = this.head;cur != null;cur = cur.next){
            System.out.print(cur.data);
            if (cur.next != null) {
                //如果不是最后一个元素就加上，否则不加
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}
