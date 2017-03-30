
// Given a list of intergers, pick the top n elemts from the list.
public class TopNElements {
    // O(NLogN)
    // O(N) 
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

   // 1,3,6,3,7,8,9
   // top 3
   // 7, 8, 9
    public static void insert(List<Integer> arr, int N) {            
        for (int i : arr) {
            if (i > pq.peek()) {       // Optimization to check if the element is actually worth getting into the PQ.
                pq.offer(i);
                if (pq.size() > N)
                    pq.poll();         // If size of PQ increases more than top N then remove item from PQ.
            }
        }
    }


    public static List<Integer> topNElements(int N, List<Integer> arr) {
        insert(arr, N);
        List<Integer> result = new ArrayList<>();
        result.addAll(pq);
        return result;
        /*
        while (pq.size() > 0) {
            result.add(pq.poll());
        }*/
    }


    public static void main(String args[]) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 100; i++) 
            arr.add(i);
        List<Integer> result = topNElements(10, arr);
    }
}
