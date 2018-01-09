// https://leetcode.com/problems/house-robber/description/
class HouseRobber {

    // Simple DP with no space efficiency
    public int rob_space_inefficient(int[] nums) {
        if (nums.length > 1) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < nums.length; i++)
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

            return dp[nums.length - 1];
        } else {
            return (nums.length == 1)? nums[0]: 0;
        }
    }


    public int rob_dp(int[] nums) {
        if (nums.length > 1) {
            // More memory efficient method.
            // Since evaluation happens only on only *TWO* values
            //
            // 1. The house adjacent to yours = dp[i - 1]
            // 2. The house two doors to the left = dp[i - 2]
            //
            // Therefore you can get away by only maintaining these two values
            // in a 2 slot array.

            int[] dp = new int[2];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            // If the `i` is even:
            //      add the a[i] to the even slot of the array
            //      add to the even slot Max of a[even #] + even slot OR a[odd #]
            // else:
            //      add the a[i] to the odd slot of the array
            //      add to the odd slot Max of a[odd #] + odd slot OR a[even #]
            //
            for (int i = 2; i < nums.length; i++)
                dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[i]);

            return Math.max(dp[0], dp[1]);
        } else {
            return (nums.length == 1)? nums[0]: 0;
        }
    }

    public static void main(String args[]) {
        // int[] houses = {1,2,3,23,112,41,59};
        int[] houses = {1,2};
        HouseRobber h = new HouseRobber();
        System.out.println(h.rob_dp(houses));
    }

}
