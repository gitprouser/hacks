/**
 * Created dgayash on 11/28/16.
 */

import java.util.Queue;
import java.util.LinkedList;

public class MazeProblem {
    static class Pair {
        public int x;
        public int y;

        public Pair(int a, int b) {
            x = a;
            y = b;
        }
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int findMinNumSteps(int[][] maze, int rows, int columns, int exitRow, int exitCol) {
        // WRITE YOUR CODE HERE

        Queue<Pair> q = new LinkedList<>();
        if (maze[0][0] == 1) {
            return -1;
        }
        q.offer(new Pair(0, 0));
        maze[0][0] = 1;
        int steps = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Pair pair = q.poll();
                int x = pair.x;
                int y = pair.y;
                if (x == exitRow && y == exitCol) {
                    return steps;
                }
                if (x + 1 < rows && maze[x + 1][y] == 0) {
                    maze[x + 1][y] = 1;
                    q.offer(new Pair(x + 1, y));
                }
                if (y + 1 < columns && maze[x][y + 1] == 0) {
                    maze[x][y + 1] = 1;
                    q.offer(new Pair(x, y + 1));
                }
                if (x - 1 >= 0 && maze[x - 1][y] == 0) {
                    maze[x - 1][y] = 1;
                    q.offer(new Pair(x - 1, y));
                }
                if (y - 1 >= 0 && maze[x][y - 1] == 0) {
                    maze[x][y - 1] = 1;
                    q.offer(new Pair(x, y - 1));
                }
            }
            steps++;
        }
        return -1;
    }
    // METHOD SIGNATURE ENDS
}
