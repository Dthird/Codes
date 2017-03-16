package leetcode.tree;

/**
 * Created by jason on 3/16/17.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Populating Next Right Pointers in Each Node
 */
public class M116 {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return ;

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);

        int flag = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            int level = queue.size();
            TreeLinkNode pre = queue.poll();
            if (pre.left != null)
                queue.offer(pre.left);
            if (pre.right != null)
                queue.offer(pre.right);
            for (int i = 1; i < level; i++) {
                TreeLinkNode tmpT = queue.poll();
                if (tmpT.left != null)
                    queue.offer(tmpT.left);
                if (tmpT.right != null)
                    queue.offer(tmpT.right);
                pre.next = tmpT;
                pre = tmpT;
            }

        }
        return ;
    }
}
