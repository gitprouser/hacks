import java.util.*;

class MedianFinder_9Chapters {

    public static void main(String args[]) {
        MedianFinder_9Chapters m = new MedianFinder_9Chapters();
        int[] tc_odd = {1,2,3,4,5}; 
        int expected = 3;
        int actual = m.median(tc_odd);
        assert(expected==actual);

        int[] tc_even = {1,2,4,8};
        expected = 3;
        actual = m.median(tc_odd);
        assert(expected == actual);

        int[] tc_neg = {-11,-3,3,14};
        expected = 0;
        actual = m.median(tc_odd);
        System.out.println(actual);
        assert(expected==actual);

    }


    public int medianPQ(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(int o1, int o2) {
                return o2 - o1;
            }
        });

        maxHeap.offer();

    }


    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        return sub(nums, 0, nums.length - 1, (nums.length + 1)/2);
    }

    private int sub(int[] nums, int start, int end, int size) {
        int mid = (start + end) / 2;
        int pivot = nums[mid];
        int i = start - 1, j = end + 1;
        for (int k = start; k < j; k++) {
            if (nums[k] < pivot) {
                i++;
                swap(nums, i, k);
            } else if (nums[k] > pivot) {
                j--;
                swap(nums, j, k);
                k--;
            }
        }
        if (i - start + 1 >= size) {
            return sub(nums, start, i, size);
        } else if (j - start >= size) {
            return nums[j-1];
        } else {
            return sub(nums, j, end, size - (j - start));
        }
    }


    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

/*
    private int sub_without_swap(int[] nums, int start, int end, int size) {
        int mid = (start + end) / 2;
        int pivot = nums[mid];
        int i = start - 1, j = end + 1;
        for (int k = start; k < j; k++) {
            if (nums[k] < pivot) {
                i++;
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
            } else if (nums[k] > pivot) {
                j--;
                int tmp = nums[j];
                nums[j] = nums[k];
                nums[k] = tmp;
                k--;
            }
        }
        if (i - start + 1 >= size) {
            return sub(nums, start, i, size);
        } else if (j - start >= size) {
            return nums[j-1];
        } else {
            return sub(nums, j, end, size - (j - start));
        }
    }
*/
}
