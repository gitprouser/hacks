/**
Best Time to Buy and Sell a stock. Leet Code Problems variation. Design an algorithm to find the maximum profit. 
You may complete *Unlimited* number of transaction. 


Test Cases:
t1 = [1, 3, 1, 2]
t2 = [1, 2, 3]
t3 = [5, 3, 2]
*/



public class BestTimeToBuyAndSell {
    public int maxProfit(int[] a) {
        int maxPro = 0;
        if (a.length == 0)
            return maxPro;

        int maxVal = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            maxPro += Math.max(maxPro, maxVal - a[i]);
            maxVal = Math.max(a[i], maxVal);
        }
        return maxPro;
    }
}
