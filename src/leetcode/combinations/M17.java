package leetcode.combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason on 3/8/17.
 */

/**
 * Letter Combinations of a Phone Number
 */
public class M17 {
    private String[] map = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>(), tmp;
        if (digits.length() == 0){
            return null;
        }
        if (digits.length() == 1){
            for (char c : map[digits.charAt(0) - '0'].toCharArray()){
                res.add("" + c);
            }
            return  res;
        }

        tmp = letterCombinations(digits.substring(0, digits.length() - 1));
        for (char c : map[digits.charAt(digits.length() - 1) - '0'].toCharArray()){
            for (String s : tmp){
                res.add(s + c);
            }
        }
        return res;

    }
}
