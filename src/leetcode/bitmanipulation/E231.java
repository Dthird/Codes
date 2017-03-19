package leetcode.bitmanipulation;

/**
 * Created by jason on 3/19/17.
 */

/**
 * Power of Two
 */
public class E231 {
    public boolean isPowerOfTwo(int n) {
        return n <= 0 ? false : (n & (n - 1)) == 0;
    }
}
