/**
 *  Closest Number in Sorted Array
 *  Topic: Given a target number and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to the given target.
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

 */ 
