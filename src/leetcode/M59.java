package leetcode;

/**
 * Created by jason on 3/13/17.
 */
public class M59 {
    public int[][] generateMatrix(int n) {
        if (n == 0)
            return new int[0][0];

        int[][] nums = new int[n][n];

        int colBegin = 0, colEnd = n - 1, rowBegin = 0, rowEnd = n - 1;
        int num = 1;
        while (colBegin <= colEnd && rowBegin <= rowEnd ){
            for (int i = colBegin; i <= colEnd; i++){
                nums[rowBegin][i] = num;
                num++;
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++){
                nums[i][colEnd] = num;
                num++;
            }
            colEnd--;

            for (int i = colEnd; i >= colBegin; i--){
                nums[rowEnd][i] = num;
                num++;
            }
            rowEnd--;

            for (int i = rowEnd; i >= rowBegin; i--){
                nums[i][colBegin] = num;
                num++;
            }
            colBegin++;

        }
        return nums;
    }

    public static void main(String[] args){
        M59 m59 = new M59();
        int[][] res = m59.generateMatrix(3);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();

        }
    }

}
