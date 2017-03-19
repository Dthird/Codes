package leetcode.tree;

/**
 * Created by jason on 3/19/17.
 */

/**
 * Invert Binary Tree
 */
public class E226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
