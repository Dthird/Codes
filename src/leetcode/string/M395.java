package leetcode.string;

/**
 * Created by jason on 3/27/17.
 */

/**
 *  Longest Substring with At Least K Repeating Characters
 */
public class M395 {
    public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }

    private int helper(String s, int start, int end, int k){
        if (k <= 0)
            return end - start;
        if (end - start < k)
            return 0;

        int[] letters = new int[26];
        for (int i = start; i < end; i++) {
            letters[s.charAt(i) - 'a']++;
        }
        for (int i = start; i < end; i++) {
            if (letters[s.charAt(i) - 'a'] < k){
                return Math.max(helper(s, start, i, k), helper(s, i + 1, end, k));
            }
        }
        return end - start;
    }
}
