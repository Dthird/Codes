package leetcode.array;

/**
 * Created by jason on 3/22/17.
 */

/**
 * Increasing Triplet Subsequence
 */
public class M334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;

        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums){
            if (n <= small)
                small = n;
            else if (n <= big)
                big = n;
            else
                return true;
        }
        return false;
    }

}
