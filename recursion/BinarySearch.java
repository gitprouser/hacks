/**
 * Created on 7/24/16.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int l_idx = leftMostBinarySearch(0, 9, new int[]{0, 1, 1, 1, 1, 1, 2, 2, 3, 3}, 1);
        int r_idx = rightMostBinarySearch(0, 9, new int[]{0, 1, 1, 1, 1, 1, 2, 2, 3, 3}, 1);

        // indexes that need to be looked at
        System.out.println(l_idx + " " + r_idx);
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
}
