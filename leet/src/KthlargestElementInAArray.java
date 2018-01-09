/**

    Find the kth largest element in an unsorted array. 
    Note that it is the kth largest element in the sorted order, not the 
    kth distinct element.

    For example,
    Given [3,2,1,5,6,4] and k = 2, return 5.

    Note: 
    You may assume k is always valid, 1 ≤ k ≤ array's length. 

 */

class KthlargestElementInAArray {

    public int partition(int[] arr, int k) {
        Arrays.sort(arr);
    }


    // partitions the array based on the first element as PIVOT element
    int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int l = left + 1,
            r = left + 1;
        while(r <= right) {
            if (arr[r] > pivot) {
                r++;
            }
            if (arr[r] < pivot) {
                swap(arr, l, r);
                l++;
                r++;
            }
        }
        swap(arr, left, l - 1);
        return l - 1;
    }

    private void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
