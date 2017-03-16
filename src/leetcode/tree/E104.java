package leetcode.tree;

/**
 * Created by jason on 3/16/17.
 */

/**
 * Maximum Depth of a Binary Tree
 */
public class E104 {

    public int maxDepth(TreeNode root) {
        return helper(root, 0);

    }

    private int helper(TreeNode node, int depth){
        if (node == null)
            return depth;

        return Math.max(helper(node.left, depth + 1), helper(node.right, depth + 1));

    }
}
