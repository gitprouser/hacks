public class Adam_strstr_ii {
    /**
     * @param source a source string
     * @param target a target string
     * @return an integer as index
     */
    public int strStr2(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        int m = target.length();
        if (m == 0) {
            return 0;
        }
        int n = source.length();
        if (n == 0) {
            return -1;
        }
        int base = 31;
        int mod = 20017;
        int targetHash = hashCode(target, 0, m - 1, mod, base);
        int sourceHash = hashCode(source, 0, m - 2, mod, base);
        int basePow = basePow(base, m, mod);
        
        for (int i = m - 1; i < n; i++) {
            
            if (i != m - 1) {
                // don't forget to mod here, and don't forget minus 'a'
                // take our the highest order item
                sourceHash = (sourceHash - basePow * (source.charAt(i - m) - 'a')) % mod;
            }
            // don't forget to mod here, and don't forget minus 'a'
            // add the lowest order item and multiply base and all the higher order items
            sourceHash = (sourceHash * base + source.charAt(i) - 'a') % mod;
            if (sourceHash < 0) {
                sourceHash += mod;
            }
            if (targetHash == sourceHash) { // even if hash code is the same
            // we still need to check them char by char, due to collision
                int j = 0;
                for (; j < m; j++) {
                    if (target.charAt(j) != source.charAt(j + i - m + 1)) {
                        break;
                    }
                }
                if (j == m) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }
    private int basePow(int base, int m, int mod) {
        int result = 1;
        for (int i = 0; i < m - 1; i++) { // only power to m - 1
            // don't forget to mod here
            result = (result * base) % mod;
        }
        return result;
    }
    
    private int hashCode(String s, int start, int end, int mod, int base) {
        int result = 0;
        for (int i = start; i <= end; i++) {
            // don't forget to mod here, and don't forget minus 'a'
            result = (result * base + s.charAt(i) - 'a') % mod;
            // there is char value smaller that 'a' in ascii table
            // Java % operator won't deal with negative number, it will
            // just mod the positive number and slap a negative sign to
            // the result
            if (result < 0) {
                result += mod;
            }
        }
        return result;
    }
}
