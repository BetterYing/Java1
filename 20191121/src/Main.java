class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Main {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ret = maxDepth(root.left);
        int ret1 = maxDepth(root.right);
        return ret > ret1 ? ret + 1 : ret1 + 1;
    }

}
