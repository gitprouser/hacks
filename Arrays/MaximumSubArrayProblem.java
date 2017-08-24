/**
 * Given an n by n two-dimensional array arr (1<=n<=100) of arbitrary integers,
 * find the maximum sub-array.
 * Maximum sub-array is defined to be the sub-array whose sum of integer
 * elements are the maximum possible.
 */

class MaximumSubArrayProblem {


    public static void main(String args[]) {
        if (args.length > 0)
            testCases(Integer.parseInt(args[0]));
        else
            testCases(1);
    }

    public static int simpleBruteForceSolution(int[][] a) {
        int ROW = a.length;
        int COL = a[0].length;
        System.out.println("R:" + ROW);
        System.out.println("C:" + COL);

        int[][][][] tmp = new int[ROW][COL][ROW + 1][COL + 1];

        for (int r = 0; r < ROW; r++)
            for (int c = 0; c < COL; c++)
                for (int h = 1; h <= ROW - r; h++) {
                    int sum = 0;
                    for (int w = 1; w <= COL - c; w++) {
                        System.out.println(String.format("a[%d + %d - 1][%d + %d - 1] = %d", r, h, c, w, a[r + h - 1][c + w - 1]));
                        sum += a[r + h - 1][c + w - 1];
                        System.out.println(String.format("tmp[%d][%d][%d - 1][%d] = %d", r, c, h, w, tmp[r][c][h - 1][w]));
                        tmp[r][c][h][w] = sum + tmp[r][c][h - 1][w];
                    }
                }


        for (int r = 0; r < ROW; r++)
            for (int c = 0; c < COL; c++)
                for (int h = 0; h < ROW + 1; h++)
                    for (int w = 0; w < COL + 1; w++)
                      System.out.println(String.format("tmp[%d][%d][%d][%d] = %d", r, c, h, w, tmp[r][c][h][w]));


        int maxSum = Integer.MIN_VALUE;
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                for (int h = 0; h < ROW + 1; h++) {
                    for (int w = 0; w < COL + 1; w++) {
                        maxSum = (maxSum < tmp[r][c][h][w]) ? tmp[r][c][h][w] : maxSum;
                    }
                }
            }
        }
        System.out.println(maxSum);
        return maxSum;
    }


    public static void testCases(int i) {
        int[][] tc1 = {
                {2, -1, 2, -1, 4, -5},
                {2, 8, 2, -1, 4, -5},
                {2, -1, 2, -1, 4, -5},
                {2, -1, 2, -1, 4, -5},
                {2, -1, 2, -1, 4, -5},
                {-2, -1, -2, -1, 4, -5}
        };
        int[][] tc2 = {{1, 2, 3, 4, 5, 6}};
        int[][] tc3 = {{1}};

        System.out.println("##### Test Case " + i + "######");
        switch (i) {
            case 1:
                simpleBruteForceSolution(tc1);
                break;
            case 2:
                simpleBruteForceSolution(tc2);
                break;
            case 3:
                simpleBruteForceSolution(tc3);
                break;
            default:
                System.out.println("NO testcase");
                break;
        }

    }
}
