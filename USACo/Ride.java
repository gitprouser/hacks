/*
ID: ramlinu2
LANG: JAVA
TASK: ride
*/
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created on 8/21/16.
 */
public class ride {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        char[] comet = scanner.nextLine().toCharArray();
        char[] group = scanner.nextLine().toCharArray();
        int cometSum = calSum(comet);
        int groupSum = calSum(group);

//        System.out.println(cometSum + " " + groupSum);
        String result = (cometSum == groupSum)?  "GO" : "STAY";
        out.println(result);
        out.close();
    }

    private static int calSum(char[] charArray) {
        int cometInt = 1;
        for (char c : charArray) {
            cometInt *=  (c - 'A' + 1);
        }
        return cometInt % 47;
    }
}
