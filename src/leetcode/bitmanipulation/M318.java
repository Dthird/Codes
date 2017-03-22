package leetcode.bitmanipulation;

/**
 * Created by jason on 3/21/17.
 */

/**
 * Maximum Product of Word Lengths
 */
public class M318 {
    public int maxProduct(String[] words) {
        if (words.length == 0 || words.length == 1)
            return 0;
        int[] masks = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                masks[i] |= 1 << (c - 'a');
            }
        }

        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 1 + 1; j < words.length; j++) {
                if ((masks[i] & masks[j]) == 0){
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;

    }
}
