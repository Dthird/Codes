package leetcode.combinationsandpermutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason on 3/13/17.
 */
public class M377_ {
    public int combinationSum4(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0 || target == 0)
            return 0;
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);

        return res.size();
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int target, int curIndex){
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (target < 0)
            return;

        for (int i = curIndex; i < nums.length; i++){
            tmp.add(nums[i]);
            backtrack(res, tmp, nums, target - nums[i], i); // not i + 1
            tmp.remove(tmp.size() - 1);
        }
    }
}
