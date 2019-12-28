/**
 * TC: O(n * m)
 * SC: 
 */

class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    public void solve(char[][] board) {
        
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            if ( board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, rows - 1, j);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
        return;
        
    }
    private void dfs(char[][] board, int x, int y) {
        
        board[x][y] = '*';
        for (int[] dir: dirs) {
            int newx = x + dir[0];
            int newy = y + dir[1];
            if (inArea(board, newx, newy)) {
                if (board[newx][newy] == 'O') {
                    dfs(board, newx, newy);
                }
            }
        }
    }
    private boolean inArea(char[][] board, int x, int y) {
        
        int rows = board.length;
        int cols = board[0].length;
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}