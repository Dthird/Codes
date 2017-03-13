package leetcode.permutations;

import java.util.Arrays;

/**
 * Created by jason on 3/9/17.
 */

/**
 * Next Permetion
 */
public class M31 {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--){
            if (nums[i] > nums[i - 1]){
                for (int j = nums.length - 1; j > i - 1; j--)
                    if (nums[j] > nums[i - 1]){
                        swap(nums, i - 1, j);
                        reverse(nums, i);
                        return;
                    }
            }
        }

        Arrays.sort(nums);
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int i){
        for (int low = i, high = nums.length - 1; low < high; low++, high--){
            swap(nums, low, high);
        }
    }
}
