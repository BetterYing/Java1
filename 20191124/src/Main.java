import java.util.*;
//最近公共祖先
class Node {
    int val;
    Node left; // 左孩子的引用，常常代表左孩子为根的整棵左子树
    Node right; // 右孩子的引用，常常代表右孩子为根的整棵右子树
    public Node(int val) {
        this.val = val;
    }
}
public class Main{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = buildTree(sc);
        Node node = Convert(root);
        display(node);
    }

    public static Node buildTree(Scanner sc) {
        int fa = sc.nextInt(),left = sc.nextInt(),right = sc.nextInt() ;
        Node node = new Node(fa);
        if (left != 0) {
            node.left = buildTree(sc);
        }
        if (right != 0) {
            node.right = buildTree(sc);
        }
        return node;
    }

    public static Node Convert (Node pRoot) {
        if (pRoot == null) {
            return null;
        }
        ConvertChild (pRoot);
        Node head = pRoot;
        while (head != null && head.left != null) {
            head = head.left;
        }

        return head;
    }

    public static Node prev = null;
    public static void ConvertChild (Node root) {
        if (root == null) {
            return ;
        }
        ConvertChild (root.left);
        root.left = prev;
        if (prev != null) {
            prev.right = root;
        }
        prev = root;
        ConvertChild (root.right);
    }
    public static void display(Node head) {
        for (Node cur = head;cur != null;cur = cur.right) {
            System.out.print(cur.val + " ");
        }
        System.out.println();
    }
}