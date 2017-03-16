package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaxing on 17-3-15.
 */

/**
 * Binary Tree Inorder Traversal
 */


public class M94 {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        recusive(res, root);
        return res;
    }

    private void recusive(List<Integer> res, TreeNode node){

        if (node.left != null)
            recusive(res, node.left);
        res.add(node.val);
        if (node.right != null)
            recusive(res, node.right);
    }

}
