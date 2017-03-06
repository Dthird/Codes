package algo;

/**
 * Created by jason on 3/6/17.
 */
public class Queens {
    private int[][] board;
    private int numOfQueens;
    public int numOfSolutions;

    public Queens(int n){
        numOfQueens = n;
        numOfSolutions = 0;
        board = new int[n][n];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numOfQueens; i++) {
            for (int j = 0; j < numOfQueens; j++) {
                stringBuilder.append(" " + board[i][j]);
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    private boolean trail(int row, int col){
        for (int i = 0; i < numOfQueens; i++) {
            if (board[row][i] == 1 || board[i][col] == 1){
                return false;
            }
        }
        int tmpRow = row;
        int tmpCol = col;
        // left-top
        while (tmpRow >= 0 && tmpCol >= 0){
            if (board[tmpRow][tmpCol] == 1){
                return false;
            }
            tmpRow--;
            tmpCol--;
        }
        // right-top
        tmpRow = row;
        tmpCol = col;
        while (tmpRow >= 0 && tmpCol < numOfQueens){
            if (board[tmpRow][tmpCol] == 1){
                return false;
            }
            tmpRow--;
            tmpCol++;
        }
        // left-bottom
        tmpRow = row;
        tmpCol = col;
        while (tmpRow < numOfQueens && tmpCol >= 0){
            if (board[tmpRow][tmpCol] == 1){
                return false;
            }
            tmpRow++;
            tmpCol--;
        }
        // right-bottom
        tmpRow = row;
        tmpCol = col;
        while (tmpRow < numOfQueens && tmpCol < numOfQueens){
            if (board[tmpRow][tmpCol] == 1){
                return false;
            }
            tmpRow++;
            tmpCol++;
        }

        return true;
    }

    public void putQueen(int row){
        for (int i = 0; i < numOfQueens; i++) {
            if (trail(row, i)){
                board[row][i] = 1;
                if (row == numOfQueens - 1){
                    numOfSolutions ++;
                    System.out.println(numOfSolutions + ":\n" + toString());
                    board[row][i] = 0;
                }else {
                    putQueen(row + 1);
                }
                board[row][i] = 0; // reset to 0
            }
        }
    }

    public static void main(String[] args){
        Queens queens = new Queens(8);
        queens.putQueen(0);
    }

}
