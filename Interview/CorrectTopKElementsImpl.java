import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// Given a list of intergers, pick the top n elemts from the list.
/**
 For top K elements you want a *MIN HEAP* with only K elements. What's left in the PQ will be Top K Elements.
 For bottom K elements you want a *MAX HEAP* with ONLY K elements. What's left in the PQ will Bottom K elements.
*/
public class CorrectTopKElementsImpl {
    // O(NLogN)
    // O(N) 
    static PriorityQueue<Integer> topNElements = new PriorityQueue<>();
    static PriorityQueue<Integer> bottomNElements = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    // 1,3,6,3,7,8,9
    // top 3
    // 7, 8, 9
    public static void insertTopNElements(List<Integer> arr, int N) {
        for (int i : arr) {
            // If the priority queue is not filled to N, you simply need to add all elements into the PQ.
            if (topNElements.size() < N)
                topNElements.offer(i);

            if (topNElements.size() == N && i > topNElements.peek()) {
                // Optimization if the element is *GREATER* than the top element in PQ.
                // 1.) Add the current element because it's bigger than the smallest element in the queue.
                // 2.) Remove the smallest element in the queue to get back the size of the PQ to N.
                topNElements.offer(i);
                topNElements.poll();                               // If size of PQ increases more than top N then remove item from PQ.
            }
        }
    }

    public static void insertBottomNElements (List<Integer> arr, int N) {
        for (int i : arr) {
            // If the priority queue is not filled to N, you simply need to add all elements into the PQ.
            if (bottomNElements.size() < N)
                bottomNElements.offer(i);


            // Optimization if the element is greater than the top element in PQ.
            // 1.) Add the current element because it's *SMALLER* than the smallest element in the queue.
            // 2.) Remove the smallest element in the queue to get back the size of the PQ to N.
            if (bottomNElements.size() == N && i < bottomNElements.peek()) {
                bottomNElements.offer(i);
                bottomNElements.poll();
            }
        }
    }

    public static List<Integer> topNElements(int N, List<Integer> arr) {
        insertTopNElements(arr, N);
        List<Integer> result = new ArrayList<>();
        while (topNElements.size() > 0)
            result.add(topNElements.poll());
        return result;
    }

    public static List<Integer> bottomNElements(int N, List<Integer> arr) {
        insertBottomNElements(arr, N);
        List<Integer> result = new ArrayList<>();
        while (bottomNElements.size() > 0)
            result.add(bottomNElements.poll());
        return result;
    }


    public static void main(String args[]) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            arr.add(i);
        List<Integer> resultTop = topNElements(3, arr);
        List<Integer> resultBottom = bottomNElements(3, arr);
        System.out.println("===");
        for (int i : resultTop)
            System.out.print(i + ", ");

        System.out.println("\n===");
        for (int i : resultBottom)
            System.out.print(i + ". ");
    }
}
