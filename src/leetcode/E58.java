package leetcode;

/**
 * Created by jason on 3/12/17.
 */
public class E58 {
    public int lengthOfLastWord(String s) {
        s.trim();
        String[] ts = s.split(" ");
        if (ts.length == 0)
            return 0;
        return ts[ts.length - 1].length();
    }
}