package leetcode.tree;

/**
 * Created by jason on 3/16/17.
 */

import java.util.Arrays;

/**
 * Convert Sorted Array to Binary Search Tree
 */
public class E108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;

        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0 , mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return root;
    }

}
