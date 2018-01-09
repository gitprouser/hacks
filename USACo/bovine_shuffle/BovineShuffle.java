
/**
    ID: your_id_here
    LANG: JAVA
    TASK: test
*/

import java.io.*;
import java.util.*;
import java.util.*;

class BovineShuffle {

  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster

    BufferedReader f;
    if (args.length ==  0)
        f = new BufferedReader(new FileReader("shuffle.in"));
    else
        f = new BufferedReader(new FileReader("shuffle_"+ args[0] + ".in"));

    // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));

    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());

    // Get line, break into tokens
    int N = Integer.parseInt(st.nextToken());      // first integer

    int[][] cows = new int[2][N];

    for (int i = 0; i < 2; i++) {
        st = new StringTokenizer(f.readLine());
        for (int j = 0; j < N; j++)
            cows[i][j] = Integer.parseInt(st.nextToken());
    }


    int[] deShuffle = new int[N];
    for (int i = 0; i < N; i++)
        deShuffle[cows[0][i] - 1] = i + 1;

    int[] result = new int[N];
    System.arraycopy(cows[1], 0, result, 0, N);

    for (int k = 0; k < 3; k++) { // Doing three shuffles
        int[] temp = new int[N];

        for (int i = 0; i < cows[1].length; i++)
            temp[deShuffle[i] - 1] = result[i];

        System.arraycopy(temp, 0, result, 0, N);

        for(int j : result)
            System.out.print(j + " " );
        System.out.println();
    }

    for(int i : result)
        out.println(i);

    out.close();                                    // close the output file
  }

}

