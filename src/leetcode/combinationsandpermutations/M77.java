package leetcode.combinationsandpermutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason on 3/11/17.
 */
public class M77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0)
            return res;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = i + 1;

        backtrack(res, new ArrayList<Integer>(), nums, k, 0, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int k, int curLength, int curIndex){
        if (curLength == k){
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = curIndex; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(res, tmp, nums, k, curLength + 1, i + 1);
            tmp.remove(tmp.size() - 1);
        }

    }




    public static void main(String[] args){
        M77 m77 = new M77();
        System.out.println(m77.combine(4, 2));
    }
}
