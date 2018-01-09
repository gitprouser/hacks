
public class NumberOfIslandsUnionFind {
/**
    // version 2: Union Find
    class UnionFind {

        private int[] father = null;
        private int count;

        private int find(int x) {
            if (father[x] == x) {
                return x;
            }
            return father[x] = find(father[x]);
        }

        public UnionFind(int n) {
            // initialize your data structure here.
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        public void connect(int a, int b) {
            // Write your code here
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b) {
                father[root_a] = root_b;
                count--;
            }
        }

        public int query() {
            // Write your code here
            return count;
        }

        public void set_count(int total) {
            count = total;
        }
    }


        /**
         * @param grid a boolean 2D matrix
         * @return an integer
         * /
        public int numIslands(boolean[][] grid) {
            int n = grid.length;
            if (n == 0)
                return 0;
            int m = grid[0].length;
            if (m == 0)
                return 0;
            UnionFind union_find = new UnionFind(n * m);

            int total = 0;
            for(int i = 0;i < grid.length; i++)
                for(int j = 0;j < grid[0].length; j++)
                    if (grid[i][j])
                        total ++;


            union_find.set_count(total);
            for(int i = 0;i < grid.length; i++)
                for(int j = 0;j < grid[0].length; j++)
                    if (grid[i][j]) {
                        if (i > 0 && grid[i - 1][j]) {
                            union_find.connect(i * m + j, (i - 1) * m + j);
                        }
                        if (i <  n - 1 && grid[i + 1][j]) {
                            union_find.connect(i * m + j, (i + 1) * m + j);
                        }
                        if (j > 0 && grid[i][j - 1]) {
                            union_find.connect(i * m + j, i * m + j - 1);
                        }
                        if (j < m - 1 && grid[i][j + 1]) {
                            union_find.connect(i * m + j, i * m + j + 1);
                        }
                    }
            return union_find.query();
        }


    public static void main(String args[]) {
        boolean[][] maze = {
                {true, true, false, false},
                {true, true, false, false},
                {true, true, false, false},
                {true, true, false, false}
        };

        System.out.println(new NumberOfIslandsUnionFind().numIslands(maze));
    }
*/


    class UnionFind {
        private int[] father = null;
        private int count = 0;

        private int find(int x) {
            if (father[x] == x)
                return x;

            return father[x] = find(father[x]);
        }

        public UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        public void connect(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);

            if (root_a != root_b) {
                father[root_a] = root_b;
                count--;
            }
        }

        public int query() {
            return count;
        }

        public void setCount(int total) {
            count = total;
        }
    }



    public int numIslands(char[][] grid) {
        int rowsLength = grid.length;
        int colsLength = grid[0].length;

        if (rowsLength == 0 || colsLength == 0)
            return 0;

        UnionFind unionFind = new UnionFind(rowsLength * colsLength);

        int total = 0;

        for (int r = 0; r < rowsLength; r++) {
            for (int c = 0; c < colsLength; c++) {
                if (grid[r][c] == '1') {
                    total += 1;
                }
            }
        }

        unionFind.setCount(total);

        // magic arrays
        //          Top, down, left, right
        int[] dx = {  0,    0,    -1,    1};
        int[] dy = { -1,    1,     0,    0};

        for (int r = 0; r < rowsLength; r++)
            for (int c = 0; c < colsLength; c++)
                if (grid[r][c] == '1') {



                    for (int k = 0; k < dx.length; k++) {
                        int nx = r + dx[k];
                        int ny = c + dy[k];

                        if (isNotOutOfBounds(nx, ny, rowsLength, colsLength)   // - Check if the neighbor is *NOT* out_of_bounds
                                && grid[nx][ny] == '1')                        // - Check if the neighbor grid is
                                                                               //       actually open to traverse there

                        {
                            unionFind.connect(r * colsLength + c, nx * colsLength + ny);
                        }
                    }
                }


        return unionFind.query();
    }

    public boolean isNotOutOfBounds(int x, int y, int rowsLength, int colsLength) {
        return (x >= 0 && x < rowsLength
                && y >= 0 && y < colsLength);
    }


    public static void main(String args[]) {
        char[][] maze = {
                {'1', '1', '0', '0'},
                {'1', '1', '0', '0'},
                {'1', '1', '0', '0'},
                {'1', '1', '0', '0'},
        };

        System.out.println(new NumberOfIslandsUnionFind().numIslands(maze));
    }
}
