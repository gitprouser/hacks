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
}
