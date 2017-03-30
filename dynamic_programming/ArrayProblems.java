/**
 * Created dgayash on 3/16/17.
 */
public class ArrayProblems {
    public static void main(String[] args) {
        int[] i = {1,2,-3,4,5,6,-7,8,9};
        System.out.println(maxSubArray(i));
    }

    public static int maxSubArray(int[] a) {
        int maxEndHere = Integer.MIN_VALUE, maxSoFar = Integer.MIN_VALUE;
        int s = -1, e = -1;
        for (int i = 0; i < a.length; i++) {
            if (maxEndHere + a[i] > a[i]) {
                e = i;
                maxEndHere = maxEndHere + a[i];
            } else {

            }
            maxSoFar = Math.max(maxEndHere, maxSoFar);
        }
        return maxSoFar;
    }

    public class Solution {
        /**
         *@param A : an integer rotated sorted array
         *@param target :  an integer to be searched
         *return : an integer
         */
        public int search(int[] A, int target) {
            if (A == null || A.length == 0) {
                return -1;
            }

            int start = 0, end = A.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (A[mid] == target) {
                    return mid;
                }

                if (A[mid] >= A[start]) { // mid is in the beginning half
                    if (target < A[start]) { // target is in the ending half
                        start = mid;
                    } else { // target >= A[start], target is in the beginning half
                        if (A[mid] < target) {
                            start = mid;
                        } else {
                            end = mid;
                        }
                    }
                } else { // mid < A[start] // mid is in the ending half
                    if (target >= A[start]) { // target is in the beginning half
                        end = mid;
                    } else { // target < A[start] // target is in the ending half
                        if (A[mid] < target) {
                            start = mid;
                        } else {
                            end = mid;
                        }
                    }
                }
            }
            if (A[start] == target) {
                return start;
            }
            if (A[end] == target) {
                return end;
            }
            return -1;
        }
            /***
             if (target > A[start]) { // target is in the beginning half
             if (A[mid] < A[start]) {
             end = mid;
             } else { // mid >= A[start]
             if (A[mid] > target) {
             end = mid;
             } else {
             start = mid;
             }
             }
             } else { // target < A[start], target is in the ending half
             if (A[mid] > A[end]) {
             start = mid;
             } else { // mid <= A[end]
             if (A[mid] > target) {
             end = mid;
             } else {
             start = mid;
             }
             }
             }
             }
             ***/
    }

}
