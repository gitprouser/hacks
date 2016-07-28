import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permutations {

    // DFS approach	
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        // use a stack to do DFS
        // use DFS recursion to fill in the result list
        _permute(result, new Stack<>(), nums, new ArrayList<>());
        return  result;
    }

    private static void _permute(List<List<Integer>> result, Stack<Integer> stack, int[] nums, List<Integer> seenBefore) {
        // if the stack reaches a leaf of the tree, then add the content to the result;
        // once the method returns, the stack will be popped by one element (see the last
        // statement)
        if (stack.size() == nums.length) {
            if (isNotInResult(new ArrayList<>(stack), result))
                result.add(new ArrayList<>(stack));
            return; // this return also causes pop
        }

        for (int i = 0; i < nums.length; i++) {
            // if this number was visited already,
            // then don't add it to the stack again
            if (seenBefore.contains(i))
                continue;

            stack.push(nums[i]);
            seenBefore.add(i);
            _permute(result, stack, nums, seenBefore);
            stack.pop();
            seenBefore.remove(seenBefore.size() - 1);
        } // overflow pop the stack and Return...
    }
    public static void main(String[] args) {
        int[] nums = {4,4,4,2};

        List<List<Integer>> result = permute(nums);
        for(List<Integer> list: result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


    private static boolean isNotInResult(List<Integer> currResult, List<List<Integer>> result) {
        for(List<Integer> list : result) {
            if (list.size() != currResult.size())
                return false;

                int i = 0;
                while(i < list.size() && list.get(i) == currResult.get(i++))
                    ;
                if (i == list.size())
                    return false;
        }
        return true;
    }
    //    private static void _permuteWithIndent(List<List<Integer>> result, Stack<Integer> stack, int[] nums, int indent) {
//        // if the stack reaches a leaf of the tree, then add the content to the result;
//        // once the method returns, the stack will be popped by one element (see the last
//        // statement)
//        if (stack.size() == nums.length) { // exit condition <-------
//            for(int j =0; j < indent; j++)
//                System.out.print("\t");
//            System.out.println("------->add to result, return ...");
//            result.add(new ArrayList<Integer>(stack));
//            --indent;
//            return; // this return also causes pop
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (stack.contains(nums[i])) {
//                // if this number was visited already,
//                // then don't add it to the stack again
//                for(int j =0; j < indent; j++)
//                    System.out.print("\t");
//                System.out.println("------->i = " + i + ", already visited, skip");
//                continue;
//            }
//            // otherwise add it to the stack
//            for(int j =0; j < indent; j++)
//                System.out.print("\t");
//            System.out.println("------->i = " + i + ", push to stack: " + stack);
//            stack.push(nums[i]);
//            // and visit the next level <--------
//            for(int j =0; j < indent; j++)
//                System.out.print("\t");
//            System.out.println("------->i = " + i + ", after push, before _permute: " + stack);
//            _permuteWithIndent(result, stack, nums, ++indent);
//            // go back up one level, and in the next iteration, visit the next element
//            // (with index i++ in nums[]) in the same level
//            for(int j =0; j < indent; j++)
//                System.out.print("\t");
//            System.out.println("------->i = " + i + ", after _permute, before pop: " + stack);
//            stack.pop();
//            for(int j =0; j < indent; j++)
//                System.out.print("\t");
//            System.out.println("------->i = " + i + ", after pop " + stack);
//        } // overflow pop the stack and Return...
//    }
//
//
//    /**
//     * @param nums: A list of integers.
//     * @return: A list of permutations.
//     */
//    public ArrayList<ArrayList<Integer>> permuteList(ArrayList<Integer> nums) {
//        // write your code here
//
//        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//        if (nums == null || nums.size() == 0) {
//            return result;
//        }
//        Stack<Integer> stack = new Stack<>();
//        helperList(result, stack, nums);
//        return result;
//    }
//
//    private void helperList(ArrayList<ArrayList<Integer>> result,
//                            Stack<Integer> stack,
//                            ArrayList<Integer> nums)
//    {
//        if (stack.size() == nums.size()) {
//            result.add(new ArrayList<Integer>(stack));
//            return;
//        }
//        for (Integer i : nums) {
//            if (stack.contains(i)) {
//                continue;
//            }
//            stack.push(i);
//            helperList(result, stack, nums);
//            stack.pop();
//        }
//    }
//
//    /**
//     * @param nums: A list of integers.
//     * @return: A list of permutations.
//     */
//    public ArrayList<ArrayList<Integer>> permuteCC150(ArrayList<Integer> nums) {
//        // write your code here
//        ArrayList<ArrayList<Integer>> returnValues = new ArrayList<>();
//
//        if (nums == null) {
//            return returnValues;
//        }
//        if (nums.size() == 0) { // the empty list is needed
//            ArrayList<Integer> emptyList = new ArrayList<>();
//            returnValues.add(emptyList);
//            return returnValues;
//        }
//
//        int last = nums.remove(nums.size()-1);
//        ArrayList<ArrayList<Integer>> subPerms = permuteCC150(nums);
//        // insert the new item (the last item) to all the possible positions
//        for (ArrayList<Integer> list : subPerms) {
//            for (int i=0; i<=list.size(); i++) {
//                ArrayList<Integer> tmp = new ArrayList<Integer>(list);
//                tmp.add(i, last);
//                returnValues.add(tmp);
//            }
//        }
//        return returnValues;
//    }
}
