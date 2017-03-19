package leetcode.tree;

/**
 * Created by jason on 3/18/17.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Preorder Traversal
 */
public class M144 {


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode node){
        if (node == null)
            return;

        res.add(node.val);
        helper(res, node.left);
        helper(res, node.right);

    }

}
