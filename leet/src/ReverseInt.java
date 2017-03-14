/**
 * Created dgayash on 3/9/17.
 */
public class ReverseInt {

    public static void main(String[] args) {
        long i = 123456789l;

        System.out.println("original string:" + i);
        System.out.println("original string:" + reverse(i));
    }

    public static long reverse(long l) {
        long result = 0;
        long xl = Math.abs(l);
        while(xl > 0) {
            result = result * 10 + xl % 10;
            xl /= 10;
        }
        return result;
    }
}
