package leetcode.string;

/**
 * Created by jason on 4/6/17.
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * Longest Uncommon Subsequence II
 * unfinished
 */
public class M522 {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                    return -1;
                else if (o1.length() < o2.length())
                    return 1;
                return 0;
            }
        });
        for (int i = 0; i < strs.length; i++) {
            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {
                if (i == j)
                    continue;
                if (strs[i].length() > strs[j].length())
                    break;
                if (strs[j].indexOf(strs[i]) != -1) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return strs[i].length();
        }
        return -1;
    }
}
