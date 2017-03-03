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

    static int[] arr = {0,0,0,1,1};
//                      0 1 2 3 4 5 6 7

    public static int firstBadVersion(int n) {
        int start = 0, end = n - 1;
        while (start + 1 < end) {
            int mid = start + (end -start) / 2;
            if (arr[mid] == 1) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (arr[start] == 1) {
            return start;
        }
        return end;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(arr.length));
    }
}
