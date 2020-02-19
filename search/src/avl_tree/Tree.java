package avl_tree;

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
            cur = parent.left = new Node(key);
            cur.parent = parent;
        } else {
            cur = parent.right = new Node(key);
            cur.parent = parent;
        }

        while (cur != null) {
            if (cur == parent.left) {
                parent.bf++;
            } else {
                parent.bf--;
            }

            if (parent.bf == 0) {
                break;
            } else if (parent.bf == 1) {
                cur = parent;
                parent = parent.parent;
            } else if (parent.bf == -1) {
                cur = parent;
                parent = parent.parent;
            } else if (parent.bf == 2) {



            } else {



            }
        }
    }
}
