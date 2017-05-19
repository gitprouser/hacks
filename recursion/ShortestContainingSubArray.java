import java.util.*;

public class ShortestContainingSubArray {
    public static class Pair {
        public Pair(int l, int r) {
            left = l;
            right = r;
        }

        int left, right;
    }

    public static Pair shortestContainingSubArray(char[] array, Set<Character> set) {
        int left;
        for (left = 0; left < array.length; ++left) {
            if (set.contains(array[left]))
                break;
        }

        if (left == array.length)
            return null;

        if (set.size() == 1)
            return new Pair(left, left);

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(array[left], 1);
        int missing = set.size() - 1;
        Pair result = null;

        for (int right = left + 1; right < array.length; ++right) {
            char c = array[right];
            if (!set.contains(c))
                continue;

            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);

            if (count == 0)
                missing--;

            if (missing > 0)
                continue;

            for (; ; ++left) {
                c = array[left];
                if (!set.contains(c))
                    continue;

                if (result == null || right - left < result.right - result.left)
                    result = new Pair(left, right);

                count = map.get(c);
                map.put(c, --count);

                if (count == 0) {
                    missing = 1;
                    for (++left; ; ++left)
                        if (set.contains(array[left]))
                            break;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int errors = 0;
        for (int i = 0; i < tests.length; ++i) {
            char[] array = tests[i].array.toCharArray();
            HashSet<Character> set = new HashSet<Character>();
            for (Character c : tests[i].set.toCharArray())
                set.add(c);
            Pair result = shortestContainingSubArray(array, set);
            if (result == null) {
                if (tests[i].left != -1) {
                    System.out.println("Error: result of test case number " + (i + 1));
                    errors++;
                }
            } else if (result.left != tests[i].left || result.right != tests[i].right) {
                System.out.println("Error: result of test case number " + (i + 1));
                errors++;
            }
        }

        if (errors > 0)
            System.out.println("Got " + errors + " errors");
        else
            System.out.println("Good work");
    }

    private static TestCase tests[] = {
            new TestCase("abc", "abc", 0, 2),
            new TestCase("abcdefabcdef", "c", 2, 2),
            new TestCase("abcdefgh", "j", -1, Integer.MAX_VALUE),
            new TestCase("", "a", -1, Integer.MAX_VALUE),
            new TestCase("abcccccdefg", "dc", 6, 7),
            new TestCase("abcccccdeeeeeefg", "dec", 6, 8),
            new TestCase("ababababcddd", "abc", 6, 8),
    };

    private static class TestCase {
        public TestCase(String a, String s, int l, int r) {
            array = a;
            set = s;
            left = l;
            right = r;
        }

        String array, set;
        int left, right;
    }
}