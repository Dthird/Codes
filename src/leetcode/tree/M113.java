package leetcode.tree;

/**
 * Created by jason on 3/16/17.
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Path Sum 2
 */
public class M113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        dfs(res, new LinkedList<>(), sum, root);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> tmp, int sum, TreeNode node){
        if (node == null)
            return;

        tmp.add(node.val);
        if (sum == node.val && node.left == null && node.right == null){

            res.add(new LinkedList<>(tmp));
            //return; cannot return!!!!!!
        }

        dfs(res, tmp, sum - node.val, node.left);
        dfs(res, tmp, sum - node.val, node.right);
        tmp.remove(tmp.size() - 1);

    }





}
