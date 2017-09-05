class RadixSort {
    public static void main(String args[]) {
        // int[] arr = {877,567,3456,876,467,26,934,9876,1,4567};
        for (int i : arr) System.out.println(i);
    }

    public static void sort( int[] a) {
        int i, m = a[0], exp = 1, n = a.length;
        int[] b = new int[10];
        for (i = 1; i < n; i++)
            if (a[i] > m)
                m = a[i];
        while (m / exp > 0) {
            int[] bucket = new int[10];
            for (i = 0; i < n; i++)
                bucket[(a[i] / exp) % 10]++;
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            for (i = 0; i < n; i++)
                a[i] = b[i];
            exp *= 10;
        }
    }

/**
    public static byte getBit(byte ID, int pos) {
        return (ID >> pos) & 1;
    }
*/
}
