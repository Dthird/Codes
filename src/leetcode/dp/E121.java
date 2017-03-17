package leetcode.dp;

/**
 * Created by jason on 3/17/17.
 */

/**
 * Best Time to Buy and Sell Stock
 */
public class E121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1)
            return 0;

        int[] memo = new int[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            memo[i] = prices[i + 1] - prices[i];
        }

        return maxSub(memo);
    }

    private int maxSub(int[] nums){
        int max = 0, cur = 0;
        for (int e: nums) {
            cur = Math.max(0, cur + e);
            max = Math.max(max, cur);
        }
        return max;
    }
}
