
/** 

Longest Substring with At Most Two Distinct Characters

Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 
For example, Given s = “eceba”,
 
T is "ece" which its length is 3.
 
* If there are no such substrings (all same characters), then print nothing
* If there multiple such strings, then print any one
 
Solution: Take inspiration from: http://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/

*/


class LongestSubstringAtLeastKRepeatingChars {
    public static void main(String args[]) {
        //          0123456789 
        String s = "xyzaaaabbcccccccccc";
        assert isValid(s, 0, 2, 3) == 3;
        assert isValid(s, 3, 8, 2) == 2;
        assert  isValid(s, 3, 18, 3)  == 3;
        // assert isValid(s, 7, 18, 2);
        // assert isValid(s, 9, 18, 1);
        // assert !isValid(s, 9, 18, 0); System.out.println(longestSubstring(s, 1));
        System.out.println(__longestSubstring(s, 2));
        System.out.println(longestSubstring(s, 2));
        System.out.println(longestSubstring(s, 3));
        System.out.println(longestSubstring("abbaxy" , 2));
        System.out.println(longestSubstring("aaaaaaaabbbbbbb", 2));
        System.out.println(longestSubstring("ttttttt", 2));
    }

    public static int __longestSubstring(String s, int k) {
        int slow = 0, fast = 1, globalMax = 0; 
        while (slow < fast && slow < s.length() && fast < s.length()) {
           	int cnt = isValid(s, slow, fast, k);
			if ( cnt <= k) {
                fast += 1; 
                //globalMax = Math.max(globalMax, fast - slow + 1); 
				if (cnt == k && globalMax < fast - slow + 1) {
					globalMax = fast - slow + 1;
				}
            } else {
                slow += 1;
            }
        }
        return globalMax;
    }

    public static String longestSubstring(String s, int k) {
       	String result = ""; 
		int slow = 0, fast = 1, globalMax = 0;
        while (slow <= fast && slow < s.length() && fast < s.length()) {
           	int cnt = isValid(s, slow, fast, k); 
			if (cnt <= k) {
               	fast += 1;
                // globalMax = Math.max(globalMax, fast - slow + 1); 
                if (cnt == k && globalMax < fast - slow + 1) {
                    result = s.substring(slow, fast);
                    globalMax = fast - slow + 1;
                }
            } else {
                slow += 1;
            }
        }
        return result;
    }



    static int isValid(String s, int startIdx, int endIdx, int k) {
        int[] arr = new int[26]; 
        int cnt = 0;
//		System.out.println(startIdx + " " + endIdx);
        for (int i = startIdx; i <= endIdx; i++) {
            int val = arr[s.charAt(i) - 'a'];
            if (val == 0) {
                cnt += 1;
                arr[s.charAt(i) - 'a'] += 1;
            }
        }

//        for (int i = 0; i < arr.length; i++) 
//            System.out.print(" - " + arr[i]);
//        System.out.println();
        return cnt;
    }

}
