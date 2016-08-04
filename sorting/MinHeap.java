import java.util.Random;

/**
 * Created on 8/3/16.
 */
public class MinHeap {
    static final int INPUT_ARRAY = 100000;
    static final int TOP_K_ELEMENTS = 9;
    static final int LARGEST_RANDOM_NUMBER = 100000;

    static Random random = new Random();

    public static void main(String[] args) {
        int[] a = new int[INPUT_ARRAY];
        for (int i = 0; i < a.length; i++)
            a[i] = random.nextInt(LARGEST_RANDOM_NUMBER);
        print("original",a);
        minHeap(a);
    }

    // prints the top 5 elements in the given array.
    static void minHeap(int[] a) {
        int[] result;
        if (TOP_K_ELEMENTS % 2 == 0)
            result  = new int[TOP_K_ELEMENTS + 2]; // REMEMBER THE NUMBER NEEDS TO BE A MULTIPLE OF TWO
        else
            result = new int[TOP_K_ELEMENTS + 1];
        /**
         * if 10
         * then
         *    parent   left child       right child
         *      (i)       (2*i)          (2*i + 1)
         *      1           2               3
         *      2           4               5
         *      3           6               7
         *      4           8               9
         *      5           10              11
         *
         *      You were getting an offset by 1 wherein if the TOP_K results were:
         *          - Even you were missing the last element, so you need TOP_K_ELEMENTS + 2 as the size of the array.
         *          - Odd you were missing the last element, so you need TOP_K_ELEMENTS + 1 as the size of the array.
         *
         */

        for(int i = 1; i < result.length; i++)
            result[i] = a[i - 1];
        print("initial Result", result);

        for(int i = TOP_K_ELEMENTS; i < a.length; i++) {
            heapify(result);
            if(a[i] > result[1])
                result[1] = a[i];
        }
        heapify(result);
        print("FINAL", result);
    }

    static void heapify(int[] result) {
        while(isNOTHeapify(result)) {
            for (int i = 1; i < result.length/2; i++) {
                if (result[i] > result[2 * i])
                    swap(result, i, 2 * i);
                if (result[i] > result[(2 * i) + 1])
                    swap(result, i, 2 * i + 1);
            }
        }
    }

    static boolean isNOTHeapify(int[] result) {
        for(int i = 1; i < result.length / 2; i++){
            if (result[i] > result[2 * i])
                return true;
            if (result[i] > result[2 * i + 1])
                return true;
        }
        return false;
    }

    static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    static void print(String s, int[] result) {
        System.out.println("-- " + s + "--");
        for(int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
        System.out.println();
    }
}
