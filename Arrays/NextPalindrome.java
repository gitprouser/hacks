/** 

Given a number, find the next smallest palindromic number, larger than this number.

e.g
    Input: 23545
    Output: 23632 (This is a palindromic number, and bigger than the input. There is no palindromic number less than this and bigger than the input) 

    Input: 99
    Output: 101

    Input: 6789876
    Output: 6790976 (Note that the input may or may not be a palindrome itself)

    Input: 8998 (Note that input can have even number of digits)
    Output: 9009

Solution: http://www.geeksforgeeks.org/given-a-number-find-next-smallest-palindrome-larger-than-this-number/

*/

public class NextPalindrome {

    static int bruteForce(int num) {
        while (isPalindrome(num++)) ;
        System.out.println(num);
        return num;
    }

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
        assert 101 == bruteForce(99);
    }

}
