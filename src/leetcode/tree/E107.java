package leetcode.tree;

/**
 * Created by jason on 3/16/17.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Binary Tree Level Order Traversal 2
 */
public class E107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        queue.addFirst(null);

        List<Integer> tmp = new ArrayList<>();
        while(!queue.isEmpty()){
            if (queue.getLast() == null){
                res.add(0, new ArrayList<Integer>(tmp));
                tmp.clear();
                if (queue.size() == 1)
                    break;
                else {
                    queue.removeLast();
                    queue.addFirst(null);
                    continue;
                }


            }
            TreeNode tmpT = queue.removeLast();
            tmp.add(tmpT.val);
            if (tmpT.left != null)
                queue.addFirst(tmpT.left);
            if (tmpT.right != null)
                queue.addFirst(tmpT.right);

        }
        return res;
    }
}
