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
        g = Arrays.copyOf(grid, grid.length* grid[0].length);

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
}
