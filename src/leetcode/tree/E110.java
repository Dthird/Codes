package leetcode.tree;

/**
 * Created by jason on 3/16/17.
 */

/**
 * Balanced Binary Tree
 */
public class E110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        if (Math.abs(depth(root.left, 1) - depth(root.right, 1)) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode node, int d){
        if (node == null)
            return d;

        return Math.max(depth(node.left, d + 1), depth(node.right, d + 1));
    }

}
