package leetcode.string;

/**
 * Created by jason on 3/18/17.
 */

/**
 * Reverse Words in a string
 */
public class M151 {

    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        String out = "";
        for (int i = parts.length - 1; i > 0; i--) {
            out += parts[i] + " ";
        }
        return out + parts[0];
    }
}
