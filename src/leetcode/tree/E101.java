package leetcode.tree;

/**
 * Created by jason on 3/16/17.
 */

/**
 * Symmetric Tree
 */
public class E101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right){
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;

        if (left.val != right.val)
            return false;

        return helper(left.left, right.right) && helper(right.left, left.right);
    }
}
