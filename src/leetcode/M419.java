package leetcode;

/**
 * Created by jason on 3/28/17.
 */

/**
 * BattleShips in a Board
 */
public class M419 {
    public int countBattleships(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X'){
                    if (i == 0 && j == 0) {
                        res++;
                        continue;
                    }
                    if (i == 0){
                        if (board[i][j - 1] != 'X')
                            res++;
                        continue;
                    }
                    if (j == 0){
                        if (board[i - 1][j] != 'X')
                            res++;
                        continue;
                    }
                    if (board[i - 1][j] != 'X' && board[i][j - 1] != 'X')
                        res++;
                }
            }
        }
        return res;
    }
}
