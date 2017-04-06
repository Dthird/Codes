package algo;

/**
 * Created by jason on 4/5/17.
 */

import java.util.TreeMap;

/**
 * unfinished
 */
public class KnightTour {
    static int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
    static int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
    public static boolean solve(int startX, int startY, int visitedNum, int[][] board){
        if (visitedNum == board.length * board[0].length)
            return true;
        board[startX][startY] = visitedNum;
        if (isSafe(startX, startY, board)){


        } else{
            board[startX][startY] = 0;
            return false;
        }
        return false;
    }

    public static boolean isSafe(int x, int y, int[][] board){
        return x >=0 && x < board.length && y >=0 && y < board[0].length && board[x][y] == 0;
    }

    public static void main(String[] args){
        int[][] board = new int[8][8];

        solve(0, 0, 1, board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "\\t");
            }
            System.out.println();
        }
    }

}
