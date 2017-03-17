package leetcode.greedy;

/**
 * Created by jason on 3/17/17.
 */

/**
 * Best Time to Buy and Sell Stock 2
 */
public class E122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1)
            return 0;

        int[] memo = new int[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            memo[i] = prices[i + 1] - prices[i];
        }

        int sum = 0;
        for (int e : memo) {
            if (e > 0)
                sum += e;
        }
        return sum;
    }
}
