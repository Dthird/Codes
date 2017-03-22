package leetcode.dp;

/**
 * Created by jason on 3/22/17.
 */

/**
 * Coin Change
 */
public class M322 {

    public int coinChange(int[] coins, int amount) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;

        int[] memo = new int[amount + 1];

        for (int sum = 1; sum <= amount; sum++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins){
                if (sum >= coin && memo[sum - coin] != Integer.MAX_VALUE){
                    int tmp = memo[sum - coin] + 1;
                    min = Math.min(tmp, min);
                }
            }
            memo[sum] = min;
        }
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }
}
