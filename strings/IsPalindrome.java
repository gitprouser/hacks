/**
 * Created on 7/14/16.
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("racecare"));
    }

    static boolean isPalindrome(String str) {
        if (str.isEmpty() || str.length() == 1) {
            return true;
        } else {
            return str.charAt(0) == str.charAt(str.length() - 1) &&
                    isPalindrome(str.substring(1, str.length() - 1));
        }
    }
}
