public class BinarySearchTree {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    public Node root = null;
    public void insert(int key) {
        Node node = new Node(key);
        if(root == null) {
            root = node;
            return;
        }
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (cur.val > key) {
                parent = cur;
                cur = cur.left;
            } else if (cur.val < key){
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

    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }




    public Node search (int key) {
        if (root.val == key) {
            return root;
        }
        Node cur = root;
        while (cur != null) {
            if (cur.val < key) {
                cur = cur.right;
            } else if (cur.val > key) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return null;
    }

    public void remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(cur.val == key) {
                //删除
                removeNode(parent,cur);
                return;
            }else if(cur.val > key) {
                parent = cur;
                cur = cur.left;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }
    }

    /**
     *
     * @param parent 要删除节点的父亲节点
     * @param cur 代表要删除的节点
     */
    public void removeNode(Node parent,Node cur) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.right){
                parent.right = cur.right;
            } else {
                parent.left = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == parent.right) {
                parent.right = cur.left;
            } else {
                parent.left = cur.left;
            }
        } else {
            Node targetParent = cur;
            Node target = cur.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            //cur为右树中最小的元素
            cur.val = target.val;
            if (target == targetParent.left) {
                targetParent.left = target.right;
            } else {
                targetParent.right = target.right;
            }
        }
    }

}
