public class LongestContinuousIncreasingSubsequence {


    public int findLengthOfLCIS(int[] nums) {
        // boundary conditions: if the array lenght is less 1 then 
        if (nums.length == 0)
            return 0;


        // keep two counters:
        //      - currLCIS: keeps the current subsequence max count
        //      - globalLCIS: the maximum LCIS count seen so far.
        int currLCIS = 1,
            globalLCIS = 1;


        // Iterate through the array elements
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) { // if the current value is greater than the pervious value 
                currLCIS += 1;                                //   incr currLCIS by 1.
                globalLCIS = Math.max(currLCIS, globalLCIS);  // update globalLCIS per need basis
            } else {
                currLCIS = 1;  // reset currLCIS counter if the value is less than previous value.
            }

        }
        return globalLCIS;  // return the global maximum value.

    }


    public static void main(String[] args)  {

        LongestContinuousIncreasingSubsequence lisObj = new LongestContinuousIncreasingSubsequence();

        int[] arr_2 = {50, 3, 10, 17, 40, 80};
        System.out.println(lisObj.longestContinuousIncreasingSubsequence(arr_2));
        assert(lisObj.longestContinuousIncreasingSubsequence(arr_2) == 5);

        int[] arr = {3, 10, 2, 1, 20};
        System.out.println(lisObj.longestContinuousIncreasingSubsequence(arr));
        assert(lisObj.longestContinuousIncreasingSubsequence(arr) == 2);

        int[] arr_1 = {3, 2};
        System.out.println(lisObj.longestContinuousIncreasingSubsequence(arr_1));
        assert(lisObj.longestContinuousIncreasingSubsequence(arr_1) == 1);


        int[] arr_3 = {};
        System.out.println(lisObj.longestContinuousIncreasingSubsequence(arr_3));
        assert(lisObj.longestContinuousIncreasingSubsequence(arr_3) == 0);

    }


    public int longestContinuousIncreasingSubsequence(int[] arr) {
        if (arr.length == 0)
            return 0;

        int maxSoFar = 1,
            maxCurrLIS = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1])
               maxCurrLIS += 1;
            else
                maxCurrLIS = 1;

            maxSoFar = Math.max(maxSoFar, maxCurrLIS);
        }

        return maxSoFar;
    }
>>>>>>> 20180109
}
