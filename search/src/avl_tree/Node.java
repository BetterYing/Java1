package avl_tree;

public class Node {
    Node left;
    Node right;
    Node parent;

    int key;

    //平衡因子，左子树高度-右子树高度 可选项 -1(右子树高1) 0（两边一样高） 1（左子树高1）
    int bf;

    public Node (int key) {
        this.key = key;
    }

}
