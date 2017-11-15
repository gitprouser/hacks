/**
 * Given an n by n two-dimensional array arr (1<=n<=100) of arbitrary integers, 
 * find the maximum sub-array. 
 * Maximum sub-array is defined to be the sub-array whose sum of integer 
 *   elements are the maximum possible.
 */

class TwoDimentionalArraySum {

    private static final int LENGTH = 6;

    public static void main(String args[]) {
        int[][] arr = {
            {2,-1,2,-1,4,-5},
            {2,8,2,-1,4,-5},
            {2,-1,2,-1,4,-5},
            {2,-1,2,-1,4,-5},
            {2,-1,2,-1,4,-5},
            {-2,-1,-2,-1,4,-5}
        };
        printMatrix(arr);
        System.out.println("###########");
        // printMatrix(sumMatrix(arr));
        dynamicProgammingSolution(arr);
    }

    public static void printMatrix(int[][][][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j<arr[0].length; j++) {
                for (int k = 0; k<arr[0][0].length; k++) {
                    for (int m = 0; m<arr[0][0][0].length; m++) {
                        if (j == arr[0][0].length - 1)
                            System.out.print(arr[i][j][k][m]);
                        else
                            System.out.print(arr[i][j][k][m] +  ",");
                    }
                }
            }
        }
    }


    // O(N^4) !!!
    public static void dynamicProgammingSolution(int[][] a) {
        int[][][][] dynTable = new int[LENGTH][LENGTH][LENGTH + 1][LENGTH + 1];
                                   // [row][col][height][width]
        int maxSum = Integer.MIN_VALUE;
        int maxRowStart = -1;
        int maxColStart = -1;
        int maxRowEnd = -1;
        int maxColEnd = -1;

        for (int r = 0; r < LENGTH; r++) {
            for (int c = 0; c < LENGTH; c++) {
                for (int h = 0; h < LENGTH + 1; h++) {
                    for (int w = 0; w < LENGTH + 1; w++) {
                        dynTable[r][c][h][w] = 0;
                    }
                }
            }
        }

        // printMatrix(dynTable);

        for (int r = 0; r < LENGTH; r++) {
            for (int c = 0; c < LENGTH; c++) {
                for (int h = 1; h <= LENGTH - r; h++) {
                    int rowTotal = 0;
                    for (int w = 1; w <= LENGTH - c; w++) {
                        rowTotal += a[r + h - 1][c + w - 1];
                        dynTable[r][c][h][w] = rowTotal + dynTable[r][c][h - 1][w];
                    }
                }
            }
        }

        for (int r = 0; r < LENGTH; r++) {
            for (int c = 0; c < LENGTH; c++) {
                for (int h = 0; h < LENGTH + 1; h++) {
                    for (int w = 0; w < LENGTH + 1; w++) {
                        if (dynTable[r][c][h][w] > maxSum) {
                            maxSum = dynTable[r][c][h][w];
                            maxRowStart = r;
                            maxColStart = c;
                            maxRowEnd = r + h - 1;
                            maxColEnd = c + w - 1;
                        }
                    }
                }
            }
        }

        System.out.print("    DP SOLUTION |   Max sum: " + maxSum);
        System.out.print("   Start: (" + maxRowStart + ", " + maxColStart + ")"+
                         "   End: (" + maxRowEnd + ", " + maxColEnd + ")");
    }

    // O(N^3)
    // http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/
    public static void kadane2D(int[][] a) {


    }



    // O(N^2)
    // O(N^2) !!!
    public static void kadane2D_O_N_NO_IDEA(int[][] a) {
        int[][] s = new int[LENGTH + 1][LENGTH]; // [ending row][sum from row zero to ending row] (rows 1-indexed!)
        for (int r = 0; r < LENGTH + 1; r++) {
            for (int c = 0; c < LENGTH; c++) {
                s[r][c] = 0;
            }
        }
        for (int r = 1; r < LENGTH + 1; r++) {
            for (int c = 0; c < LENGTH; c++) {
                s[r][c] = s[r - 1][c] + a[r - 1][c];
            }
        }
        int maxSum = Integer.MIN_VALUE;
        int maxRowStart = -1;
        int maxColStart = -1;
        int maxRowEnd = -1;
        int maxColEnd = -1;
        for (int r1 = 1; r1 < LENGTH + 1; r1++) { // rows 1-indexed!
            for (int r2 = r1; r2 < LENGTH + 1; r2++) { // rows 1-indexed!
                int[] s1 = new int[LENGTH];
                for (int c = 0; c < LENGTH; c++) {
                    s1[c] = s[r2][c] - s[r1 - 1][c];
                }
                int max = 0;
                int c1 = 0;
                for (int c = 0; c < LENGTH; c++) {
                    max = s1[c] + max;
                    if (max <= 0) {
                        max = 0;
                        c1 = c + 1;
                    }
                    if (max > maxSum) {
                        maxSum = max;
                        maxRowStart = r1 - 1;
                        maxColStart = c1;
                        maxRowEnd = r2 - 1;
                        maxColEnd = c;
                    }
                }
            }
        }

        System.out.print("KADANE SOLUTION |   Max sum: " + maxSum);
        System.out.print("   Start: (" + maxRowStart + ", " + maxColStart +
                ")   End: (" + maxRowEnd + ", " + maxColEnd + ")");
    }


    // O(N^6) !!!
    public static void naiveSolution(int[][] a) {
        int maxSum = Integer.MIN_VALUE;
        int maxRowStart = -1;
        int maxColStart = -1;
        int maxRowEnd = -1;
        int maxColEnd = -1;

        for (int rowStart = 0; rowStart < LENGTH; rowStart++) {
            for (int colStart = 0; colStart < LENGTH; colStart++) {
                for (int rowEnd = 0; rowEnd < LENGTH; rowEnd++) {
                    for (int colEnd = 0; colEnd < LENGTH; colEnd++) {
                        int sum = 0;
                        for (int row = rowStart; row <= rowEnd; row++) {
                            for (int col = colStart; col <= colEnd; col++) {
                                sum += a[row][col];
                            }
                        }
                        if (sum > maxSum) {
                            maxSum = sum;
                            maxRowStart = rowStart;
                            maxColStart = colStart;
                            maxRowEnd = rowEnd;
                            maxColEnd = colEnd;
                        }
                    }
                }
            }
        }

        System.out.print(" NAIVE SOLUTION |   Max sum: " + maxSum);
        System.out.print("   Start: (" + maxRowStart + ", " + maxColStart +
                ")   End: (" + maxRowEnd + ", " + maxColEnd + ")");
    }


    public static int[][] sumMatrix(int[][] arr) {
        int[][] resultMatrix = new int[arr.length][arr[0].length]; 
        for (int col = 0; col < arr[0].length; col++) 
            resultMatrix [0][col] = arr[0][col];
        for (int i = 1; i < arr.length; i++)  {
            for (int j = 0; j < arr[0].length; j++) {
                resultMatrix[i][j] = resultMatrix[i-1][j] + arr[i][j];
            }
        }
        return resultMatrix;
    }


    public static void printMatrix(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j<arr[0].length; j++) {
                if (j == arr[0].length - 1)
                    System.out.println(arr[i][j]);
                else
                    System.out.print(arr[i][j] +  ",");
            }
        }
    }
}
