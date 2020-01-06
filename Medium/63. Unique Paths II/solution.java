/**
 * TC: O(n + m)
 * SC: O(mn)
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] moves = new int[rows][cols];
        
        int i = 0;
        for (;i < cols; i++) {
            if (obstacleGrid[0][i] == 1) {
                moves[0][i] = 0;
                break;
            } else {
                moves[0][i] = 1;
            }
        }
        while (i < cols) {
            moves[0][i++] = 0;
        }
        i = 0;
        for (; i < rows; i++) {
            if (obstacleGrid[i][0] == 1) {
                moves[i][0] = 0;
                break;
            } else {
                moves[i][0] = 1;
            }
            
        }
        while (i < rows) {
            moves[i++][0] = 0;
        }
        for (i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    moves[i][j] = 0;
                } else {
                    moves[i][j] = moves[i - 1][j] + moves[i][j - 1];
                }
            }
        }
        return moves[rows - 1][cols - 1];
    }
}