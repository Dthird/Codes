package leetcode.array;

/**
 * Created by jason on 3/19/17.
 */

import java.util.Arrays;

/**
 * Product of Array Except Itself
 */
public class M238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        //int backup = 0;
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            res[i] = tmp;
            tmp *= nums[i];
        }

        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            res[i] *= tmp;
            tmp *= nums[i];
        }
        return res;
    }

    public static void main(String[] args){
        M238 m238 = new M238();
        System.out.println(Arrays.toString(m238.productExceptSelf(new int[]{1,2,3})));
    }

}
