package leetcode;

/**
 * Created by jason on 3/8/17.
 */

/**
 * Longest Common Prefix
 */
public class E14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++){
            res = commonPrefix(res, strs[i]);
        }
        return res;
    }

    public String commonPrefix(String s1, String s2){
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < s1.length() && i < s2.length(); i++){
            if (s1.charAt(i) == s2.charAt(i)){
                s.append(s1.charAt(i));
            } else {
                break;
            }
        }
        return s.toString();
    }
}
