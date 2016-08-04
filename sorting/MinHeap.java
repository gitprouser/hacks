import java.util.Random;

/**
 * Created on 8/3/16.
 */
public class MinHeap {
    static final int INPUT_ARRAY = 100000;
    static final int TOP_K_ELEMENTS = 10;
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
        int[] result = new int[TOP_K_ELEMENTS + 2];

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
