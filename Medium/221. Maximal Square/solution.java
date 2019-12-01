class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < cols; i++) {
          if (matrix[0][i] == '1') {
            dp[0][i] = 1;
          } else {
            dp[0][i] = 0;
          }
        }
        for (int i = 0; i < rows; i++) {
          if (matrix[i][0] == '1') {
            dp[i][0] = 1;
          } else {
            dp[i][0] = 0;
          }
        }
        for (int i = 1; i < rows; i++) {
          for (int j = 1; j < cols; j++) {
            if (matrix[i][j] == '1') {
              dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
            } else {
              dp[i][j] = 0;
            }
          }
        }
        int ans = 0;
        for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
            
            if (dp[i][j] > ans) {
              ans = dp[i][j];
            }
          }
          
        }
        
        return ans * ans;
    }
    private int min(int i, int j, int k) {
        
        return Math.min(i, Math.min(j, k));
    }
}