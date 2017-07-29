class Manacher {

    private int[] p;      // p[i] = length of longest palindromic substring of t, centered at i
    private String s;     // original String
    private char[] t;     // tranformed string


    public Manacher(String s) {
        this.s = s;
        preprocess();
        p = new int[t.length];

        // right is the wing span index and center is the index
        // of the string from which palindromic substring in checked.
        int center = 0, right = 0;
        for (int i = 1; i < t.length - 1; i++) {
            int mirror = 2*center - i; // "mirror" is the mirror of "i" centered at "center"


            // Updating the longest palindromic string at point i because you found the right
            // wing to be longer than the current position i.
            // When updating the value you are purposfully underestimating the
            // value of the right wing, just to play it safe,
            // by taking the lowest value between left wing (copying left wing value)
            //             or currRight wing length whichever is lower than what you have now.
            if (right > i)
                p[i] = Math.min(right - i, p[mirror]);


            while(t[i + (1 + p[i])] == t[i - (1 + p[i])])
                p[i]++;   // Increment the wings out on both sides by 1.

            // if palindrome centered at i expands past right,
            // adjust center based on expanded palindrome.
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
    }


    // Transform s into t.
    // For example, if s = "abba", then t = "$#a#b#b#a#@"
    // the # are interleaved to avoid even/odd-length palindromes 
    // uniformly 
    // $ and @ are prepended and appended to each end to avoid bounds
    // checking
    private void preprocess() {
        t = new char[s.length()*2 + 3]; 
        t[0] = '$';
        t[s.length()*2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            t[2*i + 1] = '#';
            t[2*i + 2] = s.charAt(i);
        }
        t[s.length()*2 + 1] = '#';
    }

    // longest palindromic substring
    public String longestPalindromicSubstring() {
        int length = 0; // length of longest palindromic substring
        int center = 0; // center of longest palindromic substring
        for (int i = 1; i < p.length - 1; i++) {
            if (p[i] > length) {
                length = p[i];
                center = i;
            }
        }
        int startIdx = (center - 1 - length) / 2;
        int endIdx = (center - 1 + length) / 2;
        return s.substring(startIdx, endIdx);
    }


    // longest palindromic substring centered at index i/2
    public String longestPalindromicSubstring(int i) {
        int length = p[i + 2];
        int center = i + 2;
        int startIdx = (center - 1 - length) / 2;
        int endIdx = (center - 1 + length) / 2;
        return s.substring(startIdx, endIdx);
    }

    public static void main(String args[]) {
        String s = "abba";
        Manacher manacher = new Manacher(s);
        System.out.println(manacher.longestPalindromicSubstring());
        for (int i = 0; i < 2 * s.length(); i++) 
            System.out.println(i + ": " + manacher.longestPalindromicSubstring(i));
    }
}
