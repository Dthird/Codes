package leetcode.bitmanipulation;

/**
 * Created by jason on 3/27/17.
 */

/**
 * Integer Replacement
 */
public class M397 {
    public int integerReplacement(int n) {
        int res = 0;
        while (n != 1){
            if ((n & 1) == 0)
                n = n >>> 1;
            else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1))
                n--;
            else
                n++;
            res++;
        }
        return res;
    }

}
