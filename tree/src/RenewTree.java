class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }
}

public class RenewTree {
    //相同的树
    public boolean isSameTree (TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    //另一个树的子树(判断q是否为p的子树)
    public boolean isSubTree (TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return false;
        }
        if (isSameTree(p,q)) return true;
        if (isSameTree(p.left,q)) return true;
        if (isSameTree(p.right,q)) return true;
        return false;
    }

    //二叉树最深深度
    public int maxDepth (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (leftDepth > rightDepth) {
            return leftDepth + 1;
        } else {
            return rightDepth + 1;
        }
    }

    //平衡二叉树
    public boolean isBalanced (TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHigh = maxDepth(root.left);
        int rightHigh = maxDepth(root.right);
        return Math.abs(leftHigh - rightHigh) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    //对称二叉树
    public boolean isSymmetric (TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }
    public boolean isSymmetricChild (TreeNode leftTreeNode, TreeNode rightTreeNode) {
        if (leftTreeNode == null && rightTreeNode != null || leftTreeNode != null && rightTreeNode == null) {
            return false;
        }
        if (leftTreeNode == null && rightTreeNode == null) {
            return true;
        }
        if (leftTreeNode.val != rightTreeNode.val) {
            return false;
        }
        return isSymmetricChild(leftTreeNode.left, rightTreeNode.right) && isSymmetricChild(leftTreeNode.right, rightTreeNode.left);
    }

    //二叉树最近公共祖先
    public TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode leftTreeNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTreeNode = lowestCommonAncestor(root.right, p, q);
        if (leftTreeNode != null && rightTreeNode != null) {
            return root;
        }
        if (leftTreeNode != null) {
            return leftTreeNode;
        }
        if (rightTreeNode != null) {
            return rightTreeNode;
        }
        return null;
    }

}
