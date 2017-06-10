/**
 * First Bad Version:
 *
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the
 * first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */

public class FirstBadVersion {

    static int[] arr = {0,0,1,1,1,1,2,2,2, 3};
//                      0 1 2 3 4 5 6 7 9 10

    public static int firstBadVersion(int n) {
        int start = 0, end = n - 1;
        // Step 1. Remember you want to keep two elements to look up base
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;  // mid point best code.
            if (arr[mid] == 1) {  // if the product doesn't meet quality
                end = mid;        // Remove all the products to the right because you know they will also not meet the
                                  // quality requirement.
            } else {
                start = mid;      // If the product meets the quality forget all products to the left of this because
                                  // you know for a fact those products will also meet the quality.
            }
        }
        if (arr[start] == 1) {    // if the left product is bad then that's the left most.
            return start;
        }
        return end;               // else the right product in the tuple is the first bad product.
    }

    public static int lastBadVersion(int n) {
        int start = 0, end = n - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if (arr[mid] == 1)
                start = mid;
            else if (arr[mid] > 1)
                end = mid;
            else
                start = mid;
        }
        if (arr[end] == 1) {
            return end;
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println("startIdx:" + firstBadVersion(arr.length));
        System.out.println("endIdx:" + lastBadVersion(arr.length));
    }
}
