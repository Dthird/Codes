package leetcode.array;

/**
 * Created by jason on 3/20/17.
 */

import java.util.Arrays;

/**
 * Missing Number
 */
public class E268 {
    public int missingNumber(int[] nums) {
        int i = 0, res = 0;
        for (; i < nums.length; i++){
            res ^= i ^ nums[i];
        }
        return res ^ i;

    }

    // how to handle 0
    public int missingNumber1(int[] nums) {
        for (int n : nums) {
            //System.out.println(n);
            int tmp = Math.abs(n);
            if (tmp == 0)
                nums[0] = -1;
            else if (tmp == nums.length)
                continue;
            else
                nums[tmp] *= -1;
        }

        //System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                return i;
        }
        return nums.length;
    }

    public static void main(String[] args){
        E268 e268 = new E268();
        System.out.println(e268.missingNumber(new int[]{2,0,1,3, 5}));
    }
}
