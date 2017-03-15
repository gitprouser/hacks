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
        printSinusoidalString();
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
}
