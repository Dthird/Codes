package leetcode.dp;

/**
 * Created by jason on 3/19/17.
 */

/**
 * Maximal Square
 */
public class M221 {

    public int maximalSquare(char[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1'){
                    matrix[i][j] = (char)(Math.min(matrix[i][j - 1] - '0', Math.min(matrix[i - 1][j - 1] - '0', matrix[i - 1][j] - '0')) + '0' + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res = Math.max(res, matrix[i][j] - '0');
            }
        }
        return res * res;
    }
}
