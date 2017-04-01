import java.util.*;

public class BestTimeToBuyStock_2 {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return -1;

        int[] maxProfit = new int[prices.length];
        maxProfit[0] = 0;  // sell the stock the same day you buy you make zero profit.
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit[i] = Math.max(maxProfit[i - 1], prices[i] - min);
            min = Math.min(prices[i], min);
        }

        int profit = maxProfit[0];
        for (int i = 0; i < prices.length; i++)
            profit = Math.max(profit, maxProfit[i]);

        return profit;
    }

	public static void main(String[] args) {
		int[] arr = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit(arr));
	}
}
