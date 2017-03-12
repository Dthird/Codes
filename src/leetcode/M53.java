package leetcode;

/**
 * Created by jason on 3/11/17.
 */
public class M53 {
    public int maxSubArray(int[] nums) {
        int cur = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            max = Math.max(cur, max);
        }
        return max;
    }
}
