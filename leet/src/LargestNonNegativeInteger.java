import java.util.Arrays;
import java.util.Comparator;

/**
 * Write a function that given a list of non negative integers, arranges them such
 * that they form the largest possible number. For example, given [50, 2, 1, 9],
 * the largest formed number is 95021.
 */

public class LargestNonNegativeInteger {
    static Integer[] arr = {50, 2, 1, 9123,12,51246};

    public static void main(String args[]) {
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String v1 = o1.toString();
                String v2 = o2.toString();

                return (v1 + v2).compareTo(v2 + v1) * -1;
            }
        });

        for (int i : arr) {
            System.out.print(i);
        }
    }

}
