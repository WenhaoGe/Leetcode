/**
 * TC: O(n*n)
 * SC: O(1)
 */

class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int index = 0;
    public int[][] generateMatrix(int n) {
        
        
        int[][] ans = new int[n][n];
        int x = 0;
        int y = -1;
        
        for (int i = 1; i <= n * n; i++) {
            int[] dir = dirs[index];
            
            int newx = x + dir[0];
            int newy = y + dir[1];
            if (newx < 0 || newy < 0 || newx == n || newy == n || ans[newx][newy] != 0) {
                if (index == 3) {
                    index = 0;
                    dir = dirs[index];
                } else {
                    dir = dirs[++index];
                }
                newx = x + dir[0];
                newy = y + dir[1];
            }
            ans[newx][newy] = i;
            x = newx;
            y = newy;
        }
        return ans;
    }
}