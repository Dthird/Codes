package leetcode;

/**
 * Created by jason on 3/29/17.
 */

import java.util.Arrays;

/**
 * Minimum Moves to Equal Array Elements II
 */
public class M462 {
    public int minMoves2(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int res1 = 0;
        for (int num : nums) {
            res1 += Math.abs(median - num);
        }
        return res1;
    }

}
