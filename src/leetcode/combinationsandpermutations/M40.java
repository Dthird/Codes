package leetcode.combinationsandpermutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jason on 3/11/17.
 */
public class M40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0 || target == 0)
            return res;
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int target, int curIndex){
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (target < 0)
            return;

        for (int i = curIndex; i < nums.length; i++){
            if (i > curIndex && nums[i] == nums[i - 1]) // remove duplicated
                continue;
            tmp.add(nums[i]);
            backtrack(res, tmp, nums, target - nums[i], i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }


}
