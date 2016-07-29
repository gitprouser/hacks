import java.util.Objects;

/**
 * Created on 7/28/16.
 */
public class SortAndRelatedProblems {
    public static void main(String[] args) {
        int[] a = {11, 14, 25, 6, -10, 9, -1};
//        System.out.println(" Rank of a[0]=11 is '" + rank(a, a[0]) + "'");
//        int[] a = {1, 2, 3, 4, 5, 6};
//        bubbleSort(a);
//        for(int i : a)
//            System.out.print(i + " ");
//        quickSort(a, 0, a.length - 1);
//        for(int i : a)
//            System.out.print(i + " ");

//        int[] a1 = {1,12,13,14};
//        int[] a2 = {5};
//        for (int i : merge(a1, a2))
//            System.out.print(i + " ");

        binarySearch(a, 0, a.length, 6);
    }


    /**
     * Child's play...
     * @param a
     */
    public static void bubbleSort(int[] a) {
        for(int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] >= a[j]) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    /**
     * Very imp Uber and Facebook question. Check class for more details.
     * @param a input Array
     * @param k Key for which you have to find the rank.
     * @return
     */
    static int rank(int[] a, int k) {
        int i = 1;
        for (int j = a.length - 1; i <= j; ) {
            if (a[i] > k) {
                swap(a, i, j);
                j--;
            } else if (a[j] <= k) {
                swap(a, i, j);
                i++;
            } else {
                i++;
                j--;
            }
        }
        return i - 1;
    }

    /**
     * Not working FIX
     * TODO FIX Quicksort
     * @param arr
     * @param start
     * @param end
     */
    static void quickSort(int[] arr, int start, int end) {
        if (start == end || start > end || (end - start) == 1)
            return;
        int pivot = arr[0];
        int i = 1;
        for (int j = arr.length - 1; i <= j; ) {
            if (arr[i] >= pivot) {
                swap(arr, i, j);
                j--;
            }
            else if (arr[j] < pivot) {
                swap(arr, j, i);
                i++;
            }
            else {
                i++;
                j--;
            }
        }

        swap(arr, i, 0);

        quickSort(arr, 0, i - 1);
        quickSort(arr, i + 1, arr.length - 1);
    }

    static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    static int[] merge(int[] a1, int[] a2) {
        int i =0, j = 0, k = 0;
        int[] result = new int[a1.length + a2.length];
        while(i < a1.length && j < a2.length) {
            if (a1[i] <= a2[j])
                result[k++] = a1[i++];

            else if (a2[j] < a1[i])
                result[k++] = a2[j++];
        }
        while(j < a2.length) {
            result[k++] = a2[j++];
        }
        while(i < a1.length)
            result[k++] = a1[i++];
        return result;
    }


    /**
     * Binary Search
     */
    static void binarySearch(int[] data, int start, int end, int value) {
        if (start > end || end < start) {
            return;
        }
//        System.out.println(start + " " + end);
        int mid = start + (end - start) / 2;
        if (data[mid] == value) {
            System.out.println("I found the element at: " + mid);
            return;
        }
        binarySearch(data, start, mid, value);
        binarySearch(data, mid + 1, end, value);
    }
}
