package leetcode;

/**
 * Created by jason on 3/24/17.
 */

/**
 * Sum of Two Integers
 */
public class E371 {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}

