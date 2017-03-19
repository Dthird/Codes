package leetcode.tree;

/**
 * Created by jason on 3/19/17.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Paths
 */
public class E257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        dfs(res, new ArrayList<>(), root);
        return res;
    }

    private void dfs(List<String> res, List<Integer> tmp, TreeNode node){
        if (node.left == null && node.right == null){
            tmp.add(node.val);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(tmp.get(0)));
            for (int i = 1; i < tmp.size(); i++) {
                stringBuilder.append("->").append(tmp.get(i));
            }
            //if (!res.contains(stringBuilder.toString()))
            res.add(stringBuilder.toString());
            return;
        }

        tmp.add(node.val);
        if (node.left != null) {
            dfs(res, tmp, node.left);
            tmp.remove(tmp.size() - 1);
        }
        if (node.right != null) {
            dfs(res, tmp, node.right);
            tmp.remove(tmp.size() - 1);
        }

        /* compare the difference
        if (node.left != null)
            dfs(res, tmp, node.left);
        if (node.right != null)
            dfs(res, tmp, node.right);
        tmp.remove(tmp.size() - 1);
        */

    }
}
