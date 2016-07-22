import java.util.ArrayList;
import java.util.List;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "723";
        List<String> result = new ArrayList<>();
        _decodeWays(s, "", result);
        for (String str : result) {
            System.out.println(str);
        }
        System.out.println("Number of ways to Decode string:" + numDecodeWays(s));
    }


    public static void _decodeWays(String str, String curr, List<String> result) {
        if (str.length() == 0) {
            result.add(curr);
            return;
        }
        for (int cnt = 1; cnt <= 2; cnt++) {
            if (str.length() < cnt)
                continue;
            String slice = str.substring(0, cnt);
            if (Integer.parseInt(slice) > 26)
                continue;
            char c = (char) (Integer.parseInt(slice) - 1 + 'A');
            _decodeWays(str.substring(cnt), curr.concat(Character.toString(c)), result);
        }
    }

    static int numDecodeWays(String str) {
        int n = str.length();
        if (n == 0) return 0;

        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n-1] = str.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (str.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(str.substring(i, i+2)) <=26) ? memo[i+1] + memo[i+2] : memo[i+1];
        return memo[0];
    }
}
