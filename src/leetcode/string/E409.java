package leetcode.string;

/**
 * Created by jason on 3/27/17.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Palindrome
 */
public class E409 {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        int res = 0;
        boolean flag = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0)
                res += entry.getValue();
            else{
                res += entry.getValue() - 1;
                flag = true;
            }
        }
        if (flag)
            return res + 1;
        return res;
    }
}
