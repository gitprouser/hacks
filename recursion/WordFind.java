/**
 * Created on 8/15/16.
 * <p/>
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are
 * those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * http://www.lintcode.com/en/problem/word-search/
 * http://blog.welkinlan.com/2015/04/10/word-search-leetcode-java/
 */
public class WordFind {

    public static void main(String[] args) {
        char[][] test = {{'A', 'B', 'C', 'E'},
                         {'S', 'F', 'C', 'S'},
                         {'A', 'D', 'E', 'E'}};
        System.out.println(exist(test, "ABCCED"));
        System.out.println(exist(test, "SEE"));
        System.out.println(exist(test, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null)
            return false;

        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0))
                    result = result || _find(board, word, 0, i, j);
            }
        }
        return result;
    }

    private static boolean _find(char[][] board, String word, int idx, int currRow, int currCol) {
        if (idx >= word.length() || currRow < 0 || currRow >= board.length || currCol < 0 || currCol >= board[0].length)
            return false;

        boolean result = false;
        if (word.charAt(idx) == board[currRow][currCol]) {
            if (idx == word.length() - 1)
                return true;
            board[currRow][currCol] = '#';  // VISITED TRICK
            result = _find(board, word, idx + 1, currRow - 1, currCol) ||
                    _find(board, word, idx + 1, currRow, currCol - 1) ||
                    _find(board, word, idx + 1, currRow + 1, currCol) ||
                    _find(board, word, idx + 1, currRow, currCol + 1);
            board[currRow][currCol] = word.charAt(idx);  // UNSET VISITED TRICK
        }

        return result;
    }
}