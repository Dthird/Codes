package leetcode.dp;

/**
 * Created by jason on 3/15/17.
 */

/**
 * Decode Ways
 */
public class M91 {
    public int numDecodings(String s) {
        if (s.length() == 0 )
            return s.length();

        int[] memo = new int[s.length() + 1];
        memo[0] = 1;
        memo[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < s.length() + 1; i++){
            int one = Integer.parseInt(s.substring(i - 1, i));
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (one != 0)
                memo[i] += memo[i - 1];
            if (two >= 10 && two <= 26)
                memo[i] += memo[i - 2];
        }
        return memo[s.length()];
    }

    public static void main(String[] args){
        M91 m91 = new M91();
        m91.numDecodings("0");
    }

}
