/**
 * Created on 7/26/16.
 *
 Run Length Encoding (RLE) ++

 (This problem is not exactly RLE, but it's very similar. Basic RLE is actually a trivial problem; but this
 one here is slightly more complicated)
 L10n, is called a Numeronym of the word Localization, where 10 stands for the number of letters between
 the first 'L' and the last 'n' in the word.

 Generate all such possible Numeronyms for any given string (character array). for eg. for "nailed" :

 "n4d"
 "na3d", "n3ed"
 "n2led", "na2ed", "nai2d"
e.g. for the word "batch"
 "b3h"
 "ba2h" "b2ch"
 etc.

 Print progressively longer strings, until there is a '2' in the permutations.
 There is no point of going below 2, because that won't compress the string.

 Solution: Take inspiration from http://www.careercup.com/question?id=5733696185303040
 */
public class RELString {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
        String s = "batch";
        for (int i = s.length() - 2; i > 1; i--) {
            for ( int j = 1; j + i < s.length(); j++) {
                System.out.println(
                        s.substring(0, j)
                        + i + s.substring(j + i, s.length())
                );
            }
        }
    }
}
