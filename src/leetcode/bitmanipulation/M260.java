package leetcode.bitmanipulation;

/**
 * Created by jason on 3/20/17.
 */

/**
 * Single Number 3
 */
public class M260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int n : nums) {
            diff ^= n;
        }

        diff &= ~(diff - 1);

        int[] res = {0, 0};
        for (int n : nums){
            if ((n & diff) == 0)
                res[0] ^= n;
            else
                res[1] ^= n;
        }
        return res;
    }
}
