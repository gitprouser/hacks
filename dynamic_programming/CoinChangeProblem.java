/**
 *  You are given coins of different denominations and a total amount of money amount. 
 *  Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
    Example 1:
        coins = [1, 2, 5], amount = 11
        return 3 (11 = 5 + 5 + 1)

    Example 2:
        coins = [2], amount = 3
        return -1.

    Note:
    You may assume that you have an infinite number of each kind of coin.


*/

public class CoinChangeProblem {
    public int coinChange(int[] coins, int amount) {

        // ****** boundary conditions ******
        if (coins == null || coins.length == 0)
            return -1;

        if (amount <= 0)
            return 0;
        // ****** END boundary conditions *******

        int[] min = new int[amount + 1];
        for (int i = 0; i < min.length; i++)    // Initialization of the array...
            min[i] = Integer.MAX_VALUE;

        min[0] = 0;   // when you have zero amount to make there are zero ways to do it.

        // or you could initialize the arry to Integer.MAX_VALUE from idx=1 and leave idx=0 min[idx]=0 
        // I did this specifically to remember why we do the min[0] = 0;
        // for (int i = *1*; i < min.length; i++)
        //      min[i] = Integer.MAX_VALUE:


        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i                               // value is less than amount
                    && min[i - coins[j]] != Integer.MAX_VALUE   // Do not overflow
                    && min[i - coins[j]] + 1 < min[i])          // Why plus 1?
                                                                // Ans. Because you are actually selecting the coin whose value
                                                                // is coins[j]. This value coin is added to reduce the gap
                                                                // between the amount you want to make (which is I) and the
                                                                // amount you currently have made, that is (I - coins[j]).
                {
                        min[i] = min[i - coins[j]] + 1;         // Since this coin is added to your list of solutions in the
                                                                // arrary.
                }
            }
        }

        return min[amount] == Integer.MAX_VALUE ? -1 : min[amount] ;
    }

}
