
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

	
	// Adam's Solution: 
	static String longestSub(String strText) {
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        int longest = Integer.MIN_VALUE;
        String longestSub = null;
        int maxLen = Integer.MIN_VALUE;
        // both l and r start at the beginning
        for (int l = 0, r = 0; r < strText.length() ; ) {
            
            //int size = map.size();
            if (map.size() < 3) { // while in control, we increment r
                char c = strText.charAt(r);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
                if (map.size() < 3 && r - l + 1 > maxLen) {  // Check if the map.size() increase 
                    maxLen = r - l + 1;
                    longestSub = strText.substring(l, r + 1);
                }
                r++;
            } else { // map.size() == 3, we move l forward
                char c = strText.charAt(l);
                int count = map.get(c);
                if (count == 1) {
                    map.remove(c);
                } else {
                    map.put(c, count - 1);
                }
                l++;
            }
        }
        return longestSub;
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
	// System.out.println(startIdx + " " + endIdx);
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
