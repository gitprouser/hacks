/**
 * Created dgayash on 3/15/17.
 */
public class MaximumSubArrayProblem {

    public static int maxSubArray(int[] arr) {
        int currMax = 0;
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            currMax += i;
            if (currMax >= max) {
                max = currMax;
                System.out.println("currMax:'"+ currMax + "'");
                System.out.println("max:'"+ max + "'");
            } else {
                currMax = i;
                currMax = max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }
}
