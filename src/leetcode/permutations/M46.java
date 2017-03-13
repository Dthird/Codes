package leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaxing on 17-3-13.
 */
public class M46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums){
        if (nums.length == tmp.size()){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tmp.contains(nums[i])){
                continue;
            }
            tmp.add(nums[i]);
            backtrack(res, tmp, nums);
            tmp.remove(tmp.size() - 1);
        }

    }
}
