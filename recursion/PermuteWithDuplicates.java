import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created on 7/30/16.
 */
public class PermuteWithDuplicates {

    // accepted by leetcode
    public static List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) {
            return result;
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[num.length];
        Arrays.sort(num);
        helper(result, stack, num, visited);
        return result;
    }

    private static void helper(List<List<Integer>> result, Stack<Integer> stack, int[] num, boolean[] visited) {
        if (stack.size() == num.length) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (visited[i] ||
                (i != 0 && num[i] == num[i-1] && !visited[i-1]))
                continue;

            visited[i] = true;
            stack.push(num[i]);
            helper(result, stack, num, visited);
            stack.pop();
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 1};

        for(List<Integer> list : permuteUnique(a)) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}


