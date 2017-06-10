/**
 * Created on 7/24/16.
 */
public class BinarySearch {

    public static void main(String[] args) {
//        int l_idx = leftMostBinarySearch(0, 9, new int[]{0, 1, 1, 1, 1, 1, 2, 2, 3, 3}, 1);
//        int r_idx = rightMostBinarySearch(0, 9, new int[]{0, 1, 1, 1, 1, 1, 2, 2, 3, 3}, 1);

        System.out.println("hello");                // 0  1  2  3  4  5  6  7  8  9
        int l_idx = nonRecursiveBinarySearch(new int[]{0, 1, 1, 1, 1, 1, 2, 2, 3, 3}, 1);
        int r_idx = nonRecursiveRightMostBinarySearch(new int[]{0, 1, 1, 1, 1, 1, 2, 2, 3, 3}, 1);
        System.out.println(l_idx + " " + r_idx);

        // indexes that need to be looked at
//        System.out.println(l_idx + " " + r_idx);
    }

    static int leftMostBinarySearch(int low, int high, int[] arr, int key) {
        int mid = low + (high - low)/2;
        if (arr[mid] == key) {
            if (arr[mid] == arr[mid - 1]) {  // modification
                return leftMostBinarySearch(low, mid - 1, arr, key);
            }if (low == mid) { // if we are the left most edge then we would break without this function
                return mid;
            } else {
                return mid;
            }
        } else {
            if (arr[mid] > key) {
                return leftMostBinarySearch(low, mid, arr, key);
            } else
                return leftMostBinarySearch(mid + 1, high, arr, key);
        }
    }

    static int rightMostBinarySearch(int low, int high, int[] arr, int key) {
        int mid = low + (high - low)/2;
        if (arr[mid] == key) {
            if (high == mid) { // if we are the right most edge then we would break without checking the right most edge. Imp stuff to remember
                return mid;
            }
            if (arr[mid] == arr[mid + 1]) {  // modification
                return rightMostBinarySearch(mid + 1, high, arr, key);
            } else {
                return mid;
            }
        } else {
            if (arr[mid] > key) {
                return rightMostBinarySearch(low, mid, arr, key);
            } else
                return rightMostBinarySearch(mid + 1, high, arr, key);
        }
    }

    static int nonRecursiveBinarySearch(int[] A, int n) {
        int lo = 0, high = A.length - 1;

        // Step 1. Remember you want to keep two elements to look up base
        while (lo + 1 < high) {
            int mid = lo + (high - lo) / 2;  // mid point best code.
            if (A[mid] == n)
                high = mid;
            else
                lo = mid;
        }

        if (A[lo] == n)  return lo;
        else if (A[high] == n) return high;
        else throw new RuntimeException("did not find element"); // target not found
    }


    static int nonRecursiveRightMostBinarySearch(int[] A, int n) {
        int lo = 0, high = A.length - 1;

        while (lo + 1 < high) {
            int mid = lo + (high - lo) / 2;
            if (A[mid] == n)
                lo = mid;
            else
                high = mid;
        }

        if (A[high] == n)  return high;
        else if (A[lo] == n) return lo;
        else throw new RuntimeException("Did not find element");
    }

}
