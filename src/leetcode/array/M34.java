package leetcode.array;

import java.util.Arrays;

/**
 * Created by jason on 3/9/17.
 */

/**
 * Search for a Range
 */
public class M34 {
    public int[] searchRange(int[] nums, int target) {

        int l = -1, r = -1;
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                l = r = mid;
                while(r < nums.length && nums[r] == target){
                    r++;
                }
                while(l >= 0 && nums[l] == target){
                    l--;
                }
                r--;
                l++;
                break;
            } else if(nums[mid] > target){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }

        return new int[]{l, r};
    }


}
