package leetcode.tree;

/**
 * Created by jason on 3/16/17.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Flatten Binary Tree to Linked List
 */
public class M114 {

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        List<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            preorder.add(tmp.val);

            if (tmp.right != null)
                stack.push(tmp.right);
            if (tmp.left != null)
                stack.push(tmp.left);
        }

        TreeNode p = root;
        for (int i = 1; i < preorder.size(); i++){
            p.right = new TreeNode(preorder.get(i));
            p = p.right;
        }
        root.left = null;
        return;
    }
}
