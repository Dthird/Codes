package leetcode.array;

/**
 * Created by jason on 3/28/17.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Find All Duplicates in an Array
 */
public class M442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0)
                res.add(Math.abs(nums[i]));
            nums[Math.abs(nums[i]) - 1] *= -1;
        }
        return res;
    }
}
