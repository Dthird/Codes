package leetcode;

/**
 * Created by jiaxing on 17-3-13.
 */

/**
 * Climbing Stairs
 */
public class E70 {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 0)
            return 1;

        int[] memo = new int[n + 1];
        memo[0] = memo[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }
}
