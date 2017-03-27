package leetcode.greedy;

/**
 * Created by jason on 3/27/17.
 */

/**
 * Remove K Digits
 */
public class M402 {
    public String removeKdigits(String num, int k) {
        if (k == num.length())
            return "0";

        for (int i = 0; i < k; i++) {
            int j;
            for (j = 0; j < num.length() - 1; j++) {
                if (num.charAt(j) > num.charAt(j + 1)){
                    break;
                }
            }
            if (j == num.length() - 1)
                num = num.substring(0, j);
            else
                num = num.substring(0, j) + num.substring(j+1);
        }
        //return String.valueOf(Integer.valueOf(num));
        String res = num.replaceFirst("^0*", "");
        if (res.length() == 0)
            return "0";
        return res;
    }
}
