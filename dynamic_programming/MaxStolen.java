/**
 *
 * There are n houses built in a line, each of which contain some value in it.
 * A thief is going to steal in these houses. But he cannot steal in two adjacent houses.
 * What is maximum value he can steal?
 */

class MaxStolen {

    public static void main(String args[]) {
        int[] arr = {10,29,300,15,21}; 
        // System.out.println(" " +  maxStolenValue(arr));
        System.out.println(" " +  maxStolenValue_WITHOUT_OPTIMIZATION(arr));

    }

    static int maxStolenValue_WITHOUT_OPTIMIZATION(int[] arrHouseValues) {
        int[] dp = new int[arrHouseValues.length];
        dp[0] = arrHouseValues[0];
        dp[1] = Math.max(arrHouseValues[0], arrHouseValues[1]);

        for (int i = 2; i < arrHouseValues.length; i++)
            dp[i] = Math.max(dp[(i - 1)], dp[(i - 2)] + arrHouseValues[i]);

        for (int i = 0; i < dp.length; i++)
            System.out.print(dp[i] + " ");

        return dp[(arrHouseValues.length - 1)];
    }

    static int maxStolenValue(int[] arrHouseValues) {
        int[] dp = new int[2]; // [arrHouseValues.length];
        dp[0] = arrHouseValues[0];
        dp[1] = Math.max(arrHouseValues[0], arrHouseValues[1]);

        for (int i = 2; i < arrHouseValues.length; i++)
            dp[i%2] = Math.max(dp[(i - 1)%2], dp[(i - 2)%2] + arrHouseValues[i]);

        return dp[(arrHouseValues.length - 1)%2];
    }
}
