import java.util.Arrays;
import java.util.Stack;

/**
 * Created on 8/24/16.
 * http://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/
 *    Input:  arr[] = {1, 6, 4, 10, 2, 5}
 *    Output:         {_, 1, 1,  4, 1, 2}
 *    First element ('1') has no element on left side. For 6,
 *    there is only one smaller element on left side '1'.
 *    For 10, there are three smaller elements on left side (1, 6 and 4), nearest among the three elements is 4.
 *    Input: arr[] = {1, 3, 0, 2, 5}
 *    Output:        {_, 1, _, 0, 2}
 *
 *
 */
public class DiscountSumProblem {
    public static void main(String[] args) {
        int[] arr = {11, 6, 4, 10, 2, 5};
        int[] expected = { 6, 4, 2,  2, 0, 0};
        int[] result = discountSumProblem(arr);
        assert Arrays.equals(expected, result);
        System.out.println("All passed");
    }

    public static int[] discountSumProblem(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() > arr[i])
                s.pop();
            if (s.isEmpty())
                result[i] = 0;
            else
                result[i] = s.peek();

            s.push(arr[i]);
        }
        return result;
    }
}
