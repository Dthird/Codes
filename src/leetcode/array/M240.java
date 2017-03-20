package leetcode.array;

/**
 * Created by jason on 3/19/17.
 */

/**
 * Search a 2D Matrix 2
 */
public class M240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0){
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target)
                col--;
            else
                row++;
        }
        return false;
    }


    //unfinished divided and conqure
    private boolean helper(int[][] matrix, int target, int leftTopi, int leftTopj, int rightBottomi, int rightBottomj){
        return true;
    }

}
