import java.util.Random;

/**
 * Created on 8/6/16.
 */
public class SortingAlgo {

    static void selectionSort(int[] a) {
        for(int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min]))
                    min = j;
            }
            swap(a, i , min);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        Random random = new Random();
        for (int i = 0; i < a.length; i ++)
            a[i] = random.nextInt(1000);
        print("Before", a);
        selectionSort(a);
        print("After selection sort:", a);
    }

    static void print(int[] a) {
        print("", a);
    }

    static void print(String title, int[] a) {
        System.out.println(title);
        for(int i = 0; i < a.length; i ++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    static boolean less(int i, int j) {
        return (i <= j);
    }
}
