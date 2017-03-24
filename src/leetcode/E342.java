package leetcode;

/**
 * Created by jason on 3/23/17.
 */

/**
 * Power of Four
 */
public class E342 {

    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
