public class MaximumProfit {
    public static void main(String args[]) {
        int[] l = {10, 6, 4, 2, 15};
        int[] h = {15, 9, 6, 3, 28};
        int[] s = {1, 12, 7, 5, 2, 27};
        System.out.println(maximumProfit(s)); 
    }

    static int maximumProfit(int[] s) {
        int max = -1;
        for(int i = 0; i < s.length - 1; i++) {
            for(int j = i + 1; j < s.length; j++) {
                int currMax = s[j] - s[i];
                max = (currMax <= max)? max : currMax;  
            } 
        }
        return max;
    }
}
