package leetcode;

/**
 * Created by jason on 3/8/17.
 */
public class E27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length < 1){
            return nums.length;
        }

        int id = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[id] = nums[i];
                id++;
            }
        }
        return id;
    }
}
