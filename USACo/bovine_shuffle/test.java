/**
    ID: your_id_here
    LANG: JAVA
    TASK: test
*/

import java.io.*;
import java.util.*;

class test {

  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("shuffle.in"));

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
        // out.println(Integer.parseInt(st.nextToken()));      // output result
        // f.readLine();
    }


    int[] result = new int[N];
    for (int i = 0; i < N; i++) {
        result[cows[0][i] - 1] = cows[1][i];
    }

    Arrays.sort(result);
    for(int i : result)
        out.println(i);
    // for (int i = 0 ; i < 2; i++)  {
    //     for (int j = 0; j < N; j++) {
    //         System.out.print(cows[i][j] + " " );
    //     }
    //         System.out.println();
    // }


    // int i2 = Integer.parseInt(st.nextToken());   // second integer
    // out.println(i1+i2);                          // output result
    // out.println(N);                                // output result

    out.close();                                    // close the output file

  }

}

