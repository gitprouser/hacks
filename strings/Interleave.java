public class Interleave {

    public static void main(String args[]) {
        System.out.println(isInterleave("rBiW5dvcUZoeuhKpVDZXZKBH", 
                                        "TQroWEm8lXElCcAa9CQDA5FGMrakbU", 
                                        "TQroWErmB8lXElCCAiW5advc9UZoeuCQDA5hKFGpMVraDkZbUXZKBH"));
    }

    public static int isInterleave(String a, String b, String c) {
        int hash_a = hash(a);
        int hash_b = hash(b);
        int hash_c = hash(c);
        return (hash_c == hash_a + hash_b)? 1 : 0;
    }
 
    private static int hash(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += s.charAt(i) - 'A' + 1;
        }
        return result;
    }
}
