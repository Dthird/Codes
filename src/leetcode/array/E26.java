package leetcode.array;

/**
 * Created by jason on 3/8/17.
 */

/**
 * Remove Duplicates from Sorted Array
 */
public class E26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) return nums.length;
        int id = 1;
        for(int i = 1; i < nums.length; ++i)
            if(nums[i] != nums[i-1])
                nums[id++] = nums[i];
        return id;
    }
}
