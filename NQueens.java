public class NQueens {

    public static void main(String[] args) {
        String[] s = {"1", "2", "3", "4"};
        printPermutations(s);
    }
    private static void printPermutations(Object[] arr) {
        printPermutations(arr, 0);
    }

    private static void printPermutations(Object[] arr, int i) {
        if (i == arr.length) {
            for (Object obj : arr) System.out.print(" " + obj);
            System.out.println(); 
        }
   
        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            if (isNQueens(arr, i))
                printPermutations(arr, i+1);
            swap(arr, i, j);
        }
    }


    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static boolean isNQueens(Object[] arr, int nextQueen) {
        int[] str = new int[arr.length];

        for(int i = 0; i < arr.length; i++)
            str[i] = Integer.parseInt((String)arr[i]);

        for(int j = 0; j < nextQueen; j++) {
                if (str[nextQueen] == (str[j] - (nextQueen - j)))
                    return false;
                if (str[nextQueen] == str[j] + (nextQueen  - j))
                    return false;
        }
        return true;
    }
}
