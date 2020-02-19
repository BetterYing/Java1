package search_tree;

public class Tree {
    Node root;
    public void insert (int key) {
        if (root == null) {
            root = new Node(key);
        }
        Node parent = null;
        Node cur = root;
        while (cur != null) {
            if (key == cur.key) {
                throw new  RuntimeException("key重复");
            } else if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        if (key < parent.key) {
            parent.left = new Node(key);
        } else {
            parent.right = new Node(key);
        }
    }
}
