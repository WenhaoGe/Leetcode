class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = costs[0][j];
        }
        for (int i = 1; i < m; i++) {
            // red
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            // blue
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            // green
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + costs[i][2];
        }
        return min(dp[m - 1][0], dp[m - 1][1], dp[m - 1][2]);
    }

    private int min(int i, int j, int k) {
        return Math.min(i, Math.min(j, k));
    }
}