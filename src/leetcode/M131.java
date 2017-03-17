package leetcode;

/**
 * Created by jason on 3/17/17.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome Partitioning
 */
public class M131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0)
            return res;

        backtrack(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> tmp, String s, int index){
        if (index == s.length()){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s.substring(index, i + 1))) {
                tmp.add(s.substring(index, i + 1));
                backtrack(res, tmp, s, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String s){
        if (s.length() == 0)
            return false;
        int head = 0, tail = s.length() - 1;
        while(head <= tail)
            if (s.charAt(head) != s.charAt(tail))
                return false;
            else {
                head++;
                tail--;
            }
        return true;
    }
}
