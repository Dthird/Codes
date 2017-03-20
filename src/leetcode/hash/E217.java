package leetcode.hash;

/**
 * Created by jason on 3/18/17.
 */

import java.util.HashMap;

/**
 * Contains Duplicate
 */
public class E217 {

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i]))
                return true;
            hashMap.put(nums[i], 1);
        }
        return false;
    }
}
