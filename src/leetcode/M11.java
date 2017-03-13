package leetcode;

/**
 * Created by jason on 3/8/17.
 */

/**
 * Container With Most Water
 */
public class M11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (right > left) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
