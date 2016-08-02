import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
       _permute(result, new Stack<>(), nums);
        return  result;
    }

    static void _permute(List<List<Integer>> result, Stack<Integer> stack, int[] nums) {
        if (stack.size() == nums.length) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if (stack.contains(nums[i])) {
                continue;
            }

            stack.push(nums[i]);
            _permute(result, stack, nums);
            stack.pop();
        }
    }

    public static void _permutation(List<List<Integer>> result, int[] arr, int i) {
        if (i == arr.length) {
            List<Integer> list = new ArrayList<>();
            for (int k : arr)
                list.add(k);
            result.add(list);
            return;
        }

        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            _permutation(result, arr, i + 1);
            swap(arr, i, j);
        }
    }

    static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        //        _permutation(result, nums, 0);

        List<List<Integer>> result = permute(nums);
        for(List<Integer> list: result) {
            for (int i : list)
                System.out.print(i + " ");
            System.out.println();
        }
    }

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
