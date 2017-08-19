public class NQueens {

    public static void main(String[] args) {
        solveNQueens(3);
    }

    private static void solveNQueens(int n) {
        // The entire 2D chess board is shrunk into a 1D array
        // The problem is reduced into permutation problem hence removing row and column check
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i;
            // _solveNQueensForAllSolutions(arr, 0);
        boolean isSolvable = _solveNQueensReturnSingleSolution(arr, 0);
        if (!isSolvable)
            System.out.println("" + isSolvable + " for " + n + "x" + n);
    }

    // returns only a single solution.
    private static boolean _solveNQueensReturnSingleSolution(int[] arr, int i) {
        if (i == arr.length) {
            for (int j : arr) System.out.print(" " + j);
            System.out.println();
            return true; // NQueens has been solved.
        }

        boolean isSolved = false;
        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            if (isNewQueenThreatningOtherQueens(arr, i))  // If NQueens has been solved don't permute anymore
               isSolved = _solveNQueensReturnSingleSolution(arr, i + 1);
                if (isSolved)
                    return isSolved;
            swap(arr, i, j);
        }
        return false;
    }


    private static void _solveNQueensForAllSolutions(int[] arr, int i) {
        if (i == arr.length) {
            for (int j : arr) System.out.print(" " + j);
            System.out.println();
            return;
        }

        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            if (isNewQueenThreatningOtherQueens(arr, i))  // Backtracking
                _solveNQueensForAllSolutions(arr, i + 1);
            swap(arr, i, j);
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // NewQueen against all the previous queens.
    // The slope of the y axis and the x axis are the same. (Signs do not matter since they might be increasing or decreasing)
    private static boolean isNewQueenThreatningOtherQueens(int[] game, int newQueen) {
        for (int j = 0; j < newQueen; j++)
            if (Math.abs(game[newQueen] - game[j])  == Math.abs(newQueen - j))
                return false;
        return true;
    }
}
