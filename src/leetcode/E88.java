package leetcode;

/**
 * Created by jason on 3/15/17.
 */

/**
 * Merge Two Sorted Array
 */
public class E88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int id = 0, count = 0;
        for (int i = 0; i < n;) {
            if (nums2[i] > nums1[id] && id < count + m){ // notice case num1 = {0} m = 0
                id++;
            } else if (id >= count + m){
                nums1[id] = nums2[i];
                count++;
                id++;
                i++;
                continue;
            } else {
                count++;
                for (int j = m + count - 1; j > id; j--) {
                    nums1[j] = nums1[j - 1];
                }
                nums1[id] = nums2[i];
                id++;
                i++;
            }
        }
    }
}
