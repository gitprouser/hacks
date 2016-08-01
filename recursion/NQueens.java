public class NQueens {

    public static void main(String[] args) {
        solveNQueens(4);
    }

    private static void solveNQueens(int n) {
        int[] arr = new int[n];
        for (int i = 1; i <= arr.length; i++)
            arr[i - 1] = i;
//        _solveNQueensForAllSolutions(arr, 0);
        _solveNQueensReturnSingleSolution(arr, 0, true);
    }

    private static boolean _solveNQueensReturnSingleSolution(int[] arr, int i, boolean isNotSolved) {
        if (i == arr.length) {
            for (int j : arr) System.out.print(" " + j);
            System.out.println();
            return false;
        }

        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            if (isNotSolved && isQueenThreatning(arr, i))
               isNotSolved = _solveNQueensReturnSingleSolution(arr, i + 1, isNotSolved);
            swap(arr, i, j);
        }
        return isNotSolved;
    }


    private static void _solveNQueensForAllSolutions(int[] arr, int i) {
        if (i == arr.length) {
            for (int j : arr) System.out.print(" " + j);
            System.out.println();
        }

        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            if (isQueenThreatning(arr, i))  // Backtracking
                _solveNQueensForAllSolutions(arr, i + 1);
            swap(arr, i, j);
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static boolean isQueenThreatning(int[] game, int nextQueen) {
        for (int j = 0; j < nextQueen; j++)
            if (Math.abs(game[nextQueen] - game[j])  == Math.abs(nextQueen - j))
                return false;
        return true;
    }
}
