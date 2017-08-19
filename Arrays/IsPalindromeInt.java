public class IsPalindromeInt {

    static boolean isPalindrome(int numb) {
        int tmp = numb;
        int rev = 0;
        while (tmp > 0) {
            int dig = tmp % 10;
            rev = rev * 10 + dig;
            tmp /= 10;
        }
        return numb == rev;
    }

    public static void main(String args[]) {
        assert isPalindrome(123321);
        assert isPalindrome(123321);
    }

}
