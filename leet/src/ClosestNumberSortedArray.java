/**
 *  Closest Number in Sorted Array
 *  Topic: Given a target number and an integer array A sorted in ascending order, find the index i in A 
           such that A[i] is closest to the given target.
 *         Return -1 if there is no element in the array. 
 *  Analysis: The main note of the final selection start or end of the thing on the line
              Sorted array with recovery required.  <4, 5, 6, 1, 2>     here arr[lo] = 4 
                                                                        All numbers to the top are > arr[lo]
                                                                        here arr[hi] = 2
                                                                        All numbers to the bottom of the line are < arr[lo]
 
                       /     
                      / |         All values to the top of the line are *GREATER* than arr[lo]
                     /  |
                    /   |
    index:   (lo) -------------- (hi)
                        |      /  
                        |    /   All values to the top of the line are *LESSER* than arr[hi]
                        |  /
                         /

https://yisuang1186.gitbooks.io/-shuatibiji/closest_number_in_sorted_array.html
 */ 

public ClosestNumberSortedArray {
  /**
   * @param A an integer array sorted in ascending order
   * @param target an integer
   * @return an integer idx of the closest element of the array to the target
   */
  public int closestNumber(ArrayList<Integer> arr, int target) {
    if (arr.size() == 0) 
      return -1

    int lo = 0, hi = arr.size();
    while (lo + 1 < hi) {
      int mid = lo + (hi - lo) / 2;
      if (arr[mid] == target) {
        return mid;
      } 
      else if (arr[mid] > target) {
        hi = mid;    
      } else {
        lo = mid;  
      }
    }
    
    /**
                   arr[lo]   arr[hi]
number line 
            -ve <----+-----+---------> +ve    
            
            So target can be either:
              - left of arr[lo] 
              - right of arr[hi]
              - inbetween arr[lo] and arr[hi]
     */
    
    // target is left of arr[lo]
    if (arr[lo] <= target)
      return lo;
    
    // target is right of arr[hi] 
    else if (arr[hi] <= target)
      return hi;
    
    // target is between arr[lo] < *target* < arr[hi] 
    // You will need to check, which element in the array is closer to the target.
    //    int lowToTarget = target - arr[lo];
    //    int highToTarget = arr[hi] - target;
    else (
      if (arr[hi] - target < target - arr[lo])
        return hi;
      else
        return lo;
    }
  }
  
  public static void main(String[] args) {
    ClosestNumberSortedArray cs = new ClosestNumberSortedArray();
    assert (31, cs.closestNumber(Arrays.asList(10,22,31,41,50), 35)); 
  }
}
