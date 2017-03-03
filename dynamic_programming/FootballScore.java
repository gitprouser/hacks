/**
 * Created on 8/11/16.
 */
public class FootballScore {

    public static int recursion(int score) {
        if (score == 0)
            return 1;
        if (score < 0)
            return 0;
        return recursion(score - 7) + recursion(score - 3) + recursion(score - 2);
    }

    public static int countCombination(int score) {
        int[] comb = new int[score + 1];
        comb[0] = 1;

        for ( int i = 2; i <= score; i ++)
            comb[i] += comb[i - 2];

        for (int i = 3; i <= score; i++)
            comb[i] += comb[i - 3];

        for (int i = 7; i <= score; i++)
            comb[i] += comb[i - 7];

        return comb[score];
    }

    public static int dp_comb(int score) {
        int[] comb = new int[score + 1];

        comb[0] = 1;
        for(int i = 1; i <= score; i++) {
            if (i < 3 && i >= 2)
                comb[i] = comb[i -2];
            if (i < 7 && i >= 3)
                comb[i] = comb[i - 2] + comb[i -3];
            else if (i >= 7)
                comb[i] = comb[ i - 7] + comb[ i - 3] + comb[i - 2];
        }
        return comb[score];
    }

    public static void main(String[] args) {
        System.out.println(recursion(10));
        //        System.out.println(countCombination(10));
        System.out.println(dp_comb(10));
    }


}
