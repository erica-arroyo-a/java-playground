class NumberOfIslands {
    /*
    Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.

    Example 1:
        Input: grid = [
          ["1","1","1","1","0"],
          ["1","1","0","1","0"],
          ["1","1","0","0","0"],
          ["0","0","0","0","0"]
        ]
        Output: 1

    Example 2:
        Input: grid = [
          ["1","1","0","0","0"],
          ["1","1","0","0","0"],
          ["0","0","1","0","0"],
          ["0","0","0","1","1"]
        ]
        Output: 3
     */
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    dfs(grid, r, c, visited);
                    count++;
                }
            }
        }

        return count;
    }

    // helper function - dfs
    private void dfs(char[][] grid, int r, int c, boolean[][] visited) {
        // boundary checks
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0' || visited[r][c]) {
            return;
        }

        // mark current position as visited
        visited[r][c] = true;

        // recurse to visit all adjacent cells
        dfs(grid, r - 1, c, visited); // Up
        dfs(grid, r + 1, c, visited); // Down
        dfs(grid, r, c - 1, visited); // Left
        dfs(grid, r, c + 1, visited); // Right
    }
}