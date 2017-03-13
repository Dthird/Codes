package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jason on 3/8/17.
 */

/**
 * 3Sum Closest
 */
public class M16 {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int res1 = Integer.MIN_VALUE;
        int res2 = Integer.MAX_VALUE;
        for (int i = 0; i < num.length - 2; i++) {
            int lo = i + 1, hi = num.length - 1, sum = target - num[i];
            while (lo < hi) {
                if (num[lo] + num[hi] == sum) {
                    return target;
                } else if (num[lo] + num[hi] < sum) {
                    res1 = Math.max(res1, num[i] + num[lo] + num[hi]);
                    lo++;
                } else{
                    res2 = Math.min(res2, num[i] + num[lo] + num[hi]);
                    hi--;
                }
            }
        }

        if (res1 == Integer.MIN_VALUE){
            return res2;
        }

        if (res2 == Integer.MAX_VALUE){
            return res1;
        }

        if (target - res1 < res2 - target){
            return res1;
        }else {
            return res2;
        }
    }
}
