package leetcode.dp;

/**
 * Created by jason on 3/30/17.
 */

/**
 * Ones and Zeroes
 */
public class M474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        for (String s: strs){
            int ones = count(s)[0];
            int zeroes = count(s)[1];
            for (int i = m; i >= zeroes; i--) {
                for (int j = n; j >= ones; j--) {
                    memo[i][j] = Math.max(memo[i][j], memo[i - zeroes][j - ones] + 1);
                }
            }
        }
        return memo[m][n];
    }

    private int[] count(String s){
        int[] res = new int[2];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - '0']++;
        }
        return res;
    }


    public static void main(String[] args){
        int a = 5;
        System.out.println(Integer.highestOneBit(5));
    }
}
