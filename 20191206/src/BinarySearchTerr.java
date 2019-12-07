public class BinarySearchTerr {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node (int val) {
            this.val = val;
        }
    }

    public Node root = null;
    public void insert (int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            return;
        }
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (cur.val > key) {
                parent = cur;
                cur = cur.left;
            } else if (cur.val < key) {
                parent = cur;
                cur = cur.right;
            } else {
                return;
            }
        }
        if (parent.val > key) {
            parent.left = node;
        }
        if (parent.val < key) {
            parent.right = node;
        }
    }

    //中序遍历
    public void inorder (Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    //删除
    public void remove (int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (cur.val == key) {
                removeNode(parent,cur);
                return;
            } else if (cur.val > key) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
    }
    //parent代表要删除节点的父节点
    //cur代表要删除的节点
    public void removeNode(Node parent,Node cur) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            Node targetParent = cur;
            Node target = cur.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            if (target == targetParent.left) {
                targetParent.left = target.right;
            } else {
                targetParent.right = target.right;
            }
        }
    }

    //查找
    public int search (int key) {
        if (root.val == key) {
            return root.val;
        }
        Node cur = root;
        while (cur != null) {
            if (cur.val < key) {
                cur = cur.right;
            } else if (cur.val > key) {
                cur = cur.left;
            } else {
                return cur.val;
            }
        }
        return 0;
    }
}
