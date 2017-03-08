package leetcode;

import java.util.HashMap;

/**
 * Created by jason on 3/8/17.
 */
public class M3 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))){
                j = Math.max(hashMap.get(s.charAt(i)) + 1, j); // case: "bcbccccb"
            }
            hashMap.put(s.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }
        /*
        for (Character c : hashMap.keySet()){
            System.out.println(hashMap.get(c));
        }
        */

        return res;
    }

    public static void main(String[] args){
        M3 m3 = new M3();
        System.out.println(m3.lengthOfLongestSubstring("abcbccbbaa"));
    }
}
