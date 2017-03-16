package leetcode.tree;

/**
 * Created by jason on 3/16/17.
 */

/**
 * Validate Binary Search Tree
 */
public class M98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }


    // failed case: [10,5,null,3,11]
    public boolean isValidBST1(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null){
            return true;
        }

        if (root.left != null && root.val < root.left.val)
            return false;

        if (root.right != null && root.val > root.right.val)
            return false;

        return isValidBST(root.left) && isValidBST(root.right);
    }
}
