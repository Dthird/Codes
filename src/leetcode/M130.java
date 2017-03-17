package leetcode;

/**
 * Created by jason on 3/17/17.
 */

/**
 * Surrounded Regions
 */
public class M130 {

    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(i == 0 || i == board.length-1 || j == 0 || j == board[0].length-1){
                    if(board[i][j] == 'O') dfs(i,j,board);
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '*') board[i][j] ='O';
                else board[i][j] = 'X';
            }
        }
        return;
    }
    private void dfs(int i,int j,char[][] board){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if(board[i][j] == 'X' || board[i][j] == '*') return;
        board[i][j] = '*';
        if(i+1 < board.length)
            dfs(i+1,j,board);
        if(i-1 > 0)
            dfs(i-1,j,board);
        if(j+1 < board[0].length)
            dfs(i,j+1,board);
        if(j-1 > 0)
            dfs(i,j-1,board);
    }

    // RE
    public void solve1(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;

        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[i].length - 1; j++) {
                if (board[i][j] == 'O'){
                    /*if (bfs(board, i, j))
                        board[i][j] = 'X';
                        */
                    bfs(board, i, j);
                }
            }
        }
    }

    private boolean bfs(char[][] board, int i, int j){
        if (i <= 0 || i >= board.length - 1 || j <= 0 || j >= board[i].length - 1)
            return false;

        if (board[i][j] == 'X')
            return true;

        board[i][j] = 'X';
        boolean tmp = bfs(board, i - 1, j) && bfs(board, i + 1, j) && bfs(board, i, j - 1) && bfs(board, i, j + 1);
        if (!tmp)
            board[i][j] = 'O';
        return tmp;

    }
}
