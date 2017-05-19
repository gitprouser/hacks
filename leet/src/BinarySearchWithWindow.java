public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            /*
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
            }*/
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
}
