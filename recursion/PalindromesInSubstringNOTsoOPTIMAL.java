import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created on 8/1/16.
 */
public class PalindromesInSubstringNOTsoOPTIMAL {

    public static void main(String[] args) {
        String s = "abca";
        for (String elem : findPalindromes(s)) {
            System.out.println(elem);
        }
    }

    static Set<String> findPalindromes(String s) {
        Set<String> result = new HashSet<>();
        boolean[] visited = new boolean[s.length()];
        _permute(new Stack<>(), result, s.toCharArray(), visited);
        return result;
    }

    static void _permute(Stack<Character> stack, Set<String> result, char[] num, boolean[] visited) {
        if (isPalindrome(stack) && !result.contains(toStringStack(stack)))
            result.add(toStringStack(stack));

        if (stack.size() == num.length)
                return;

        for (int i = 0; i < num.length; i++) {
            if (visited[i] || (i > 0 && num[i-1] == num[i] && !visited[ i - 1] ))
                continue;

            visited[i] = true;
            stack.push(num[i]);
            _permute(stack, result, num, visited);
            stack.pop();
            visited[i] = false;
        }
    }

    static String toStringStack(Stack<Character> stack) {
        if (stack.isEmpty())
            return "";

        Stack<Character> tmpStack = new Stack<>();
        deepCopyStack(stack, tmpStack);

        StringBuilder sb = new StringBuilder();
        while (!tmpStack.isEmpty())
            sb.append(tmpStack.pop());

        return sb.toString();
    }

    static boolean isPalindrome(Stack<Character> s) {
        if (s.empty())
            return true;

        Stack<Character> tmpStack = new Stack<>();
        deepCopyStack(s, tmpStack);

        char[] c = new char[tmpStack.size()];
        int j = 0;
        while(!tmpStack.isEmpty())
            c[j++] = tmpStack.pop();

        for (int i = 0; i < c.length / 2; i++) {
            if (c[i] != c[c.length - i - 1])
                return false;
        }
        return true;

    }

    static void deepCopyStack(Stack<Character> a, Stack<Character> b) {
        char[] tmp = new char[a.size()];
        int j = 0;
        while(!a.isEmpty())
            tmp[j++] = a.pop();

        for(int i = tmp.length - 1; i >= 0; i--) {
            b.push(tmp[i]);
            a.push(tmp[i]);
        }
//        System.out.println("Stack A:" + b.peek() + " STack b :" + a.peek());
    }
}
