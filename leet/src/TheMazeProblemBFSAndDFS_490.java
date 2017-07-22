/**
 * Leet code maze problem: "https://leetcode.com/articles/the-maze/"
 * 
 * There is a ball in a maze with empty spaces and walls
 * 
 * The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall
 * 
 * When the ball stops, it could choose the next direction
 *
 * Given the ball's start position, the destination and the maze, determine
 * whether the ball could stop at the destination
 *
 * The maze is represented by a binary 2D array 
 * 1 means the wall and 0 means the empty space 
 *
 * You may assume that the borders of the maze are all walls
 * 
 * The start and destination coordinates are represented by row and column
 * indexes.
 *
 */


import java.util.*;

public class TheMazeProblemBFSAndDFS_490 {

    static class Tuple {
        int _1, _2;
        Tuple(int x, int y) {
            this._1 = x;
            this._2 = y;
        }

        public Tuple withTuple(int x, int y) {
            return new Tuple(x, y); 
        }

        @Override
        public String toString() {
            return "Tuple_row:" + _1 + " Tuple_col:" + _2;
        }

        public boolean equals(Tuple that) {
            return this._1 == that._1 && this._2 == that._2;
        }
    }

    public static boolean dfs(int[][] maze,
            Tuple start,
            Tuple des,
            List<Tuple> visitedPos) 
    {
        int maxRows = maze.length;
        int maxCols = maze[0].length; 

        Stack<Tuple> stack = new Stack();
        stack.push(start);
        while (!stack.isEmpty()) {
            Tuple currPos = stack.pop();
    
            // isDestination
            if (currPos.equals(des)) {
                System.out.println("Found Destination: " + currPos);
                System.out.println("CurrPos : " + currPos);
                return true; 
            }

            // boundary conditions
            if (isNotOutOfBounds(currPos, maxRows, maxCols)) {
                System.out.println("out of bounds" + currPos);
                return false;
            }
            // go left
            if (isNotOutOfBounds(withTuple(currPos._1, currPos._2 - 1), maxRows, maxCols)) {
                maze[currPos._1][currPos_2 - 1] = 1;  // block that position in the maze 
                currPos = withTuple(currPos._1 , currPos._2 - 1);
                stack.push(currPos);
                System.out.println(currPos); 
            }

            // go right
            if (isNotOutOfBounds(withTuple(currPos._1, currPos._2 + 1, maxRows, maxCols))) 
                stack.push(withTuple(currPos._1, currPos._2 + 1));

            // go down
            if (isNotOutOfBounds(withTuple(currPos._1 + 1, currPos._2, maxRows, maxCols)))
                stack.push(withTuple(currPos._1 + 1, currPos._2));
            // go up 
            if (isNotOutOfBounds(withTuple(currPos._1 - 1, currPos._2, maxRows, maxCols)))
                stack.push(withTuple(currPos._1 - 1, currPos._2));
        }

        return false;
    }

    public static void main(String args[]) {
        int[][] maze = {{0, 0, 1, 0, 0}, 
                        {0, 0, 0, 0, 0}, 
                        {0, 0, 0,-1, 0}, 
                        {1, 1, 0, 1, 1}, 
                        {0, 0, 0, 0, 0}};  
        System.out.println("Hello World");
        dfs(maze, , null, null); 
    }
    
    private static boolean isNotOutOfBounds(Tuple curr,
            int rowMax, int colMax) {
        return !(curr._1 > rowMax || curr._2 > colMax); 
    }
}
