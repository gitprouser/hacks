/**
http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/

Following are the two main steps to solve this problem:
1) Calculate sum of the array. If sum is odd, there can not be two subsets with equal sum, so return false.
2) If sum of array elements is even, calculate sum/2 and find a subset of array with sum equal to sum/2.

The first step is simple. The second step is crucial, it can be solved either using recursion or Dynamic Programming.

Recursive Solution
Look at recursive solution.

This solution is DP.
- A dynamic programming based Java program for partition problem
*/

import java.io.*;
import java.util.*;
import java.util.stream.*;


class PartitionProblem {
    // Returns true if arr[] can be partitioned in two subsets of
    // equal sum, otherwise false
    static boolean findPartition (int arr[], int n) {
        int sum = 0;
        // calculate sum of all elements
        for (int i = 0; i < n; i++)
            sum += arr[i];

        if (sum%2 != 0)
            return false;

        boolean part[][]=new boolean[sum/2 + 1][n + 1];

        // initialize top row as true
        for (int i = 0; i <= n; i++)
            part[0][i] = true;

        // initialize leftmost column, except part[0][0], as false
        for (int i = 1; i <= sum/2; i++)
            part[i][0] = false;

        // Fill the partition table in botton up manner
        for (int i = 1; i <= sum/2; i++) {
            for (int j = 1; j <= n; j++) {
                prettyPrint(part, sum, n);
                part[i][j] = part[i][j-1];
                if (i >= arr[j-1])
                    part[i][j] = part[i][j] || part[i - arr[j-1]][j-1];
            }
            prettyPrint(part, sum, n);
        }

        prettyPrint(part, sum, n);
        return part[sum/2][n];
    }

    /*Driver function to check for above function*/
    public static void main (String[] args) {
        int arr[] = {3, 1, 1, 2, 2,1};
        int n = arr.length;
        System.out.println("{" + Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(","))+ "}" + "\n" );
        if (findPartition(arr, n) == true)
            System.out.println("Can be divided into two " +
                               "subsets of equal sum");
        else
            System.out.println("Can not be divided into" +
                            " two subsets of equal sum");

    }


    private static void prettyPrint(boolean[][] part,int sum, int n) {
         System.out.println();
         StringBuffer sb = new StringBuffer();
         // uncomment this part to print table
         for (int i = 0; i <= sum/2; i++) {
             if (i == 1)
                 System.out.println(sb.toString());
             for (int j = 0; j <= n; j++) {
                 if (j == 0) {
                     System.out.print(i + " " );
                     sb.append("  ");
                 }
                 if (i == 0)
                     sb.append(j + " ");
                 System.out.format("%s ", part[i][j]? "T" : "F");
             }
             System.out.println();
        }
    }
        /**
                StringBuffer display_row = new StringBuffer();
                StringBuffer first_value_row = new StringBuffer();
                // uncomment this part to print table
                for (i = 0; i <= sum/2; i++) {
                    for (j = 0; j <= n; j++) {
                        if (j == 0) {  // if first column
                            if (i == 0) { // first row
                                display_row.append("  "  + i + " ");
                                first_value_row.append( i+ " ");
                            } else {
                                System.out.print(i + " " );
                            }
                        } else {
                            String t = part[i][j]? "T" : "F";
                            if (i == 0) {
                                display_row.append(j + " ");
                                first_value_row.append(t + " ");
                            } else
                                System.out.format("%s ", t);
                        }
                    }
                    if (i == 0)
                        System.out.print(display_row.toString() + "\n" + first_value_row.toString());
                    System.out.println();
                }
        */

}

