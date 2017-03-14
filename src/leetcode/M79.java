package leetcode;

/**
 * Created by jason on 3/14/17.
 */

/**
 * Word Search
 */
public class M79 {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0)
            return true;
        if (board.length == 0 || board[0].length == 0)
            return false;
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    if (backtrack(board, used, i, j, 0, word))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, boolean[][] used, int indexI, int indexJ, int length, String word){
        if (length == word.length())
            return true;

        if (indexI < 0 || indexI >= board.length || indexJ < 0 || indexJ >= board[0].length || used[indexI][indexJ] || board[indexI][indexJ] != word.charAt(length)) // judge used
            return false;

        used[indexI][indexJ] = true;
        boolean res = backtrack(board, used, indexI - 1, indexJ, length + 1, word) || backtrack(board, used, indexI + 1, indexJ, length + 1, word)
                || backtrack(board, used, indexI, indexJ - 1, length + 1, word) || backtrack(board, used, indexI, indexJ + 1, length + 1, word);
        used[indexI][indexJ] = false;
        return res;

    }

    public static void main(String[] args){
        M79 m79 = new M79();
        m79.exist(new char[][]{{'b'}, {'a'}, {'b'}}, "bbabab");
    }

}
