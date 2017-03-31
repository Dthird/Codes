package algo;

/**
 * Created by jason on 3/31/17.
 */
public class Knapsack {
    public int dp(int[] wt, int W, int[] val, int n){
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (w < wt[i - 1])
                    dp[i][w] = dp[i - 1][w];
                else
                    dp[i][w] = Math.max(dp[i - 1][w], val[i - 1] + dp[i - 1][w - wt[i - 1]]);
            }
        }
        return dp[n][W];
    }

    public int recursion(int[] wt, int W, int[] val, int n){
        if (W == 0 || n == 0)
            return 0;
        if (wt[n - 1] > W)
            return recursion(wt, W, val, n - 1);
        return Math.max(recursion(wt, W, val, n - 1), val[n -1] + recursion(wt, W - wt[n - 1], val, n - 1));
    }

    public static void main(String[] args){
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.dp(wt, W, val, val.length));
    }
}
