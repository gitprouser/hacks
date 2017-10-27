public class 3Sum {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return   Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int target = -1 * numbers[i];
            // note that "left" begins with i + 1 (instead of 0) to make sure
            // we don't look at something we already examined
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(numbers[i]);
                    tmp.add(numbers[left]);
                    tmp.add(numbers[right]);
                    result.add(tmp);
                    // don't forget the following two statements
                    left++;
                    right--;
                    // note that:
                    // 1. it is a while loop, not a simple if
                    // 2. don't forget left < right
                    while (left != 0 && left < right && numbers[left] == numbers[left - 1]) {
                        left++;
                    }
                    while (right != numbers.length - 1 && left < right && numbers[right] == numbers[right + 1]) {
                        right--;
                    }
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
