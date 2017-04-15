/**
Best Time to Buy and Sell a stock. Leet Code Problems variation. Design an algorithm to find the maximum profit 
you can make with the following criteria. 

- You may complete *Unlimited* number of transaction. 
- You may buy and sell at any time. 
- Given are only a list of prices in a given day of the stock.
- In a given day you may buy only ONCE but you can sell multiple stocks in a given day.


Test Cases:
t1 = [1, 3, 1, 2]  
o/p= 3 - 1 = 2 and 2 - 1 = 1 
   = 3, therefore you will have 3 bucks profit by buying at 1 and selling at 3 and buying again at 1 (idx=2) and selling it at 2 (idx=3)

t2 = [1, 2, 3]  
o/p= 3 - 1 = 2 and 3 - 2 = 1 
   = 2 + 1 = 3 best transactions you can make is 3 bucks. :)

t3 = [5, 3, 2]  
o/p= 5 - 3 = -ve and 3 - 2 = -ve and 5 - 2 = -ve
   = *0* best thing in this situation is not to buy any stock.

t4 = [1,2,100]  
o/p = 100 - 1 = 99 and 100 - 2 = 98
    = Buy at 1 (idx = 0) and sell it at 100 (idx = 2)  = 99 bucks made
    = Also, buy at 2 (idx = 1) and sell it at 100 (idx = 2) = 98 bucks made
    = 99 + 98 = *197*
           
*/
public class BestTimeToBuyAndSell {
    // DP solution to the problem. The smart thing here is 
    // You are starting from the back of the array. 
    // Egs: <1, 2, 100>
    // You start from the back that's when idx = 2 or single element <100>. 
    // <100> -> O/P will be *0*
    // Next you add another value: <2,100> -> O/P will be 
    public int maxProfit(int[] a) {
        int maxPro = 0;
        if (a.length == 0)
            return maxPro;

        // Let the maxValue equal to the last value in the array.
        int maxVal = a[a.length - 1];
        // Start from the second last element and go backwards. 
        for (int i = a.length - 2; i >= 0; i--) {
            // If the maxValue seen subtracted from the currect array[i] element is greater than max Value.
            // Then add that to the maxProfit.
            maxPro += Math.max(maxPro, maxVal - a[i]);
            // Check if the current value is greater than maxValue seen so far. 
            // update maxVal for next iteration.
            maxVal = Math.max(a[i], maxVal);
        }
/**
   line:48 - maxProfit should be checked with the previous maxValue not considering a[i]. 
   maxValue is the maximum value seen from a[i + 1]....to....a[a.length - 1] (inclusive)
   Therefore you cannot swap lines 51 and 48. 
   Because that would mean you are
   
   Egs: <1, 2, 100>
   Sample array for getting the maxValue of terms before a[i]: 
   <100> when a[i] = 2
   <2,100> when a[i] = 1
   
   line:51 - adds the current value to the maxValue sampling population. 
            At Line 51 the sampling value is now a[i] ... to ... a[a.length - 1] (inclusive)
   .
 */
        return maxPro;
    }
}
