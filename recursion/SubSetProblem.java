import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on 8/2/16.
 */
public class SubSetProblem {
    public static void main(String[] args) {
        String s = "abc";
        List<String> result = new ArrayList<>();
        subset(s, result, new StringBuilder(), 0);
        for(String str : result)
            System.out.println("\""+ str + "\"");
    }

    static void subset(String s, List<String> result, StringBuilder sb, int position) {
        result.add(sb.toString());

        for(int i = position; i < s.length(); i++) {
            sb.append(s.charAt(i));
            subset(s, result, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
