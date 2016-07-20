public class MatrixBestPath {
    public static void main(String[] args) {
        int result;
        int errors = 0;
        for (int i = 0; i < tests.length; i++) {
            result = bestPath(tests[i].arr);
            if (result != tests[i].result) {
                System.out.println("Error: Best path of test case number " + (i + 1) + " is " + tests[i].result + ". Got " + result + " instead");
                errors++;
            }
        }

        if (errors > 0)
            System.out.println("Got " + errors + " errors.");
        else
            System.out.println("Good work");
    }

    public static int bestPath(int[][] arr) {
        return bestPath(arr, 0, 0);
    }

    private static int bestPath(int[][] arr, int i, int j) {
        int M = arr.length;
        int N = arr[0].length;
        if (i == M - 1 && j == N - 1)
            return arr[i][j];

        if (i == M - 1)
            return arr[i][j] + bestPath(arr, i, j++);
        // j + 1  is the same as ++j NOT j++

        if (j == N - 1)
            return arr[i][j] + bestPath(arr, i++, j);

        return Math.max(arr[i][j] + bestPath(arr, ++i, j), arr[i][j] + bestPath(arr, i, ++j));
    }

    public static class TestCase {
        int result;
        int[][] arr;

        public TestCase(int[][] a, int r) {
            arr = a;
            result = r;
        }
    }

    private static int[][] arr1 = {{9}};
    private static int[][] arr2 = {{1, 2, 3}};
    private static int[][] arr3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private static int[][] arr4 = {{2, 2, 1, 1, 1}, {1, 2, 1, 1, 1},
            {1, 2, 2, 1, 1}, {1, 1, 2, 2, 1},
            {1, 1, 1, 2, 2}};
    private static TestCase tests[] = {
            new TestCase(arr1, 9),
            new TestCase(arr2, 6),
            new TestCase(arr3, 29),
            new TestCase(arr4, 18)
    };
}
