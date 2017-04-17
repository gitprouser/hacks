import java.util.ArrayList;
import java.util.List;


/**
 *  Word Squares

 Given a set of words (without duplicates), find all word squares you can build from them.
 A sequence of words forms a valid word square if the kth row and column read
 the exact same string, where 0 ≤ k < max(numRows, numColumns).
 For example, the word sequence ["ball","area","lead","lady"] forms a word square
 because each word reads the same both horizontally and vertically.

 b a l l
 a r e a
 l e a d
 l a d y

 Note:
 There are at least 1 and at most 1000 words.
 All words will have the exact same length.
 Word length is at least 1 and at most 5.
 Each word contains only lowercase English alphabet a-z.
 Example 1:
 Input:
 ["area","lead","wall","lady","ball"]

 Output:
 [
    [
        "wall",
        "area",
        "lead",
        "lady"
    ],
    [
        "ball",
        "area",
        "lead",
        "lady"
    ]
 ]

 Explanation:
 The output consists of two word squares. The order of output does not
 matter (just the order of words in each word square matters).

 Example 2:
 Input:
 ["abat","baba","atan","atal"]

 Output:
 [
    [
        "baba",
        "Shade"
        "baba",
        "Atan"
    ],
    [
        "baba",
        "Shade"
        "baba",
        "atal"
    ]
 ]

 Explanation:
 The output consists of two word squares. The order of output does not
 matter (just the order of words in each word square matters).
 */
public class WordSquare {
    static class TrieNode {
        List<String> startWith;
        TrieNode[] children;

        TrieNode() {
            startWith = new ArrayList<>();
            children = new TrieNode[26];
        }
    }

    static class Trie {
        TrieNode root;

        Trie(String[] words) {
            root = new TrieNode();
            for (String w : words) {
                TrieNode cur = root;
                for (char ch : w.toCharArray()) {
                    int idx = ch - 'a';
                    if (cur.children[idx] == null)
                        cur.children[idx] = new TrieNode();
                    cur.children[idx].startWith.add(w);
                    cur = cur.children[idx];
                }
            }
        }

        List<String> findPrefix(String prefix) {
            List<String> ans = new ArrayList<>();
            TrieNode cur = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (cur.children[idx] == null)
                    return ans;

                cur = cur.children[idx];
            }
            ans.addAll(cur.startWith);
            return ans;
        }
    }

    public static List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();
        if (words == null || words.length == 0)
            return ans;
        int n = words.length;
        int len = words[0].length();
        Trie trie = new Trie(words);
        List<String> ansBuilder = new ArrayList<>();
        for (String w : words) {
            ansBuilder.add(w);
            search(words, n, len, trie, ans, ansBuilder);
            ansBuilder.remove(ansBuilder.size() - 1);
        }

        return ans;
    }

    private static void search(String[] ws, int n, int len, Trie tr,
                        List<List<String>> ans, List<String> ansBuilder) {
        if (ansBuilder.size() == len) {
            ans.add(new ArrayList<>(ansBuilder));
            return;
        }

        int idx = ansBuilder.size();
        StringBuilder prefix = new StringBuilder();
        for (String s : ansBuilder)
            prefix.append(s.charAt(idx));
        List<String> startWith = tr.findPrefix(prefix.toString());
        for (String sw : startWith) {
            ansBuilder.add(sw);
            search(ws, n, len, tr, ans, ansBuilder);
            ansBuilder.remove(ansBuilder.size() - 1);
        }
    }

    public static void main(String[] args) {
        String[] s = {"ball", "area", "lead", "lady"};
        for (List<String> list : wordSquares(s)) {
            for (String l : list) {
                System.out.println(l);
            }
        }
    }
}
