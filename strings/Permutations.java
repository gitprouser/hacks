class Permutations {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
 
        if (nums == null) {
            return results;
        }
    
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[nums.length];
        for ( int i = 0; i < visited.length; i++){
            visited[i] = 0;
        }
     
        helper(results, list, visited, nums);
        return results;
    }
 
 
    public void helper(ArrayList<List<Integer>> results, 
                   ArrayList<Integer> list, int[] visited, int[] nums) {

        if (list.size() == nums.length) {
            results.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if ( visited[i] == 1 || ( i != 0 && nums[i] == nums[i - 1]
            		&& visited[i-1] == 0)){
                continue;
            }
            /*
              The above is determined primarily to remove repeated impact element.
              For example, given an array of rows sorted, [1,2,2], 
			  then the first 2 and second 2 if interchanged in results,
             
			  We also believe that the same kind of program, 
			  we enforce the same numbers, the top surface of the original, the result
              Which should be standing in the front, thus ensuring the uniqueness. 

			So when the current surface 2 has not been used, it is 2 should not be allowed to use the back.
            */
            visited[i] = 1;
            list.add(nums[i]);
            helper(results, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
     }
}
