package leetcode.array;

/**
 * Created by jason on 3/14/17.
 */

/**
 * Remove Duplicates from Sorted Array
 */
public class M80 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}
