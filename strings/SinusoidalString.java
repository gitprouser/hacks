/**
 * Print a sinusoidal string
 *
 * 'SnakeString' :This is a puzzle disguised as a programming problem.
 * 'SnakeString'. The phrase "LinkedIn Bought" should be printed as follows
 * Sustitute " " (space) is the word separator
 *
 *
 *     n      I      o      t
 *   i   k  d  n   B  u   h
 * L      e      ~      g
 */
public class SinusoidalString {
    final static String SPACE_7 = "       ";
    final static String SPACE_5 = "     ";
    final static String SPACE_3 = "   ";
    final static String SPACE_1 = " ";

    public static void main(String[] args) {
//        printSinusoidalString();
//        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(countAndSay(1));
    }


    /**
     * For this problem think of this problem in terms of layers...
     * Layer 0 :   start from 2 and print every 4th character
     * Layer 1 :   start from 1 and print every 2nd character
     * Layer 2 :   start from 0 and print every 4th character
     */
    public static void printSinusoidalString() {
        String str = "LinkedIn Bought";
        StringBuilder sb = new StringBuilder();

        sb.append(SPACE_3);
        for (int i = 2; i < str.length(); i += 4) {
            if (str.charAt(i) == ' ')
                sb.append("~");
            else
                sb.append(str.charAt(i));
            sb.append(SPACE_7);
        }
        sb.append("\n");
        sb.append(SPACE_1);
        for (int i = 1; i < str.length(); i += 2) {
            if (str.charAt(i) == ' ')
                sb.append("~");
            else
                sb.append(str.charAt(i));
            sb.append(SPACE_3);
        }
        sb.append("\n");

        for (int i = 0; i < str.length(); i += 4) {
            if (str.charAt(i) == ' ')
                sb.append("~");
            else
                sb.append(str.charAt(i));
            sb.append(SPACE_7);
        }
        System.out.println(sb.toString());
    }

    public static String convert(String src, int numRows) {
        if (src == null) {
            return null;
        }
        if (numRows == 1) {
            return src;
        }
        StringBuilder dest = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            int count = i;
            while (count < src.length()) {
                dest.append(src.charAt(count));
                if (i != 0 && i != numRows - 1) {
                    int position = count + 2 * (numRows - 1) - 2 * i;
                    if (position < src.length()) {
                        dest.append(src.charAt(position));
                    }
                }
                count = count + 2 * (numRows - 1);
            }
        }
        return dest.toString();
    }

    public static String countAndSay(int n) {
        if (n == 0 || n == 1) {
            return "" + n;
        }
        StringBuilder s2 = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            StringBuilder s1 = s2;
            s2 = s2.delete(0, s2.length());
            int count = 1;
            for (int j = 1; j < s1.length(); j++) {
                if (s1.charAt(j) == s1.charAt(j-1)) {
                    count++;
                } else {
                    s2 = s2.append(count);
                    s2 = s2.append(s1.charAt(j-1));
                    count = 1;
                }
            }
            s2 = s2.append(count);
            s2 = s2.append(s1.charAt(s1.length() - 1));
        }
        return s2.toString();
    }

}
