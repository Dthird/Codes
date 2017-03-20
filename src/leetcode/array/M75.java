package leetcode.array;

/**
 * Created by jason on 3/14/17.
 */

import java.util.Arrays;

/**
 * Sort Colors
 */
public class M75 {

    public void sortColors(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return;

        int record1 = -1, record2 = nums.length - 1, cur = 0;
        while (cur <= record2){
            if (nums[cur] == 0){
                if (record1 == -1){
                    cur++;
                } else {
                    int tmp = nums[record1];
                    nums[record1] = nums[cur];
                    nums[cur] = tmp;
                    record1++;
                    cur++;
                }

            } else if (nums[cur] == 1){
                if (record1 == -1)
                    record1 = cur;
                cur++;
            } else {
                int tmp = nums[record2];
                nums[record2] = nums[cur];
                nums[cur] = tmp;
                record2--;
            }
        }
    }

    public static void main(String[] args){
        int[] num = {0,2,2,0};
        M75 m75 = new M75();
        m75.sortColors(num);
        System.out.println(Arrays.toString(num));
    }
}
