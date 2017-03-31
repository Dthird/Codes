package algo;

/**
 * Created by jason on 3/31/17.
 */
public class EggDropping {

    public int recursion(int eggs, int floors) {
        if (eggs == 0)
            return -1;
        if (eggs == 1)
            return floors;
        if (floors == 0 || floors == 1)
            return floors;

        int min = Integer.MAX_VALUE, res = 0;
        for (int i = 1; i <= floors; i++) {
            res = Math.max(recursion(eggs - 1, i - 1), recursion(eggs, floors - i));
            min = Math.min(min, res);
        }
        return min + 1;
    }

    public int dp(int eggs, int floors) {
        if (eggs == 0)
            return -1;
        if (floors == 0 || floors == 1)
            return floors;
        int[][] dp = new int[eggs + 1][floors + 1];
        for (int i = 1; i <= eggs; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }

        // We always need j trials for one egg and j floors.
        for (int j = 1; j <= floors; j++)
            dp[1][j] = j;

        for (int i = 2; i <= eggs; i++) {
            for (int j = 2; j <= floors; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    int res = 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]); // notice 1 +
                    dp[i][j] = Math.min(dp[i][j], res);
                }
            }
        }
        return dp[eggs][floors];
    }

    public static void main(String[] args) {
        EggDropping eggDropping = new EggDropping();
        System.out.println(eggDropping.recursion(2, 10));
        System.out.println(eggDropping.dp(2, 39));
    }
}
