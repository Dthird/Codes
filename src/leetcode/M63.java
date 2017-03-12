package leetcode;

/**
 * Created by jason on 3/12/17.
 */
public class M63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++){
            if (obstacleGrid[i][0] == 1)
                break;
            else
                memo[i][0] = 1;
        }

        for (int j = 0; j < n; j++){
            if (obstacleGrid[0][j] == 1)
                break;
            else
                memo[0][j] = 1;
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    continue;
                else {
                    memo[i][j] = (obstacleGrid[i - 1][j] == 1 ? 0 : memo[i-1][j]) + (obstacleGrid[i][j - 1] == 1 ? 0 : memo[i][j - 1]);
                }
            }
        }

        return memo[m - 1][n - 1];

    }

}
