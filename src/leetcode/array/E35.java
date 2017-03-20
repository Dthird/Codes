package leetcode.array;

/**
 * Created by jason on 3/9/17.
 */

/**
 * Search Insert Position
 */
public class E35 {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (mid == 0) {
                    return 0;
                }
                if (nums[mid - 1] < target) {
                    return mid;
                }
                high = mid - 1;
            } else {
                if (mid == nums.length - 1) {
                    return nums.length;
                }
                if (nums[mid + 1] > target){
                    return mid + 1;
                }
                low = mid + 1;

            }
        }
        return -1;
    }
}
