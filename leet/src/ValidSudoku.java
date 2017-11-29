import java.util.*;

class ValidSudoku {

    public static void main(String args[]) {
        /**
             ..4 ... 63.
             ... ... ...
             5.. ... .9.

             ... 56. ...
             4.3 ... ..1
             ... 7.. ...

             ... 5.. ...
             ... ... ...
             ... ... ...
        */
        char[][] fail_boardTestCase = {{'.','.','4','.','.','.','6','3','.'},
                                    {'.','.','.','.','.','.','.','.','.'},
                                    {'5','.','.','.','.','.','.','9','.'},
                                    {'.','.','.','5','6','.','.','.','.'},
                                    {'4','.','3','.','.','.','.','.','1'},
                                    {'.','.','.','7','.','.','.','.','.'},
                                    {'.','.','.','5','.','.','.','.','.'},
                                    {'.','.','.','.','.','.','.','.','.'},
                                    {'.','.','.','.','.','.','.','.','.'}};

        char[][] pass_testCase2 = {
            {'.','8','7','6','5','4','3','2','1'},
            {'2','.','.','.','.','.','.','.','.'},
            {'3','.','.','.','.','.','.','.','.'},
            {'4','.','.','.','.','.','.','.','.'},
            {'5','.','.','.','.','.','.','.','.'},
            {'6','.','.','.','.','.','.','.','.'},
            {'7','.','.','.','.','.','.','.','.'},
            {'8','.','.','.','.','.','.','.','.'},
            {'9','.','.','.','.','.','.','.','.'}};
        assert (isValidSudokuHashSet(pass_testCase2));
        assert (! isValidSudokuHashSet(fail_boardTestCase));

/*
        List<Character[][]> list = Arrays.asList(fail_boardTestCase, pass_testCase2);
        for (Character[][] c : list) {
            // System.out.println("Running Test case " + new ValidSudoku().getClass().getDeclaredField().getName());
            // assert !isValidSudoku(c);
        }
*/

    }

    public static boolean isValidSudokuHashSet(char[][] board) {
       for (int i = 0; i < 9; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();
            Set<Character> cell = new HashSet<>();
            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.' && (! rows.add(board[i][j])))
                    return false;

                if (board[j][i] != '.' && (! cols.add(board[j][i])))
                    return false;

                int rowCell = 3 * (i / 3) + j / 3;
                int colCell = 3 * (i % 3) + j % 3;

                if (board[rowCell][colCell] != '.'
                      && (! cell.add(board[rowCell][colCell])))
                      return false;

            }
       }
       return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        boolean isValid = true;
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                isValid &= __isValid_Brute(board, r, c);
            }
        }
        return isValid;
    }

    public static boolean __isValid_Brute(char[][] board, int row, int col) {
        if (board[row][col] == '.')
           return true;

        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == board[row][col]  && i != col) return false;
            if (board[i][col] == board[row][col] && i != row)  return false;
        }

        int rowCell = row - row % 3;
        int colCell = col - col % 3;

        for (int r = rowCell; r < rowCell + 3; r++) 
            for (int c = colCell; c < colCell + 3; c++) 
                if (board[r][c] == board[row][col] && r != row && c != col) return false;

        return true;
    }

/*
    private static boolean __isValid_Brute_with_prints_Debug(Character[][] board, int row, int col) {
        if (board[row][col] == '.')
           return true;

        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == board[row][col]  && i != col) {
                System.out.println("oops - row : " + board[row][col]);
                return false;
            }
            if (board[i][col] == board[row][col] && i != row) {
                System.out.println("oops - col : " + board[row][col] + " " + row + " " + col);
                return false;
            }
        }

        int rowCell = row - row % 3;
        int colCell = col - col % 3;

        for (int r = rowCell; r < rowCell + 3; r++) {
            for (int c = colCell; c < colCell + 3; c++) {
                System.out.print(board[r][c] + " ");
                if (board[r][c] == board[row][col] && r != row && c != col) {
                    System.out.println("oops - cell : " + board[r][c] + " " + row + " " + col);
                    return false;
                }
            }
            System.out.println();
        }
        return true;
    }
*/

}


