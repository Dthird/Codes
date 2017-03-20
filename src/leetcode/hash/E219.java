package leetcode.hash;

/**
 * Created by jason on 3/19/17.
 */

import java.util.HashMap;

/**
 * Contain Duplicate 2
 */
public class E219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k && i < nums.length ; i++) {
            if (map.containsKey(nums[i]))
                return true;
            map.put(nums[i], 1);
        }


        for (int i = k; i < nums.length; i ++) {
            if (map.containsKey(nums[i]))
                return true;
            map.put(nums[i], 1);
            map.remove(nums[i - k]);
        }
        return false;
    }
}
