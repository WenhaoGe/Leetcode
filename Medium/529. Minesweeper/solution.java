class Solution {
    int[][] di = { { 1, 0 }, { 1, 1 }, { 1, -1 }, { 0, 1 }, { 0, -1 }, { -1, 0 }, { -1, 1 }, { -1, -1 } };
    int m, n;

    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        char[][] ans = new char[m][n];
        if (board == null || board.length == 0) {
            return ans;
        }
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        }
        if (board[x][y] == 'E') {
            dfs(board, x, y);
        }
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'E') {
            return;
        }
        int num = findBombs(board, x, y);

        if (num == 0) {
            board[x][y] = 'B';
            for (int[] each : di) {
                int newx = x + each[0];
                int newy = y + each[1];
                dfs(board, newx, newy);
            }
        } else {
            board[x][y] = (char) (num + '0');
        }
    }

    private int findBombs(char[][] board, int x, int y) {
        int ans = 0;
        for (int[] each : di) {
            int newx = x + each[0];
            int newy = y + each[1];
            if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
                if (board[newx][newy] == 'M' || board[newx][newy] == 'X') {
                    ans += 1;
                }
            }
        }
        return ans;
    }
}