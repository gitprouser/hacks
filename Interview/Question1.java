import java.util.Stack;

/**
 * Created dgayash on 11/28/16.
 */
public class Question1 {
    public static void main(String[] args) {
        String t1 = "[](){}<>";  // return 1
        String t2 = "(h[e{lo}!]~)()()()(";  // return 0
        System.out.println(hasBalancedBrackets(t1));
        System.out.println(hasBalancedBrackets(t2));
        System.out.println(hasBalancedBrackets("()"));
        System.out.println(hasBalancedBrackets("("));
    }

    public static int hasBalancedBrackets(String str) {
        if (str == null || str.length() == 0)
            return 1;

        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                case '<':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return 0;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return 0;
                    break;
                case '>':
                    if (stack.isEmpty() || stack.pop() != '<')
                        return 0;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return 0;
                    break;
                default:  // ignoring all other characters
                    break;
            }
        }
        return stack.isEmpty()? 1 : 0;
    }
}
