public class Solution {
    int y;          // The height of the given grid
    int x;          // The width of the given grid
    char[][] g;     // The given grid, stored to reduce recursion memory usage
 
    /**
     * Given a 2d grid map of '1's (land) and '0's (water),
     * count the number of islands.
     *
     * This method approaches the problem as one of depth-first connected
     * components search
     * @param grid, the given grid.
     * @return the number of islands.
     */
    public int numIslands (char[][] grid) {
        // Store the given grid
        // This prevents having to make copies during recursion
        g = deepCopy(grid);

        // Our count to return
        int c = 0;

        // Dimensions of the given graph
        y = g.length;
        if (y == 0) return 0;
        x = g[0].length;

        // Iterate over the entire given grid
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (g[i][j] == '1') {
                    dfs(i, j);
                    c++;
                }
            }
        }
        return c;
    }

    /**
     * Marks the given site as visited, then checks adjacent sites.
     *
     * Or, Marks the given site as water, if land, then checks adjacent sites.
     *
     * Or, Given one coordinate (i,j) of an island, obliterates the island
     * from the given grid, so that it is not counted again.
     *
     * @param i, the row index of the given grid
     * @param j, the column index of the given grid
     */
    private void dfs (int i, int j) {
        // Check for invalid indices and for sites that aren't land
        if (i < 0 || i >= y || j < 0 || j >= x || g[i][j] != '1')
			return;

		// Mark the site as visited
        g[i][j] = '0';

        // Check all adjacent sites
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
	
    public static char[][] deepCopy(char[][] original) {
        if (original == null) {
            return null;
        }
    
        final char[][] result = new char[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }	
	
}

/** 

public class Solution {
    
    public int numIslands(char[][] grid) {
        int cnt = 0;
        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;

        char[][] g = deepCopy(grid);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (g[i][j] == '1') {
                    _DFS(g, i, j);
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    private void _DFS (char[][] arr, int i, int j) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] != '1')
            return;

        arr[i][j] = '0';

        _DFS(arr, i + 1, j);
        _DFS(arr, i, j + 1);
        _DFS(arr, i - 1, j);
        _DFS(arr, i, j - 1);
    }
    
    private void printMatrix(char[][] g) {
        for(int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                System.out.print( "[i=" + i + ", j=" + j + "]");
                System.out.print(g[i][j] + " ");
            } System.out.println();
        }
    }
    
    public static char[][] deepCopy(char[][] original) {
        if (original == null)
            return null;
    
        final char[][] result = new char[original.length][];
        for (int i = 0; i < original.length; i++)
            result[i] = Arrays.copyOf(original[i], original[i].length);

        return result;
    }
}

*/
