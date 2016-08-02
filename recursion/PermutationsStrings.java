import java.util.ArrayList;
import java.util.List;

/**
 * Created on 8/2/16.
 * TODO: Has to be unique string
 */
public class PermutationsStrings {

    public static void main(String[] args) {
        String s = "abc";
        List<String> result = new ArrayList<>();
        _permutation(s, result, new StringBuilder());
        for (String str : result)
            System.out.println(str);
    }

    static void _permutation(String s, List<String> result, StringBuilder sb) {
        if (sb.length() == s.length()) {
            result.add(sb.toString());
        }

        for (int i = 0; i < s.length(); i++) {
            if (sb.indexOf(""+s.charAt(i)) != -1) {
                continue;
            }
            sb.append(s.charAt(i));
            _permutation(s, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
