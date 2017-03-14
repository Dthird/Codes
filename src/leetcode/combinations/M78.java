package leetcode.combinations;

/**
 * Created by jason on 3/14/17.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subsets
 */
public class M78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }


    private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int index){
        res.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }

    }

}
