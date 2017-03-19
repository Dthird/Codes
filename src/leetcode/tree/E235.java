package leetcode.tree;

/**
 * Created by jason on 3/19/17.
 */

/**
 * Lowest Common Ancestor of a Binary Search Tree
 */
public class E235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode left, right;
        if (p.val == q.val)
            return q;
        else if (p.val < q.val){
            left = p;
            right = q;
        } else {
            left = q;
            right = p;
        }

        TreeNode node = root;
        while (node != null){
            if (node.val <= right.val && node.val >= left.val){
                return node;
            } else if (node.val < left.val)
                node = node.right;
            else
                node = node.left;
        }
        return null;
    }
}
