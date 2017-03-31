import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given a large list of numbers. find the 10th largest number from them.
 * There are some bugs here
 *    - Identify them.
 *    - Remember them :)
 */

public class TopKItems {
    private static final int CAPACITY = 100;
    static PriorityQueue<Integer> pq = new PriorityQueue<Integer>(CAPACITY,
            new Comparator<Integer>() {

                public int compare(Integer i1, Integer i2) {   // Descending Order
                    return i2 - i1;
                }
            });

    public static void insert(List<Integer> arr) {
        for (int i : arr)
            pq.offer(i);
    }

    public static int findTheKlargestValue(int K) {
        int cnt = K - 1;
        while (pq.size() > 0 && cnt > 0) {
            pq.poll();
            cnt -= 1;
        }
        return (pq.size() > 0) ? pq.poll() : -1;
    }


    public static void main(String args[]) {
        List<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < 25; i++)
            arr.add(i);
        insert(arr);
        System.out.println(findTheKlargestValue(4));
    }
}
