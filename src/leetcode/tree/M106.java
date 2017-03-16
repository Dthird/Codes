package leetcode.tree;

/**
 * Created by jason on 3/16/17.
 */

import java.util.Arrays;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 */
public class M106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0)
            return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int i = 0;
        for (; i < inorder.length; i++)
            if (inorder[i] == postorder[postorder.length - 1])
                break;
        int[] newPostLeft = Arrays.copyOfRange(postorder, 0, i);
        int[] newPostRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);
        int[] newInLeft = Arrays.copyOfRange(inorder, 0, i);
        int[] newInRgiht = Arrays.copyOfRange(inorder, i + 1, inorder.length);
        root.left = buildTree(newInLeft, newPostLeft);
        root.right = buildTree(newInRgiht, newPostRight);
        return root;
    }


    public static void main(String[] args){
        int[] postorder = {4,5,2,6,7,3,1};
        int[] inorder = {4,2,5,1,6,3,7};

        int[] newPostLeft = Arrays.copyOfRange(postorder, 0, 3);
        int[] newPostRight = Arrays.copyOfRange(postorder, 3, postorder.length - 1);
        int[] newInLeft = Arrays.copyOfRange(inorder, 0, 3);
        int[] newInRgiht = Arrays.copyOfRange(inorder, 3 + 1, inorder.length);

        System.out.println(Arrays.toString(newPostLeft));
        System.out.println(Arrays.toString(newPostRight));
        System.out.println(Arrays.toString(newInLeft));
        System.out.println(Arrays.toString(newInRgiht));
    }
}
