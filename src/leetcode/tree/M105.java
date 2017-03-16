package leetcode.tree;

/**
 * Created by jason on 3/16/17.
 */

import java.util.Arrays;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 */
public class M105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        for (; i < inorder.length; i++)
            if (inorder[i] == preorder[0])
                break;
        int[] newPreLeft = Arrays.copyOfRange(preorder, 1, i + 1);
        int[] newPreRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);
        int[] newInLeft = Arrays.copyOfRange(inorder, 0, i);
        int[] newInRgiht = Arrays.copyOfRange(inorder, i + 1, inorder.length);
        root.left = buildTree(newPreLeft, newInLeft);
        root.right = buildTree(newPreRight, newInRgiht);
        return root;
    }

    public static void main(String[] args){
        int[] preorder = {1,2,4,5,3,6,7};
        int[] inorder = {4,2,5,1,6,3,7};

        int[] newPreLeft = Arrays.copyOfRange(preorder, 1, 1 + 3);
        int[] newPreRight = Arrays.copyOfRange(preorder, 3 + 1, preorder.length);
        int[] newInLeft = Arrays.copyOfRange(inorder, 0, 3);
        int[] newInRgiht = Arrays.copyOfRange(inorder, 3 + 1, inorder.length);

        System.out.println(Arrays.toString(newPreLeft));
        System.out.println(Arrays.toString(newPreRight));
        System.out.println(Arrays.toString(newInLeft));
        System.out.println(Arrays.toString(newInRgiht));

    }

}
