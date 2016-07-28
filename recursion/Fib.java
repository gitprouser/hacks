/**
 * Created on 7/26/16.
 */
public class Fib {
    public static void main(String[] args) {
        System.out.println(fib(3));
    }

    /**
     * This is a O(n) solution for the fibonacci number generation.
     * @param n
     * @return
     */
    static long fib(int n) {
        if (n < 2) {
            return n;
        } else {
            int n_2 = 1, n_1 = 1, n_0 = 0;
            int i = n;
            while (--i > 0) {
                System.out.println(" " + i);
                n_2 = n_1 + n_0;
                n_0 = n_1;
                n_1 = n_2;
            }

            return n_2;
        }
    }
}
