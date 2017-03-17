package leetcode;

/**
 * Created by jason on 3/17/17.
 */

/**
 * Valid Palindrome
 */
public class E125 {

    public boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;

        s = s.toLowerCase();
        int head = 0, tail = s.length() - 1;
        while (head <= tail){
            if (s.charAt(head) > 'z' || s.charAt(head) < '0' || s.charAt(head) > '9' && s.charAt(head) < 'a'){
                head++;
                continue;
            }
            if (s.charAt(tail) > 'z' || s.charAt(tail) < '0' || s.charAt(tail) > '9' && s.charAt(tail) < 'a'){
                tail--;
                continue;
            }

            if (s.charAt(head) != s.charAt(tail))
                return false;

            head++;
            tail--;
        }
        return true;
    }

}
