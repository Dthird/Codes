package leetcode.tree;

/**
 * Created by jason on 4/6/17.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Find Largest Value in Each Tree Row
 */
public class M515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while (!queue.isEmpty()){
            int tmp = 0, max = Integer.MIN_VALUE;
            for (int i = 0; i < count; i++) {
                TreeNode tmpTree = queue.poll();
                max = Math.max(max, tmpTree.val);
                if (tmpTree.left != null){
                    tmp++;
                    queue.offer(tmpTree.left);
                }
                if (tmpTree.right != null){
                    tmp++;
                    queue.offer(tmpTree.right);
                }
            }
            count = tmp;
            res.add(max);
        }
        return res;
    }

}
