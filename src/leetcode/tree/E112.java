package leetcode.tree;

/**
 * Created by jason on 3/16/17.
 */

/**
 * Path Sum
 */
public class E112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && sum == root.val)
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
