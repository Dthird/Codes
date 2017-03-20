package leetcode.hash;

import java.util.*;

/**
 * Created by jason on 3/11/17.
 */

/**
 * Group Anagrams
 */
public class M49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Arrays.sort(strs);
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<String>(Arrays.asList(s)));
            else
                map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
