class Node {
    char val; // 数据域
    Node left; // 左孩子的引用，常常代表左孩子为根的整棵左子树
    Node right; // 右孩子的引用，常常代表右孩子为根的整棵右子树
    public Node(char val) {
        this.val = val;
    }

}

public class BinaryTree {
    // 前序遍历
    void preOrderTraversal(Node root){
        if (root == null) {
            return;
        }
        System.out.println(root.val + " ");
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
    }

    // 中序遍历
    void inOrderTraversal(Node root){
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
        System.out.println(root.val + " ");
    }

    // 后序遍历
    void postOrderTraversal(Node root){
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.val + " ");
        inOrderTraversal(root.right);
    }

    //求叶子结点个数
    static int leafSize = 0;
    int getLeafSize1(Node root){
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
        return leafSize;
    }

    int getLeafSize2(Node root){
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    int getSize2(Node root){
        if(root == null) {
            return 0;
        }
        return getSize2(root.left) + getSize2(root.right) + 1;
    }

    // 遍历思路-求结点个数
    static int size = 0;
    int getSize1(Node root){
        if(root == null) {
            return 0;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
        return size;
    }

    //人为来创建一个二叉树
    public Node buildTree() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right =  E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }
}
