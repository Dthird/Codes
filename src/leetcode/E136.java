package leetcode;

/**
 * Created by jason on 3/17/17.
 */

/**
 * Single Number
 */
public class E136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

}
