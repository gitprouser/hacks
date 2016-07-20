/**
 *   Find minimum distance between two words (order preserved) in a big string. 
 *   For e.g 1. "hello how are you" - distance between "hello" and "you" is 3. 
 *   e.g 2. "hello how are hello you" - distance is 1 
 *   e.g 3. "you are hello" - distance is -1. Order of "hello" and "you" should be preserved. 
 *   e.g 4. "hello how are hello" - distance is -1 since "you" didnt occur even once.
 */


public class MinimumDistance {
    public static int minimumDistance(String str, String w1, String w2) {
        String[] words =  str.split("[ \t]+"); 
        int d = -1;
        int i = 0;
        int w1_idx = -1, w2_idx = -1;
        for (String word : words) {
            if (word.equals(w1)) 
               w1_idx = i;
            if (word.equals(w2)) 
               w2_idx = i; 
        
            if (w1_idx != -1 && w2_idx != -1) {
                d = (w2_idx - w1_idx) > 0 ? (w2_idx - w1_idx) :  -1;
            }   
            i++; 
        }
        return d;
    }

    public static void main(String args[]) {
        String test_01 = "hello how are you";
        String test_02 = "hello how are hello you";
        String test_03 = "you are hello";
        String test_04 = "hello how are hello";
        String test_05 = "you you hello hello";
        String test_06 = "hello hello you you";
        String w1 = "hello";
        String w2 = "you";
        
        System.out.println(minimumDistance(test_01, w1, w2));
        System.out.println(minimumDistance(test_02, w1, w2));
        System.out.println(minimumDistance(test_03, w1, w2));
        System.out.println(minimumDistance(test_04, w1, w2));
        System.out.println(minimumDistance(test_05, w1, w2));
        System.out.println(minimumDistance(test_06, w1, w2));
    }
}
