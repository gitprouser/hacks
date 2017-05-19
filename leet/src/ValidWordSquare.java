import java.util.*;

class ValidWordSquare {

    public static void main(String args[]) {
        List<String> words = Arrays.asList("ball","area","lead","lady");
        assert(validWordSquare(words)); 
        System.out.println("testCase_1:" + validWordSquare(words)); 
 
        words = null;
        assert(validWordSquare(words)); 
        System.out.println("testCase_2:" + validWordSquare(words)); 
 
        words = Arrays.asList("area","lead","ball","lady");
        assert(validWordSquare(words) == false); 
        System.out.println("testCase_3:" + validWordSquare(words)); 
 
        words = Arrays.asList("area","lady");
        // assert(validWordSquare(words));
        System.out.println("testCase_4:" + validWordSquare(words)); 
 
        words = Arrays.asList("ba","ab");
        // assert(validWordSquare(words));
        System.out.println("testCase_5:" + validWordSquare(words)); 
 
        words = Arrays.asList("b");
        assert(validWordSquare(words));
        System.out.println("testCase_6:" + validWordSquare(words)); 
 
        words = Arrays.asList("area", "my");
        assert(validWordSquare(words) == false);
        System.out.println("testCase_7:" + validWordSquare(words)); 
 
        words = Arrays.asList("area", "my", "a", "b", "c");
        assert(validWordSquare(words) == false);
        System.out.println("testCase_8:" + validWordSquare(words)); 
    }

    public static boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0
                || words.size() == 1 && words.get(0).length() == 1) 
            return true;

        for (String str : words) {
            if (str.length() != words.size())
               return false;
        }

        boolean isValid = true;
        for (int i = 0; i < words.size(); i++) {
           for (int j = 0; j < words.size(); j++) {
                isValid &= (words.get(i).charAt(j) ==  words.get(j).charAt(i));
           }
        }
        return isValid;
    }
}
