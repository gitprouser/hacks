import java.util.ArrayList;
import java.util.List;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "12";

        List<String> result = new ArrayList<>();
        _decodeWays2(s, "", result);
        System.out.println("result1");
        print(result);

        List<String> result1 = new ArrayList<>();
        _decodeWays1(s, "", result1);
        print(result1);

        System.out.println("Number of ways to Decode string:" + numDecodeWays(s));
    }


    public static void _decodeWays2(String str, String curr, List<String> result) {
        if (str.length() == 0) {
            result.add(curr);
            return;
        }
        for (int cnt = 1; cnt <= 2; cnt++) {
            if (str.length() < cnt)
                continue;
            String slice = str.substring(0, cnt);
            int num = Integer.parseInt(slice);
            if (num > 26)
                continue;
            System.out.println("curr: '" + curr + "',str:" + str);
            char c = (char) (num - 1 + 'A');
            _decodeWays2(str.substring(cnt), curr.concat(Character.toString(c)), result);
        }
    }


    public static void _decodeWays1(String str, String curr, List<String> result) {
        if (str.length() == 0) {
            result.add(curr);
            return;
        }
        String slice = str.substring(0, 1);
        int num = Integer.parseInt(slice);
        System.out.println("curr: '" + curr + "',str:" + str);
        char c = (char) (num - 1 + 'A');
        _decodeWays1(str.substring(1), curr.concat(Character.toString(c)), result);
        if (str.length() >= 2) {
            num = Integer.parseInt(str.substring(0, 2));
            if (num < 26 && num > 0) {
                c = (char) (num - 1 + 'A');
                _decodeWays1(str.substring(2), curr.concat(Character.toString(c)), result);
            }
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

    public static void print(List<String> result) {
        for (String str : result) {
            System.out.println(str);
        }
    }
}
