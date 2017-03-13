package leetcode.permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jiaxing on 17-3-13.
 */

/**
 * Permutation Sequence
 */
public class M60 {
    public String getPermutation(int n, int k) {
        List<Integer> num = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) num.add(i);
        int[] fact = new int[n];  // factorial
        fact[0] = 1;
        for (int i = 1; i < n; i++) fact[i] = i*fact[i-1];
        k = k-1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--){
            int ind = k/fact[i-1];
            k = k%fact[i-1];
            sb.append(num.get(ind));
            num.remove(ind);
        }
        return sb.toString();
    }


    // TLE
    public String getPermutation1(int n, int k) {
        if (n == 0 || k == 0)
            return null;
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        List<StringBuilder> res = new ArrayList<>();
        backtrack(res, new StringBuilder(""), nums, k);
        return res.get(k).toString();
    }

    private void backtrack(List<StringBuilder> res, StringBuilder tmp, int[] nums, int k){
        if (k == res.size()){
            return;
        }

        if (tmp.length() == nums.length){
            res.add(new StringBuilder(tmp.toString()));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tmp.indexOf(String.valueOf(nums[i])) != -1){
                continue;
            }
            tmp.append(nums[i]);
            backtrack(res, tmp, nums, k);
            tmp.deleteCharAt(tmp.length() - 1);
        }

    }
}
