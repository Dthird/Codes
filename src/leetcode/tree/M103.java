package leetcode.tree;

/**
 * Created by jason on 3/16/17.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Zigzag Level Order Traversal
 */
public class M103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int flag = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            int level = queue.size();

            for (int i = 0; i < level; i++) {
                TreeNode tmpT = queue.poll();
                if (tmpT.left != null)
                    queue.offer(tmpT.left);
                if (tmpT.right != null)
                    queue.offer(tmpT.right);
                if (flag == 0)
                    tmp.addLast(tmpT.val);
                else
                    tmp.addFirst(tmpT.val);

            }
            flag = 1 - flag;
            res.add(tmp);
        }
        return res;
    }


}
