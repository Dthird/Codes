package leetcode.tree;

/**
 * Created by jason on 3/17/17.
 */

import java.util.Stack;

/**
 * Sum Root to Leaf Numbers
 */
public class M129 {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        TreeNode cur = null;

        stack.push(root);

        while (!stack.isEmpty()){
            cur = stack.pop();

            if (cur.left == null && cur.right == null)
                sum += cur.val;

            if (cur.right != null){
                cur.right.val += cur.val * 10;
                stack.push(cur.right);
            }
            if (cur.left != null){
                cur.left.val += cur.val * 10;
                stack.push(cur.left);
            }

        }
        return sum;

    }


}
