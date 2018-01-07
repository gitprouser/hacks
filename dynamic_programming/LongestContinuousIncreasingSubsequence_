public class LongestContinuousIncreasingSubsequence {

    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence lcis = new LongestContinuousIncreasingSubsequence();
        int[] arr = {1,2,3,5,8,4};
        assert 5 == lcis.findLengthOfLCIS(arr);
    }

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
                currLCIS += 1;           //   incr currLCIS by 1.
                globalLCIS = Math.max(currLCIS, globalLCIS);  // update globalLCIS per need basis
            } else {
                currLCIS = 1;  // reset currLCIS counter if the value is less than previous value.
            }
        }
        return globalLCIS;  // return the global maximum value.
    }

}
