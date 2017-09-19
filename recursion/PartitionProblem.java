import java.io.*;

/**
http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/

Following are the two main steps to solve this problem:
1) Calculate sum of the array. If sum is odd, there can not be two subsets with equal sum, so return false.
2) If sum of array elements is even, calculate sum/2 and find a subset of array with sum equal to sum/2.

The first step is simple. The second step is crucial, it can be solved either using recursion or Dynamic Programming.

Recursive Solution
Following is the recursive property of the second step mentioned above.

Let isSubsetSum(arr, n, sum/2) be the function that returns true if there is a subset of arr[0..n-1] with sum equal to sum/2

The isSubsetSum problem can be divided into two subproblems
 a) isSubsetSum() without considering last element
    (reducing n to n-1)
 b) isSubsetSum considering the last element
    (reducing sum/2 by arr[n-1] and n to n-1)

If any of the above the above subproblems return true, then return true. 
isSubsetSum (arr, n, sum/2) = isSubsetSum (arr, n-1, sum/2) ||
                              isSubsetSum (arr, n-1, sum/2 - arr[n-1])
*/

class PartitionProblem {
    // A utility function that returns true if there is a
    // subset of arr[] with sun equal to given sum
    static boolean isSubsetSum (int arr[], int n, int sum) {

        // Base Cases
        if (sum == 0)
            return true;

        if (n == 0 && sum != 0)
            return false;

        /* If last element is greater than sum, then ignore it */
        if (arr[n-1] > sum)
            return isSubsetSum (arr, n-1, sum);

        /*
               Else, check if sum can be obtained by any of
               the following
                (*) including the last element  OR
                (*) excluding the last element
        */
        return isSubsetSum(arr, n-1, sum-arr[n-1] ||
               isSubsetSum(arr, n-1, sum);
    }

    // Returns true if arr[] can be partitioned in two
    // subsets of equal sum, otherwise false
    static boolean findPartition(int arr[], int n) {
        // Calculate sum of the elements in array
        int sum = 0;

        for (int i = 0; i < n; i++)
            sum += arr[i];

        // If sum is odd, there cannot be two subsets
        // with equal sum
        if (sum%2 != 0)
            return false;

        // Find if there is subset with sum equal to half
        // of total sum
        return isSubsetSum(arr, n, sum/2);
    }

    // Driver function to check for above function
    public static void main(String[] args) {
        int arr[] = {3, 1, 5, 9, 12};
        int n = arr.length;
        if (findPartition(arr, n) == true)
            System.out.println("Can be divided into two "+
                                "subsets of equal sum");
        else
            System.out.println("Can not be divided into " +
                                "two subsets of equal sum");
    }
}
