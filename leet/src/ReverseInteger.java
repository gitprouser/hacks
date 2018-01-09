/*

7. Reverse integer

*/
class ReverseInteger {

    public int reverse(int x) {
        boolean neg = false;
        if (x < 0) {
            neg = true;
            x = -x;
        }

        /*
        int res = 0;
        while (x != 0) {
            res = res * 10 + (x % 10);
            x /= 10;
            if (res < 0) {
                return 0;
            }
        }*/

        String xStr = String.valueOf(x);
        StringBuilder sb = new StringBuilder(xStr);
        sb.reverse();
        int res = 0;
        try {
            res = Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return 0;
        }
        /*
        if (res < 0) {
            return 0;
        }*/
        if (neg) {
            res = -res;
        }
        return res;
    }

}
