/**
 * Created dgayash on 3/29/17.
 */
public class Simple {
    public static void main(String[] args) {
        String s = "abc";
        int[] a = {1,2,4};
//        System.out.println(rollTheString(s, a));

//        System.out.println(_rec(8, 0));
        int[] wheels = {6, 15, 8, 20};
        for (int i : wheels(wheels))
            System.out.println(i);
    }
//
//    static String rollTheStringv1(String s, int[] roll) {
//        if (roll == null || roll.length == 0)
//            return s;
//
//        StringBuilder sb = new StringBuilder(s);
//        for (int i = 0; i < roll.length; i++) {
//            for (int j = 0; j < roll[i]; j++) {
//                int k = sb.charAt(j) + 1;
//                if (k >= 'a' + 26)
//                    k = ((k - 'a') % 26) + 'a';
//                char c = (char) (k) ;
//                sb.setCharAt(j, c);
//            }
//        }
//        return sb.toString();
//    }
//
//
//    static String rollTheString(String s, int[] roll) {
//        if (roll == null || roll.length == 0)
//            return s;
//
//
//        StringBuilder sb = new StringBuilder(s);
//        for (int i = 0; i < roll.length; i++) {
//            for (int j = 0; j < roll[i]; j++) {
//                if (j < s.length()) {
//                    int k = sb.charAt(j) + 1;
//                    if (k >= 'a' + 26)
//                        k = ((k - 'a') % 26) + 'a';
//                    char c = (char) (k) ;
//                    sb.setCharAt(j, c);
//                }
//            }
//        }
//        return sb.toString();
//
//
//
//        if (roll == null || roll.length == 0)
//            return s;
//
//        int[] dp = new int[s.length()];
//        StringBuilder sb = new StringBuilder(s);
//        for (int i  = 0; i < roll.length; i++) {
//            for (int j = 0; j < i; j++) {
//                dp[i] += 1;
//            }
//        }
//        for (int j = 0; j < dp.length; j++) {
//            int k = sb.charAt(j) + dp[j];
//            if (k >= 'a' + 26)
//                k = ((k - 'a') % 26) + 'a';
//            sb.setCharAt(j, (char) k);
//        }
//        return sb.toString();
//
//
//
//
//
//        StringBuilder sb = new StringBuilder(s);
//        for(int i = 0; i < dp.length; i++) {
//            int k = sb.charAt(j) + 1;
//
//        }
//
//        for (int i = 0; i < roll.length; i++) {
//            for (int j = 0; j < roll[i]; j++) {
//                if (j < s.length()) {
//                    int k = sb.charAt(j) + 1;
//                    if (k >= 'a' + 26)
//                        k = ((k - 'a') % 26) + 'a';
//                    sb.setCharAt(j, (char) k);
//                }
//            }
//        }
//        return sb.toString();
//    }


//    static int dpWheels(int wheels) {
//        int[] arr = new int[wheels + 1];
//        arr[0] = Integer.MAX_VALUE;
//        arr[1] = Integer.MAX_VALUE;
//        arr[2] = 1;
//        arr[3] = Integer.MAX_VALUE;
//        arr[4] = 2;
//
//
//        for (int i = 5; i< )
//        return arr[wheels];
//    }

    static int[] wheels(int[] wheels) {
        int[] result = new int[wheels.length];
        for (int j = 0; j < wheels.length; j++) {
            int cnt = 0;
            for (int i = 0; i <= wheels[j] / 4; i++) {
                int total_less_four_wheels = wheels[j] - i * 4;
                for (int k = 0; k <= total_less_four_wheels / 2; k++) {
                    int total_less_two_wheels = total_less_four_wheels - k * 2;
                    if (total_less_two_wheels == 0)
                        cnt++;
                }
            }
            result[j] = cnt;
        }
        return result;
    }

    static int _rec (int amt, int cnt) {
        if (amt == 0)
            return cnt + 1;
        if (amt < 0)
            return 0;

        else {
            return _rec(amt - 4, cnt) + _rec(amt - 2, cnt);
        }
//        int cnt = 0;
//        while ( Math.pow (2, cnt) <= amt)
//            cnt += 1;
//
//        return cnt - 1;
    }



}
