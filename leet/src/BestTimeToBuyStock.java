public class BestTimeToBuyStock {

    public static int maxProfit(int[] arr) {
        if (arr == null) 
            return -1;

        int profit = 0;
        int min = Integer.MAX_VALUE;
        int startIdx = 0, candidateIdx = 0, endIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                candidateIdx = i;
            }

            if (arr[i] - min > profit) {
                profit = arr[i] - min;
                startIdx = candidateIdx; 
                endIdx = i;
            }
        }

        System.out.println("startIdx:" + startIdx + " buyPrice:" + arr[startIdx]);        
        System.out.println("endIdx:" + endIdx + " salePrice:" + arr[endIdx]);        
        return profit;
    }


    public static void main(String args[]) {
        int[] arr = {10,3,12,1145,17,29,122,22,18,-10};
        System.out.println(maxProfit(arr));
    }
}
