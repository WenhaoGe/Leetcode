class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int num = 1 + dfs(grid, i, j);
                    ans = Math.max(ans, num);
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {

        grid[i][j] = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int ans = 0;
        for (int[] dir : dirs) {
            int newx = i + dir[0];
            int newy = j + dir[1];
            if (newx >= 0 && newx < rows && newy >= 0 && newy < cols) {
                if (grid[newx][newy] == 1) {

                    ans += 1;
                    ans += dfs(grid, newx, newy);
                }
            }
        }
        if (ans != 0) {
            return ans;
        }
        return 0;
    }
}