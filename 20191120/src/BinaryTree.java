//import java.util.*;
//
//class Node {
//    int val;
//    Node left;
//    Node right;
//    Node (int val) {
//        this.val = val;
//    }
//}
//
//public class BinaryTree {
//    // 层序遍历
//    void levelOrderTraversal(Node root) {
//        Queue<Node> queue = new LinkedList<>();
//        if (root != null) {
//            queue.offer(root);
//        }
//        while (!queue.isEmpty()) {
//            Node cur = queue.peek();
//            System.out.println(cur.val + " ");
//            if (cur.left != null) {
//                queue.offer(cur.left);
//            }
//            if (cur.right != null) {
//                queue.offer(cur.right);
//            }
//        }
//    }
//
//    // 判断一棵树是不是完全二叉树
//    boolean isCompleteTree(Node root) {
//        Queue<Node> queue = new LinkedList<>();
//        if (root != null) {
//            queue.offer(root);
//        }
//        return true;
//    }
//
//
//}
