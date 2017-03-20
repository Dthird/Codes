package leetcode.dp;

/**
 * Created by jason on 3/12/17.
 */

/**
 * Jump Game
 */
public class M55 {

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }

    // TLE dp
    public boolean canJump1(int[] nums) {
        if (nums.length < 2)
            return true;
        int[] memo = new int[nums.length];
        memo[0] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (memo[i] == 1) {
                for (int j = 0; j < nums[i]; j++) {
                    memo[i + j + 1] = 1;
                    if (memo[memo.length - 1] == 1)
                        return true;
                }
            }

        }
        return memo[memo.length - 1] == 1;
    }
}
