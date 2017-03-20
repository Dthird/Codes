package leetcode.array;

/**
 * Created by jiaxing on 17-3-13.
 */

/**
 * Search a 2D Matix
 */
public class M74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        if (matrix[0].length == 0){
            return false;
        }
        int low = 0, high = matrix.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (matrix[mid][0] == target)
                return true;
            else if (matrix[mid][0] < target){
                if (binarysearch(matrix[mid], target)){
                    return true;

                }
                low = mid + 1;

            } else {
                if (mid == low)
                    return false;
                high = mid - 1;
            }
        }
        return false;
    }

    private boolean binarysearch(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return true;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}
