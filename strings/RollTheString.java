/**
 *
 * Created dgayash on 3/30/17.
 */
public class RollTheString {
    public static void main(String[] args) {
        String s = "vwxyz";
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(rollUp(s, arr));
    }

    public static String rollUp(String s, int[] arr) {
        int[] dp = new int[s.length()];

        for (int i : arr)
            for (int j = 0; j < i; j++)
                dp[j] += 1;

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < dp.length; i++) {
            char k = sb.charAt(i);
            k = (char) (((k + dp[i] - 'a') % 26) + 'a');
            sb.setCharAt(i, k);
        }
        return sb.toString();
    }
}
