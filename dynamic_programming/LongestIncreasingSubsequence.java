class LongestIncreasingSubsequence {

    private int calculateLIS(int[] arr) {
        if (arr.length == 0)
            return 0;


        // LIS for arr[i] is given by this array's ith idx
        int[] l = new int[arr.length];


        // global_max_lis this value will be updated as we move along the array
        int max_so_far = 1;


        // Because LIS of a 1 element array is always 1.
        l[0] = 1;


        // NOTE: You are iterating from the 1st idx of the array
        for (int i = 1; i < arr.length; i++) {
            l[i] = 1;   // initially the value is set 1 because this might be the smallest
                        //  element in the array. However if it's not you will figure out the 
                        //  LIS for this sub array by going through all elements from arr[0],
                        //  arr[1], arr[2].... arr[n-1]

            // Iterate from the first element till idx of (i)
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])  // If there exists a number smaller than curr value,
                // this may be a potential longest increasing subsequence. So start the count

                    l[i] = Math.max(l[i], 1 + l[j]);  // Check if the new lis is bigger than
                         // the curr LIS at l[i] for arr[0-i]
                         // cached by L[i]th idx.
                         // If the new LIS is greater than the old value seen so far
                         // then replace that value with the new value.
            }

            max_so_far = Math.max(max_so_far, l[i]);
        }

        return max_so_far;
    }


    public static void main(String args[]) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println("Length of calculateLIS is " + new LongestIncreasingSubsequence().calculateLIS(arr));
    }

}
