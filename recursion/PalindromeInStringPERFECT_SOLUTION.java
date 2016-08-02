import java.util.HashSet;
import java.util.Set;

/**
 * Created on 8/2/16.
 */
public class PalindromeInStringPERFECT_SOLUTION {
    public static void main(String[] args) {
        String s = "abca";
        Set<String> result = new HashSet<>();
        findPalindromes(s, result, new StringBuilder(), 0);
        for (String str : result)
            System.out.println(str);
    }

    static void findPalindromes(String s, Set<String> result, StringBuilder sb, int pos) {
        if (isPalindrome(sb))
            result.add(sb.toString());

        for (int i = pos; i < s.length(); i++) {
            sb.append(s.charAt(i));
            findPalindromes(s, result, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    static boolean isPalindrome(StringBuilder s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }
}
