/**
 * Created on 7/23/16.
 * Input: 10?
 */

// Output: 101, 100
//
//
//
// i.e. ? behaves like a wild-card. There are two possibilities for 10?, when that ? is replaced with either 0 or 1.
//
//
//
// Input: 1?0?
//
// Output: 1000, 1001, 1100, 1101
//
//
//
// Please write a program that takes given strings as input and produces the suggested output.

public class WildCard {

    public static void main(String[] args) {
        String s = "0?0?";
        wildCard(s);
    }

    public static void wildCard(String s) {
        _wildCard(s, "");
    }

    public static void _wildCard(String str, String curr) {
        if (str.length() == 0) {
            System.out.println(curr);
        }
        else {
            char digit = str.charAt(0);
            if (digit == '?') {
                _wildCard(str.substring(1), curr.concat("0"));
                _wildCard(str.substring(1), curr.concat("1"));
            } else {
                _wildCard(str.substring(1), curr.concat(digit + ""));
            }
        }
    }

}
