import java.io.IOException;

/**
 * Created on 8/16/16.
 */
public class TestTryCatchFinally {
    public static void main(String[] args) {
        System.out.println(test());
    }
    public static boolean  test() {
        try {
            int i = 10;
            System.out.println("Inside Try");

            if (i % 9 == 0) {
                System.out.println("inside try clause");
                return true;
            } else {
                System.out.println("before exception being thrown");
                throw new IOException();
            }


        } catch (IOException e) {
            System.out.println("inside catch");
            return false;
        } finally {
            System.out.println("finally");
        }
    }
}
