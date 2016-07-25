import java.util.Scanner;

/**
 * Created on 7/24/16.
 */
public class MatchParanthesis {
    public static void main(String[] args) {
        int N = 3;
        for(int i = 1; i <= N; i++)
            buildParam(i);
    }

    public static void buildParam(int N) {
        _buildParan("", N, N);
    }

    public static void _buildParan(String curr, int l, int r) {
        if(l == 0 && r == 0) {
            System.out.println(curr);
        } else {
            if (l > 0)
                _buildParan(curr + "(", l - 1, r);
            if (l < r)
                _buildParan(curr+")", l, r - 1);
        }
    }
}
