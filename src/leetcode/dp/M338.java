package leetcode.dp;

/**
 * Created by jason on 3/23/17.
 */

/**
 * Count Bits
 */
public class M338 {
    public int[] countBits(int num) {
        int[] memo = new int[num + 1];
        for (int i = 1; i < memo.length; i++){
            memo[i] = memo[i >> 1] + (i & 1);
        }

        return memo;
    }
}
