package leetcode.array;

/**
 * Created by jason on 3/22/17.
 */

import java.util.Arrays;

/**
 * Kth Largest Element in an array
 */
public class M215 {

    public int findKthLargest(int[] nums, int k) {
        if (nums.length - k < 0)
            return -1;

        k = nums.length - k;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int part = partition(nums, low, high);
            if (part == k){
                break;
            } else if (part < k){
                low = part + 1;
            } else {
                high = part - 1;
            }
        }
        return nums[k];
    }

    public int partition(int[] nums, int low, int high){
        int partIndex = low;
        int partE = nums[low];
        low++;
        while (low <= high){
            while (low <= high && nums[low] < partE){
                low++;
            }
            if (low > high){
                exchange(nums, partIndex, low - 1);
                partIndex = low - 1;
                break;
            }
            while (low <= high && nums[high] >= partE){
                high--;
            }
            if (high < low){
                exchange(nums, high, partIndex);
                partIndex = high;
                break;
            }
            exchange(nums, low, high);
            exchange(nums, partIndex, low);
            partIndex = low;
            low++;
            high--;
        }

        //System.out.println(Arrays.toString(nums));
        return partIndex;
    }

    private void exchange(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args){
        M215 m215 = new M215();
        //System.out.println(m215.partition(new int[]{5,1,6,2,8,7,4,3,0,9,-1}, 0, 10));
        m215.findKthLargest(new int[]{2,1}, 1);
    }

}
