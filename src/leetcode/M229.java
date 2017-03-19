package leetcode;

/**
 * Created by jason on 3/19/17.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Major Element 2
 */
public class M229 {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = -2, candidate2 = -1, count1 = 0, count2 = 0;
        int numOfRemoved = 0;
        for (int n : nums){
            if (n == candidate1)
                count1++;
            else if (n == candidate2)
                count2++;
            else if (count1 == 0){
                candidate1 = n;
                count1++;
            } else if (count2 == 0){
                candidate2 = n;
                count2++;
            } else {
                count1--;
                count2--;
                numOfRemoved += 3;
            }
        }

        List<Integer> res = new ArrayList<>();

        if (count(nums, candidate1) > nums.length / 3)
            res.add(candidate1);
        if (count(nums, candidate2) > nums.length / 3)
            res.add(candidate2);
        return res;
    }

    private int count(int[] nums, int num){
        int sum = 0;
        for (int n : nums)
            if (n == num)
                sum++;
        return sum;
    }
}
