package leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by jason on 3/7/17.
 */

/**
 * Two Sum
 */
public class E1 {

    //hash
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    //BF
    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        E1 e1 = new E1();
        System.out.println(Arrays.toString(e1.twoSum(new int[]{2, 7, 10, 11}, 9)));
    }
}
