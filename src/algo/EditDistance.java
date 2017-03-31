package algo;

/**
 * Created by jason on 3/31/17.
 */
public class EditDistance {

    public int dp(String a, String b) {
        if (a.length() == 0 || b.length() == 0)
            return Math.abs(a.length() - b.length());

        int[][] dp = new int[a.length() + 1][b.length() + 1]; // notice +1
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0){
                    dp[i][j] = j;
                } else if (j == 0){
                    dp[i][j] = i;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) // notice -1
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
            }
        }
        return dp[a.length()][b.length()];
    }

    public int recursion(String a, String b) {
        return recHelper(a, a.length() - 1, b, b.length() - 1);
    }

    private int recHelper(String a, int indexA, String b, int indexB) {
        if (indexA == -1 || indexB == -1)
            return Math.abs(indexA - indexB);
        if (a.charAt(indexA) == b.charAt(indexB))
            return recHelper(a, indexA - 1, b, indexB - 1);
        return 1 + Math.min(recHelper(a, indexA - 1, b, indexB - 1),
                Math.min(recHelper(a, indexA, b, indexB - 1),
                        recHelper(a, indexA - 1, b, indexB - 1)));
    }

    public static void main(String[] args){
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.recursion("ba", "aba"));
        System.out.println(editDistance.dp("ba", "ab"));
    }

}
