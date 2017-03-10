package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jason on 3/10/17.
 */
public class M39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        res = helper(candidates, target, 0);
        return res;
    }

    public List<List<Integer>> helper(int[] candidates, int target, int index) {
        List<List<Integer>> res = new ArrayList<>(), t1, t2;
        if (index == candidates.length) {
            return res;
        }
        if (candidates[index] == target) {
            res.add(Arrays.asList(candidates[index]));
            return res;
        } else if (candidates[index] < target) {
            t1 = helper(candidates, target - candidates[index], index);
            t2 = helper(candidates, target - candidates[index], index + 1);
            for (int i = 0; i < t1.size(); i++) {
                t1.get(i).add(0, candidates[index]);
                res.add(t1.get(i));
            }
            for (int i = 0; i < t1.size(); i++) {
                t1.get(i).add(0, candidates[index]);
                res.add(t1.get(i));
            }
            return res;
        } else {
            return res;
        }
    }

}
