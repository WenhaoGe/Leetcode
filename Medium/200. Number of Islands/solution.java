class Solution {
    int[][] di = {{-1, 0}, {1,0},{0,1},{0,-1}};
    int len, width;
    public int numIslands(char[][] grid) {
        len = grid.length;
        if(len == 0) {
            return 0;
        }
        width = grid[0].length;
        boolean[][] visited = new boolean[len][width];
        for(int i = 0; i<len;i++) {
            for(int j = 0; j<width;j++) {
                visited[i][j] = false;
            }
        }
        int ans = 0;
        for(int i = 0; i<len;i++) {
            for(int j = 0; j< width;j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    ans++;
                    dfs(grid, i, j, visited);
                } 
            }
        }
        return ans;
    }
    private void dfs(char[][] grid, int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        for(int i = 0; i< 4;i++) {
            int newx = x + di[i][0];
            int newy = y + di[i][1];
            if(inArea(newx, newy)) {
                if(grid[newx][newy] == '1' && !visited[newx][newy]) {
                    dfs(grid, newx, newy, visited);
                }
            }
        }
        return;
    }
    private boolean inArea(int x, int y) {
        return x >= 0 && x < len && y >= 0 && y < width;
    }
}