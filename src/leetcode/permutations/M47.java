package leetcode.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiaxing on 17-3-13.
 */

/**
 * Permutations 2
 */
public class M47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(res, new ArrayList<>(), nums, used);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] used){
        if (nums.length == tmp.size()){
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true){
                continue;
            }
            if(i > 0 && nums[i-1] == nums[i] && !used[i-1]) continue;
            used[i] = true;
            tmp.add(nums[i]);
            backtrack(res, tmp, nums, used);
            used[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
