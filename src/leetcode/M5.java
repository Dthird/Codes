package leetcode;

/**
 * Created by jason on 3/8/17.
 */
public class M5 {
    private int maxLen = 0;
    private int low = 0;

    public String longestPalindrome(String s) {
        if (s.length() < 2){
            return s;
        }

        for (int i = 0; i < s.length()-1; i++){
            extend(s, i, i); // aba
            extend(s, i, i + 1); // abba

        }
        return s.substring(low, low + maxLen);
    }

    public void extend(String s, int i, int j){
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        if (maxLen < j - i - 1){
            low = i + 1;
            maxLen = j - i - 1;
        }
    }

    public static void main(String[] args){
        M5 m5 = new M5();
        System.out.println(m5.longestPalindrome("bbacadaea"));
    }
}
