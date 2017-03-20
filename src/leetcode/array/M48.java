package leetcode.array;

/**
 * Created by jason on 3/11/17.
 */

/**
 * Rotate Image
 */
public class M48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1)
            return;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        reverse(matrix);
    }

    public void reverse(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
                matrix[i][matrix[i].length - 1 - j] = tmp;
            }
            for (int k = 0; k < matrix.length; k++) {
                for (int j = 0; j < matrix[k].length; j++) {
                    System.out.print(matrix[k][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        M48 m48 = new M48();
        m48.rotate(matrix);


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
