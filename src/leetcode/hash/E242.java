package leetcode.hash;

/**
 * Created by jason on 3/19/17.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Valid Anagram
 */
public class E242 {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        for (char c : t.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) - 1);
            else
                return false;
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0)
                return false;
        }
        return true;
    }
}
