package leetcode.combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason on 3/13/17.
 */

/**
 * Combination Sum 3
 */
public class M216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0 || k > 9 || n == 0)
            return res;

        int[] nums = new int[9];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        backtrack(res, new ArrayList<Integer>(), nums, k, n, 0, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int k, int n, int curLength, int curIndex){
        if (curLength == k) {
            if (sum(tmp) == n)
                res.add(new ArrayList<>(tmp));
            return;
        }


        for (int i = curIndex; i < nums.length; i++){
            tmp.add(nums[i]);
            backtrack(res, tmp, nums, k, n, curLength + 1, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    private static int sum (List<Integer> list) {
        int sum = 0;
        for (int i: list) {
            sum += i;
        }
        return sum;
    }
}
