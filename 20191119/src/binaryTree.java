import java.util.ArrayList;
import java.util.List;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class binaryTree {
    //前序
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        List<Integer> left = preorderTraversal(root.left);
        list.addAll(left);
        List<Integer> right = preorderTraversal(root.right);
        list.addAll(right);
        return list;
    }

    //中序
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<Integer> left = inorderTraversal(root.left);
        list.addAll(left);
        list.add(root.val);
        List<Integer> right = inorderTraversal(root.right);
        list.addAll(right);
        return list;
    }

    //后序
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<Integer> left = postorderTraversal(root.left);
        list.addAll(left);
        List<Integer> right = postorderTraversal(root.right);
        list.addAll(right);
        list.add(root.val);
        return list;
    }

    //两个二叉树是否相等
    public boolean isSameTree(TreeNode p, TreeNode q) {
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

    //另一棵树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        if (isSameTree(s,t)) {
            return true;
        }
        if (isSubtree(s.left,t)) {
            return true;
        }
        if (isSubtree(s.right,t)) {
            return true;
        }
        return false;
    }

    //树的深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ret = maxDepth(root.left);
        int ret1 = maxDepth(root.right);
        return ret > ret1 ? ret + 1 : ret1 + 1;
    }

    //平衡树
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int ret = maxDepth(root.left);
        int ret1 = maxDepth(root.right);
        if (ret - ret1 >= 2 || ret1 - ret >= 2) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    //镜像树
    public boolean isSymmetricChild(TreeNode leftTree, TreeNode rightTree) {
        if(leftTree == null && rightTree!=null || leftTree != null && rightTree==null) {
            return false;
        }
        if(leftTree == null && rightTree==null) {
            return true;
        }
        if (leftTree.val != rightTree.val) {
            return false;
        }
        return isSymmetricChild(leftTree.left,rightTree.right) && isSymmetricChild(leftTree.right,rightTree.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }

}
