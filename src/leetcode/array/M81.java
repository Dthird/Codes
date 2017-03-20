package leetcode.array;

/**
 * Created by jason on 3/14/17.
 */

/**
 * Search in Rotated Sorted Array 2
 */
public class M81 {

    public boolean search(int[] nums, int target) {
        if (nums.length == 0)
            return false;

        int low = 0, high = nums.length - 1;

        while (low <= high){
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return true;
            else if (nums[mid] < target){
                if (nums[high] > target){
                    low = mid + 1;
                } else if (nums[high] < target){
                    high = mid - 1;
                } else
                    return true;
            } else {
                if (nums[low] < target){
                    high = mid - 1;
                } else if (nums[low] > target){
                    low = mid + 1;
                } else // nums[low] == target
                    return true;
            }
        }
        return false;
    }

    private int findMaxIndex(int[] nums){
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }
}
