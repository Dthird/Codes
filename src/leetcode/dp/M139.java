package leetcode.dp;

/**
 * Created by jason on 3/17/17.
 */

import java.util.List;

/**
 * Word Break
 */
public class M139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                }
            }
        }
        return memo[s.length()];
    }
}
