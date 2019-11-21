import java.util.Scanner;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;
    public TreeNode (char val) {
        this.val = val;
    }
}

public class Main {
    public static int i = 0;
    public static TreeNode buildTree(String str) {
        TreeNode root = null;
        if (str.charAt(i) != '#') {
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = buildTree(str);
            root.right = buildTree(str);
        } else {
            i++;
        }
        return root;
    }

    public static void inOrderTraversal1(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal1(root.left);
        System.out.println(root.val + " ");
        inOrderTraversal1(root.right);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        TreeNode root = buildTree(str);
        inOrderTraversal1(root);
    }
}
