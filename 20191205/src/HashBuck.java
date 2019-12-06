public class HashBuck {
    static class Node {
        public int key;
        public int val;
        public Node next;

        public Node(int key,int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array;
    public int usedSize;
    public HashBuck() {
        this.array = new Node[10];
        this.usedSize = 0;
    }

    public void put(int key,int val) {
        int index = key % array.length;
        for(Node cur = array[index];cur != null;cur = cur.next) {
            if (cur.key == key) {
                cur.val = val;
                return;
            }
        }
        Node node = new Node(key,val);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;

        if (loadFactor() >= 0.75) {
            resize();
        }
    }
    private double loadFactor() {
        return this.usedSize * 1.0 / array.length;
    }

    public void resize() {
        Node[] newArray = new Node[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            Node curNext;
            for (Node cur = array[i];cur != null;cur = curNext) {
                curNext = cur.next;
                int index = cur.key % newArray.length;

                cur.next = newArray[index];
                newArray[index] = cur;

            }
        }
        array = newArray;
    }

    public int get (int key) {
        int index = key % array.length;
        for (Node cur = array[index];cur != null;cur = cur.next) {
            if (cur.key == key) {
                return cur.val;
            }
        }
        return -1;
    }
}
