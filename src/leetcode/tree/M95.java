package leetcode.tree;

/**
 * Created by jason on 3/16/17.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Unique Binary Search Tree 2
 */
public class M95 {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0)
            return res;

        res.add(new TreeNode(1));
        TreeNode tRes = null;
        for (int i = 2; i <= n; i++) {
            List<TreeNode> tmp = new ArrayList<>(res);
            res.clear();

            TreeNode node = new TreeNode(i);
            for (TreeNode t: tmp) {
                node.left = t;

                tRes = copyTree(node);
                res.add(tRes);

                TreeNode p = t;
                while (p != null){
                    node.left = p.right;
                    p.right = node;
                    tRes = copyTree(t);
                    res.add(tRes);
                    p.right = node.left;

                    p = p.right;
                }
            }
        }

        return res;
    }

    private TreeNode copyTree(TreeNode t){
        if (t == null)
            return null;

        TreeNode res = new TreeNode(t.val);
        res.left = copyTree(t.left);
        res.right = copyTree(t.right);

        return res;
    }
}
